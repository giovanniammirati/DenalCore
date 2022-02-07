/*
 * DenalCore by TechyBW
 * ATTENZIONE: Questa versione è una fork del plugin TechyCore.
 * Questo plugin non include tutta la parte di management dei client 
 * Bungee e Spigot e la connessione con gli altri plugin.
 */

package me.techy.iced.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.techy.iced.cmds.ClearChatCmd;
import me.techy.iced.cmds.CraftCmd;
import me.techy.iced.cmds.DayCmd;
import me.techy.iced.cmds.EnderchestCmd;
import me.techy.iced.cmds.EnderseeCmd;
import me.techy.iced.cmds.FlyCmd;
import me.techy.iced.cmds.FlySpeedCmd;
import me.techy.iced.cmds.GamemodeCmd;
import me.techy.iced.cmds.GmaClass;
import me.techy.iced.cmds.GmcClass;
import me.techy.iced.cmds.GmsClass;
import me.techy.iced.cmds.GmspClass;
import me.techy.iced.cmds.GodCmd;
import me.techy.iced.cmds.IcedCmd;
import me.techy.iced.cmds.InvseeCmd;
import me.techy.iced.cmds.NightCmd;
import me.techy.iced.cmds.NightVisionCmd;
import me.techy.iced.cmds.PoweroffCmd;
import me.techy.iced.cmds.SaveAllCmd;
import me.techy.iced.cmds.SmiteCmd;
import me.techy.iced.cmds.TimeCmd;
import me.techy.iced.cmds.TpallCmd;
import me.techy.iced.cmds.TphereCmd;
import me.techy.iced.cmds.WeatherCmd;
import me.techy.iced.listeners.JoinLeaveEvent;

public class Main extends JavaPlugin implements Listener {	
	
	Plugin pm;

	private static Main main;
	public static ArrayList<String> godPlayers = new ArrayList<String>();
	
	@Override
	public void onEnable() {
		this.getLogger().info("Loading DenalCore...");
		this.registerCommands();
		this.registerEvents();
        this.getLogger().info("========================================");
        this.getLogger().info("DenalCore by TechyBW enabled.");
		this.getLogger().info("Running on " + Bukkit.getServer().getPort() + ", " + Bukkit.getServer().getBukkitVersion());
        this.getLogger().info("========================================");
	}
	
	public void registerCommands() {
		getCommand("dc").setExecutor(new IcedCmd());
		getCommand("gamemode").setExecutor(new GamemodeCmd());
		getCommand("fly").setExecutor(new FlyCmd());
		getCommand("weather").setExecutor(new WeatherCmd());
		getCommand("gmc").setExecutor(new GmcClass());
		getCommand("gms").setExecutor(new GmsClass());
		getCommand("gma").setExecutor(new GmaClass());
		getCommand("gmsp").setExecutor(new GmspClass());
		getCommand("time").setExecutor(new TimeCmd());
		getCommand("day").setExecutor(new DayCmd());
		getCommand("night").setExecutor(new NightCmd());
		getCommand("nightvision").setExecutor(new NightVisionCmd());
		getCommand("save-all").setExecutor(new SaveAllCmd());
		getCommand("craft").setExecutor(new CraftCmd());
		getCommand("poweroff").setExecutor(new PoweroffCmd());
		getCommand("enderchest").setExecutor(new EnderchestCmd());
		getCommand("clearchat").setExecutor(new ClearChatCmd());
		getCommand("god").setExecutor(new GodCmd());
		getCommand("smite").setExecutor(new SmiteCmd());
		getCommand("tpall").setExecutor(new TpallCmd());
		getCommand("flyspeed").setExecutor(new FlySpeedCmd());
		getCommand("invsee").setExecutor(new InvseeCmd());
		getCommand("endersee").setExecutor(new EnderseeCmd());
		getCommand("tphere").setExecutor(new TphereCmd());
		this.getLogger().info("Commands successfully loaded!");
	}
	
	public void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents((Listener)new JoinLeaveEvent(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new GodCmd(), (Plugin)this);
		this.getLogger().info("Events successfully loaded!");
	}

	@Override 
	public void onDisable() {
		if (Bukkit.getServer().getPluginManager().getPlugin("CraftingStore") == null) {
			this.getLogger().info("Error while disabling DenalCore: CraftingStore not found!");
			this.getLogger().info("DenalCore disabled with errors.");
		} else {
			this.getLogger().info("DenalCore successfully disabled!");	
		}
	}
	
	public static Main getInstance() {
		return main;
	}
}
