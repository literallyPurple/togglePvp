package dev.littleprogrammer.togglepvp;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new pvp(), this);
        getCommand("pvpToggle").setExecutor(new Commands());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[TogglePvp] Plugin Loaded!");
        this.saveDefaultConfig();
        try {
            pvp.onOff = this.getConfig().getBoolean("internal-data.pvp-off");
        } catch (NullPointerException e){
            this.getLogger().severe("FATAL ERROR: INTERNAL-DATA.PVP-OFF RETURNED NULL");
        }

        
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[TogglePvp] Plugin Shutting down!");
        this.getConfig().set("internal-data.pvp-off", pvp.onOff);
        this.saveConfig();

    }
}
