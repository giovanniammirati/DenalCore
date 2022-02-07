package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ClearChatCmd implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("iced.staff.clearchat")) {
				for (int x = 0; x < 150; x++) {
				    Bukkit.broadcastMessage("");
				}
			    Bukkit.broadcastMessage("§eLa chat è stata pulita da " + p.getName() + "§e.");
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			for (int x = 0; x < 150; x++) {
			    Bukkit.broadcastMessage("");
			}
		    Bukkit.broadcastMessage("§eLa chat è stata pulita da Console.");
		}
		return true;
	}
}
