package com.zerek.feathercampfire.tasks;

import com.zerek.feathercampfire.FeatherCampfire;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class CampfireHealTask implements Runnable{

    private static final Set<Material> TYPES = Collections.unmodifiableSet(EnumSet.of(Material.CAMPFIRE, Material.SOUL_CAMPFIRE));
    private final FeatherCampfire plugin;
    private final int range;


    public CampfireHealTask(FeatherCampfire plugin) {
        this.plugin = plugin;
        this.range = plugin.getConfig().getInt("heal-range");
            }

    @Override
    public void run() {
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            if (checkForLitCampfire(player.getLocation().getBlock())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 0));
                player.spawnParticle(Particle.HEART,player.getLocation().getBlock().getRelative(0,1,0).getLocation(),1);
                player.spawnParticle(Particle.GLOW,player.getLocation().getBlock().getRelative(0,1,0).getLocation(),10);
            }
        });
    }

    public boolean checkForLitCampfire(Block start){
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    Material block = start.getRelative(x, y, z).getType();
                    if (TYPES.contains(block)){
                        Campfire campfire = (Campfire) start.getRelative(x, y, z).getBlockData();
                        if (campfire.isLit()) return true;
                    }
                }
            }
        }
        return false;
    }
}
