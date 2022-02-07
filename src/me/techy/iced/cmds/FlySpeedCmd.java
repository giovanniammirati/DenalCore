package me.techy.iced.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FlySpeedCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("techy.staff")) {
				if (p.isFlying()) {
					if (args.length == 0) {
						p.sendMessage("§cUtilizzo: /flyspeed <on - off>");
					} else if (args[0].equals("on")) {
						p.setFlySpeed((float) 0.3f);
						p.sendMessage("§aModalità di volo potenziato abilitata.");
					} else if (args[0].equals("off")) {
						p.setFlySpeed((float) 0.1f);
						p.sendMessage("§cModalità di volo potenziato disabilitata.");
					}
				} else {
					p.sendMessage("§cNon sei in volo.");
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
