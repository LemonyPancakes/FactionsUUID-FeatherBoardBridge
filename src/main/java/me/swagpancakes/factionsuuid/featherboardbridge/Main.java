package me.swagpancakes.factionsuuid.featherboardbridge;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FactionsUUID-FeatherboardBridge] Plugin has been enabled!");
        if (Bukkit.getPluginManager().getPlugin("AuthMe") != null) {
            this.getServer().getPluginManager().registerEvents(new AuthMe(), this);
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FactionsUUID-FeatherboardBridge] AuthMeReloaded Detected! Hooking into AuthMeReloaded.");
        }else {
            this.getServer().getPluginManager().registerEvents(new EventClass(), this);
        }
        loadConfig();

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[FactionsUUID-FeatherboardBridge] Plugin has been disabled!");

    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();

    }

}