package com.zerek.feathercampfire.listeners;


import org.bukkit.Material;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class BlockPlaceListener implements Listener {

    private static final Set<Material> TYPES = Collections.unmodifiableSet(EnumSet.of(Material.CAMPFIRE, Material.SOUL_CAMPFIRE));

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (TYPES.contains(event.getBlockPlaced().getType()) && event.getItemInHand().getType() != Material.FLINT_AND_STEEL){
            Campfire campfireData = (Campfire) event.getBlockPlaced().getBlockData();
            campfireData.setLit(false);
            event.getBlockPlaced().setBlockData(campfireData);
        }
    }
}
