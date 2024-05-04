package org.cloudns.danng.adapters;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Constructor;

public class AdapterLoader {

    private final JavaPlugin plugin;

    public AdapterLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadAdapters() {

        File adaptersFolder = new File(plugin.getDataFolder(), "adapters");
        if (!adaptersFolder.exists() || !adaptersFolder.isDirectory()) {
            // Adapters folder doesn't exist or is not a directory
            return;
        }

        File[] adapterFiles = adaptersFolder.listFiles((dir, name) -> name.endsWith(".java"));
        if (adapterFiles == null) {
            // Error reading adapter files
            return;
        }

        for (File adapterFile : adapterFiles) {
            try {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{adapterFile.toURI().toURL()});
                Class<?> adapterClass = classLoader.loadClass("com.example.adapter.AdapterImpl");

                // Get the constructor that takes a JavaPlugin instance as argument
                Constructor<?> constructor = adapterClass.getConstructor(JavaPlugin.class);

                // Create a new instance using the constructor
                adapterInterface adapter = (adapterInterface) constructor.newInstance(plugin);

                // Use the adapter
                adapter.RunFunction();
            } catch (Exception e) {
                // Error loading or instantiating the adapter
                plugin.getLogger().severe("Error loading adapter: " + e.getMessage());
            }
        }
    }
}