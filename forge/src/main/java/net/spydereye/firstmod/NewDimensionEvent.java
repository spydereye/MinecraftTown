package net.spydereye.firstmod;

import net.minecraft.client.gui.font.providers.UnihexProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.event.PlayLevelSoundEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spydereye.firstmod.sounds.ModSounds;
import net.spydereye.firstmod.worldgen.dimension.ModDimensions;

@Mod.EventBusSubscriber(modid = firstmod.MOD_ID)
public class NewDimensionEvent {


    @SubscribeEvent
    public static void onPlayerChangeDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {


        if(event.getTo() == ModDimensions.KAUPENDIM_LEVEL_KEY){

            event.getEntity().playSound(ModSounds.LOCUS_WATER.get());
        }

    }
}
