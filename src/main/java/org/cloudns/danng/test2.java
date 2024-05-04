package org.cloudns.danng;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;
import org.cloudns.danng.adapters.AdapterLoader ;

public class test2 extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Load the config
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        File adaptersFolder = new File(getDataFolder(), "adapters");
        this.getLogger().info(config.getString("main.message.Mainmessage"));
        // Plugin is enabled


        if (!adaptersFolder.exists()) {
            adaptersFolder.mkdirs(); // Create the directory and any necessary parent directories

            // Your other initialization code here

        }
        this.getLogger().info("Loading test2 plugin adapters...");
        if (config.getBoolean("Main.Toggles.Adapters")) {
            AdapterLoader adapterLoader = new AdapterLoader(this);
            adapterLoader.loadAdapters();
        } else {
            this.getLogger().warning("Adapters have been disabled, please enable in the config");
        }
    }
    }