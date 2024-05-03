package org.cloudns.danng;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class test2 extends JavaPlugin {

    @Override
    public void onEnable() {
        //send config loading message
        this.getLogger().info("Loading Config, please wait");
        // Load the config
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();

        // Check if main.enabled is set to false
        if (!config.getBoolean("main.enabled")) {
            // Disable the plugin
            String message = "Please enable the plugin in the config.";
            this.getLogger().info(message);
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Plugin is enabled
        this.getLogger().info("The plugin has been enabled as the config is active");

        // Your other initialization code here

    }}
