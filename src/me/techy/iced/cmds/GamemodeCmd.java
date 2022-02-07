package me.techy.iced.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamemodeCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			Player p = (Player) s;
			if (p.hasPermission("iced.staff.gamemode")) {
			if (args.length == 0) {
				p.sendMessage("§cUtilizzo: /gamemode <0 - 3>");
			} else if (args[0].equals("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§eModalità di gioco impostata a sopravvivenza.");
				} else if (args[0].equals("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§eModalità di gioco impostata a creativa.");
				} else if (args[0].equals("2")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§eModalità di gioco impostata ad avventura.");
				} else if (args[0].equals("3")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§eModalità di gioco impostata a spettatore.");
				} else if (args[0].equals("survival")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§eModalità di gioco impostata ad sopravvivenza.");
				} else if (args[0].equals("creative")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§eModalità di gioco impostata a creativa.");
				} else if (args[0].equals("adventure")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§eModalità di gioco impostata ad avventura.");
				} else if (args[0].equals("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§eModalità di gioco impostata a spettatore.");
				} else if (args[0].equals("s")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§eModalità di gioco impostata a sopravvivenza.");
				} else if (args[0].equals("c")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§eModalità di gioco impostata a creativa.");
				} else if (args[0].equals("a")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§eModalità di gioco impostata ad avventura.");
				} else if (args[0].equals("sp")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§eModalità di gioco impostata a spettatore.");
				} else {
					p.sendMessage("§cUtilizzo: /gamemode <0 - 3>");
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
