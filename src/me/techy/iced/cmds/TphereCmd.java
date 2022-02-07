package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TphereCmd implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			final Player target = Bukkit.getPlayer(args[0]);
			if (p.hasPermission("techy.staff")) {
				if (args.length == 0) {
					p.sendMessage("§cUtilizzo: /tphere <giocatore>");
					return true;
				}
				if (target == null) {
					p.sendMessage("§cQuesto giocatore non è online.");
					return true;
				}
				target.teleport(p.getLocation());
				p.sendMessage("§aIl giocatore " + target.getName() + " è stato teletrasportato da te.");
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			s.sendMessage("§cQuesto comando non è stato ideato per funzionare su Console.");
		}
		return true;
	}
}