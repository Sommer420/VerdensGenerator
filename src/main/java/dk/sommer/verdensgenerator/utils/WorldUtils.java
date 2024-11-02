package dk.sommer.verdensgenerator.utils;

import eu.okaeri.platform.core.annotation.Component;
import org.bukkit.*;
import org.jetbrains.annotations.Nls;

@Component
public class WorldUtils {
    public static void createWorld(String worldName, String worldType) {
        WorldCreator wc = new WorldCreator(worldName);
        if (worldType.equalsIgnoreCase("void")) {
            wc.generator(new VoidChunkGen());
        } else if (worldType.equalsIgnoreCase("flat")) {
            wc.type(WorldType.FLAT);
            wc.generator(new FlatChunkGen());
        } else {
            try {
                wc.type(WorldType.valueOf(worldType.toUpperCase()));
            } catch (IllegalArgumentException e) {
                Bukkit.getLogger().warning("Invalid world type specified: " + worldType);
                return;
            }
        }

        World world = Bukkit.createWorld(wc);
        if (worldType.equalsIgnoreCase("void")) {
            world.getBlockAt(0, 1, 0).setType(Material.STONE);
        }

        if (world == null) {
            Bukkit.getLogger().warning("Failed to create world: " + worldName);
            return;
        }

        Bukkit.getLogger().info("World created: " + world.getName());
    }

    public static void deleteWorld(@Nls String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            Bukkit.getLogger().warning("Failed to delete world: " + worldName);
            return;
        }
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player.getWorld().equals(world)) {
                player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
            }
        });
        Bukkit.unloadWorld(world, false);
        Bukkit.getServer().unloadWorld(world, false);
        Bukkit.getLogger().info("World deleted: " + world.getName());
    }

}
