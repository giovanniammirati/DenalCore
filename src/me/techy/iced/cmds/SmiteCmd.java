package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SmiteCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
        if (args.length == 0) {
            s.sendMessage("§cUtilizzo invalido.");
            return true;
        }
        if (args.length > 1) {
            s.sendMessage("§cUtilizzo: /smite <giocatore>");
            return true;
        }
        final Player t = Bukkit.getServer().getPlayer(args[0]);
        if (t == null) {
        	s.sendMessage("§cUtilizzo: /smite <giocatore>");
            return true;
        }
        if (!s.hasPermission("techy.staff")) {
        	s.sendMessage("§cNon possiedi i permessi necessari per effettuare questo comando.");
            return true;
        }
        s.sendMessage("§aZeus sta colpendo " + t.getName() + "§a.");
        final Location l = t.getLocation();
        final World w = t.getWorld();
        w.strikeLightningEffect(l);
        return true;
	}
}
