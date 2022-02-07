package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TimeCmd implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (args.length == 0) {
				p.sendMessage("§cUtilizzo: /time <day - night>");
			} else if (p.hasPermission("iced.staff.time")) {
				if (args[0].equals("day")) {
			        for (final World w : Bukkit.getWorlds()) {
			            w.setTime(6000);
			        }
					p.sendMessage("§aIl tempo e' stato impostato a giorno.");
				} else if (args[0].equals("night")) {
			        for (final World w : Bukkit.getWorlds()) {
			            w.setTime(14000);
			        }
					p.sendMessage("§aIl tempo e' stato impostato a notte.");
				} else {
					p.sendMessage("§cUtilizzo: /time <day - night>");
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


