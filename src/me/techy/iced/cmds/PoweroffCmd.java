package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PoweroffCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		if ((s instanceof Player)) {
			final Player p = (Player) s;
			if (p.hasPermission("iced.staff.shutdown")) {
				Bukkit.broadcastMessage("§eSalvataggio dati server in corso...");
				Bukkit.savePlayers();
				p.saveData();
		        for (final World w : Bukkit.getWorlds()) {
		            w.save();
		        }
		        Bukkit.broadcastMessage("§aI dati del server sono stati salvati.");
		        Bukkit.broadcastMessage("§eSpegnimento del server in corso...");
		        for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
		        	p2.kickPlayer("§c§lEspulso dal Server\n\n§7Riavvio in corso...\n§7Riavvio richiesto da §c" + p.getName());
		        }
		        Bukkit.shutdown();
			} else {
				p.sendMessage("Â§cNon possiedi i permessi necessari per effettuare questo comando!");
			}
		} else {
			Bukkit.broadcastMessage("§eSalvataggio dati server in corso...");
			Bukkit.savePlayers();
	        for (final World w : Bukkit.getWorlds()) {
	            w.save();
	        }
	        Bukkit.broadcastMessage("§aI dati del server sono stati salvati.");
	        Bukkit.broadcastMessage("§eSpegnimento del server in corso...");
	        for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
	        	p2.kickPlayer("§c§lEspulso dal Server\n\n§7Riavvio in corso...\n§7Riavvio richiesto da §cConsole");
	        }
	        Bukkit.shutdown();
		}
		return true;
	}
}