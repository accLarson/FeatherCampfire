package com.zerek.feathercampfire.tasks;

import com.zerek.feathercampfire.FeatherCampfire;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CampfireHealTask implements Runnable{

    private final FeatherCampfire plugin;
    private final int range;


    public CampfireHealTask(FeatherCampfire plugin) {
        this.plugin = plugin;
        this.range = plugin.getConfig().getInt("heal-range");
            }

    @Override
    public void run() {
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            if (checkForCampfire(player.getLocation().getBlock())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1, 1));
            }
        });
    }

    public boolean checkForCampfire(Block start){
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    if (start.getRelative(x, y, z).getType() == Material.CAMPFIRE) return true;
                }
            }
        }
        return false;
    }
}
