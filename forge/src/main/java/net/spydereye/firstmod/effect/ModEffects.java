package net.spydereye.firstmod.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spydereye.firstmod.firstmod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, firstmod.MOD_ID);
    public static final RegistryObject<MobEffect> SUPERHOT_EFFECT = MOB_EFFECTS.register("superhot",
            () -> new SuperhotEffect(MobEffectCategory.NEUTRAL, 5635925));




    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
