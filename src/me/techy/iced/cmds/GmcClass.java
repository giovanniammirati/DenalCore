package me.techy.iced.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GmcClass implements Listener,CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("iced.staff")) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("�eModalit� di gioco impostata a creativa.");
			} else {
				p.sendMessage("�cNon possiedi i permessi necessari per effettuare questo comando.");
			}
		} else {
			s.sendMessage("�cQuesto comando non e' stato ideato per funzionare su Console.");
		}
		return true;
	}
}
	