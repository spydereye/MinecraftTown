package net.spydereye.firstmod;

import net.minecraft.core.BlockPos;

import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.server.level.ServerLevel;
@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class WorldGenHandler {
    private static BlockPos pos = new BlockPos(500, 100, 20);
    @SubscribeEvent
    public static void onChunkGenerated(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel) {
            ServerLevel Thisworld = (ServerLevel) event.getLevel();

            // Call placeStructure after chunk generation
            StructureLayoutGen.placeStructure(Thisworld, pos , "sickhouse");
            StructureLayoutGen.HasPlacedStructure = true;
        }

    }
}
