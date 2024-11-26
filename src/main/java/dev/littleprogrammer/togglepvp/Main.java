package dev.littleprogrammer.togglepvp;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new pvp(), this);
        getCommand("pvpToggle").setExecutor(new Commands());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[TogglePvp] Plugin Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[TogglePvp] Plugin Shutting down!");
    }
}
