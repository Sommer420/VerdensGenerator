package dk.sommer.verdensgenerator.utils;

import eu.okaeri.platform.core.annotation.Component;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class FlatChunkGen extends ChunkGenerator {
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        ChunkData chunk = createChunkData(world);
        chunk.setRegion(0, 0, 0, 16, 1, 16, Material.BEDROCK);
        for (int i = 1; i < 2; i++) {
            chunk.setRegion(0, i, 0, 16, i + 1, 16, Material.DIRT);
        }
        chunk.setRegion(0, 4, 0, 16, 5, 16, Material.GRASS);
        return chunk;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Collections.emptyList();
    }
}