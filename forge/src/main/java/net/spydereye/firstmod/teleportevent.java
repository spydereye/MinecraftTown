package net.spydereye.firstmod;

import net.minecraft.client.DeltaTracker;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.spydereye.firstmod.sounds.ModSounds;
import net.spydereye.firstmod.worldgen.dimension.ModDimensions;

import java.util.Date;
import java.util.Timer;

import java.util.Timer;
import java.util.TimerTask;

@Mod.EventBusSubscriber(modid = firstmod.MOD_ID)
public class teleportevent {


    @SubscribeEvent
    public static void onTeleportEvent(EntityTeleportEvent.TeleportCommand event) throws InterruptedException {
        System.out.println("you've teleported!");
        Player Pl = (Player) event.getEntity();
        Timer timer = new Timer();
        long delay = 10L;
        TimerTask task = new TimerTask()
        {
            public void run() {
                if(event.getEntity().level().dimension() == ModDimensions.KAUPENDIM_LEVEL_KEY){
                    System.out.println("welcome to kaupendum!");
                    event.getEntity().level().playLocalSound(Pl.position().x, Pl.position().y, Pl.position().z, ModSounds.LOCUS_WATER.get(), SoundSource.NEUTRAL, 1.0f, 1.0f, false);
                }
            }
        };
        timer.schedule(task, delay);

    }

}
