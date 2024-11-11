package net.spydereye.firstmod;

import net.minecraft.core.BlockPos;
import net.minecraft.server.commands.ItemCommands;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.extensions.IForgeCommandSourceStack;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class StructureCommand  {

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {

        ServerLevel Thisworld = (ServerLevel) event.getServer().overworld();
        BlockPos pos = new BlockPos(500, Thisworld.getHeight(), 20);// Call placeStructure after chunk generation
        StructureLayoutGen.placeStructure(Thisworld, pos , "sickhouse");

    }
}
