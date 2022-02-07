package me.techy.iced.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class JoinLeaveEvent implements Listener {
	
	Plugin pl;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		String world = p.getWorld().getName();
		String isp = p.getAddress().getHostName();
		if (p.hasPermission("iced.staff")) {
			e.setJoinMessage("§8(§a+§8) §c§lSTAFF §7" + p.getName());
			Bukkit.getServer().getPluginManager().getPlugin("DenalCore").getLogger().info(p.getName() + " e' entrato (" + world + ", " + isp + ")"); 
		} else if (p.hasPermission("iced.helper")) {
			e.setJoinMessage("§8(§a+§8) §c§lSTAFF §7" + p.getName());
			Bukkit.getServer().getPluginManager().getPlugin("DenalCore").getLogger().info(p.getName() + " e' entrato (" + world + ", " + isp + ")"); 
		} else if (p.hasPermission("iced.vip")) {
			e.setJoinMessage("§8(§a+§8) §d§lVIP §7" + p.getName());
			Bukkit.getServer().getPluginManager().getPlugin("DenalCore").getLogger().info(p.getName() + " e' entrato (" + world + ", " + isp + ")"); 
		} else if (p.hasPermission("iced.media")) {
			e.setJoinMessage("§8(§a+§8) §d§lMEDIA §7" + p.getName());
			Bukkit.getServer().getPluginManager().getPlugin("DenalCore").getLogger().info(p.getName() + " e' entrato (" + world + ", " + isp + ")"); 
		} else {
			e.setJoinMessage("§8(§a+§8) §7" + p.getName());
			Bukkit.getServer().getPluginManager().getPlugin("DenalCore").getLogger().info(p.getName() + " e' entrato (" + world + ", " + isp + ")"); 
		}
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("iced.staff")) {
			e.setQuitMessage("§8(§c-§8) §c§lSTAFF §7" + p.getName());
		} else if (p.hasPermission("iced.helper")) {
			e.setQuitMessage("§8(§c-§8) §c§lSTAFF §7" + p.getName());
		} else if (p.hasPermission("iced.vip")) {
			e.setQuitMessage("§8(§c-§8) §d§lVIP §7" + p.getName());
		} else if (p.hasPermission("iced.media")) {
			e.setQuitMessage("§8(§c-§8) §b§lMEDIA §7" + p.getName());
		} else {
			e.setQuitMessage("§8(§c-§8) §7" + p.getName());
		}
	}
}
