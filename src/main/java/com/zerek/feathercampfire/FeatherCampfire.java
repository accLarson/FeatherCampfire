package com.zerek.feathercampfire;

import com.zerek.feathercampfire.listeners.BlockPlaceListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeatherCampfire extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
