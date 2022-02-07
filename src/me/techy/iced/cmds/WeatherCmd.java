package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WeatherCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("iced.staff.weather")) {
				if (args.length == 0) {
					p.sendMessage("§cUtilizzo: /weather <clear - storm>");
				} else if (args[0].equals("clear")) {
			        for (final World w : Bukkit.getWorlds()) {
			            w.setStorm(false);
			            w.setThundering(false);
			        }
					p.sendMessage("§aIl tempo atmosferico è stato cambiato.");
				} else if (args[0].equals("storm")) {
			        for (final World w : Bukkit.getWorlds()) {
			            w.setStorm(true);
			            w.setThundering(true);
			        }
					p.sendMessage("§aIl tempo atmosferico è stato cambiato.");
				} else {
					p.sendMessage("§cUtilizzo: /weather <clear - storm>");	
				}
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			s.sendMessage("§cQuesto comando non e' stato ideato per funzionare su Console.");
		}
		return true;
	}	
}