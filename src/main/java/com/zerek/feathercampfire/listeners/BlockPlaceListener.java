package com.zerek.feathercampfire.listeners;


import org.bukkit.Material;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (event.getBlockPlaced().getType() == Material.CAMPFIRE){
            Campfire campFire = (Campfire) event.getBlockPlaced();
            campFire.setLit(false);
        }
    }
}
