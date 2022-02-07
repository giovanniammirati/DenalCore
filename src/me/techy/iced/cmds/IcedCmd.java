package me.techy.iced.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class IcedCmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
				s.sendMessage("§7§m---------------------------------------------§r");
				s.sendMessage("§3§lDENALCORE §7(§aEnabled§7, Forked from TechyCore)");
				s.sendMessage("§7Plugin Version: §b" + Bukkit.getPluginManager().getPlugin("DenalCore").getDescription().getVersion() + "§b_1.8");
				s.sendMessage("§7Author: §bTechyBW");
				s.sendMessage("§7§m---------------------------------------------§r");
				return true;
	}
}