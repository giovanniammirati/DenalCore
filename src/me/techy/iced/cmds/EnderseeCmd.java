package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class EnderseeCmd implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			final Player target = Bukkit.getPlayer(args[0]);
			if (p.hasPermission("techy.staff")) {
				if (args.length == 0) {
					p.sendMessage("§cUtilizzo: /endersee <giocatore>");
					return true;
				}
				if (target == null) {
					p.sendMessage("§cQuesto giocatore non è online.");
					return true;
				}
				p.openInventory((Inventory) target.getEnderChest());
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			s.sendMessage("§cQuesto comando non è stato ideato per funzionare su Console.");
		}
		return true;
	}
}
	