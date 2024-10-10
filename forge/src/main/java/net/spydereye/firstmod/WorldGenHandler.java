package net.spydereye.firstmod;

import net.minecraft.core.BlockPos;

import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.server.level.ServerLevel;
@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class WorldGenHandler {

    @SubscribeEvent
    public static void onChunkGenerated(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel && !StructureLayoutGen.HasPlacedStructure) {
            ServerLevel Thisworld = (ServerLevel) event.getLevel();
            BlockPos pos = new BlockPos(500, 100, 20);
            // Call placeStructure after chunk generation
            StructureLayoutGen.placeStructure(Thisworld,pos , "sickhouse.nbt");
        }
    }
}
