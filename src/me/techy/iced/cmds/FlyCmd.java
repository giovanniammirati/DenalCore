package me.techy.iced.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FlyCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("iced.vip")) {
				if (p.getAllowFlight() == true) {
					p.setAllowFlight(false);
					p.sendMessage("§cModalità volo disabilitata.");
				} else {
					p.setAllowFlight(true);
					p.sendMessage("§aModalità volo abilitata.");
				}
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			s.sendMessage("§cQuesto comando non è stato ideato per funzionare su Console.");
		}
		return true;
	}
}
