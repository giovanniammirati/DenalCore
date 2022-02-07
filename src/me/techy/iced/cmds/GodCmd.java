package me.techy.iced.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.techy.iced.utils.Main;

public class GodCmd implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		final Player p = (Player) s;
		if (p.hasPermission("techy.staff")) {
			if (Main.godPlayers.contains(p.getName())) {
				Main.godPlayers.remove(p.getName());
				p.sendMessage("§cModalità Dio disabilitata.");
			} else {
				Main.godPlayers.add(p.getName());
				p.sendMessage("§aModalità Dio abilitata.");
			}
		} else {
			p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
		}
		return true;
	}
	
	  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled=false)
	  public void onDamage(EntityDamageEvent e) {
		    if (e.getEntity() instanceof Player && Main.godPlayers.contains(e.getEntity().getName())) {
		    	e.setCancelled(true);
			    ((Player) e.getEntity()).setHealth(((Player) e.getEntity()).getMaxHealth());
		    }
	  }
}