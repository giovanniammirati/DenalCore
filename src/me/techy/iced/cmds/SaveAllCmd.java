package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveAllCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			final Player p = (Player) s;
			if (p.hasPermission("iced.staff.saveall")) {
				Bukkit.broadcastMessage("§eSalvataggio dati server in corso...");
				Bukkit.savePlayers();
				p.saveData();
		        for (final World w : Bukkit.getWorlds()) {
		            w.save();
		        }
		        Bukkit.broadcastMessage("§aI dati del server sono stati salvati.");
			} else {
				p.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando!");
			}
		} else {
			Bukkit.broadcastMessage("§eSalvataggio dati server in corso...");
			Bukkit.savePlayers();
	        for (final World w : Bukkit.getWorlds()) {
	            w.save();
	        }
	        Bukkit.broadcastMessage("§aI dati del server sono stati salvati.");
		}
		return true;
	}
}
