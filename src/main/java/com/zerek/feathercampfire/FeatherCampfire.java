package com.zerek.feathercampfire;

import com.zerek.feathercampfire.listeners.BlockPlaceListener;
import com.zerek.feathercampfire.tasks.CampfireHealTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeatherCampfire extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(),this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new CampfireHealTask(this),180L, 60L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
