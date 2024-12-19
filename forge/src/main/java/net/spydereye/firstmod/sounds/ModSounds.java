package net.spydereye.firstmod.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spydereye.firstmod.firstmod;
import net.spydereye.firstmod.item.ModItems;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, firstmod.MOD_ID);

    public static final RegistryObject<SoundEvent> BOOGIE_WOOGIE_CLAP = registerSoundEvent("boogiewoogieclap");
    public static final RegistryObject<SoundEvent> LOCUS_WATER = registerSoundEvent("locuswatermusic");



    public static final RegistryObject<SoundEvent> registerSoundEvent(String name){
        return  SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(firstmod.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
