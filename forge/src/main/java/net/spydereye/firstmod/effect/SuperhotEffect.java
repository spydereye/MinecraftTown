package net.spydereye.firstmod.effect;

import com.mojang.blaze3d.platform.Lighting;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.LightChunk;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.spydereye.firstmod.firstmod;
import net.spydereye.firstmod.sounds.ModSounds;

public class SuperhotEffect  extends MobEffect {
    int TickTimer = 0;
    public int ZoneRange = 20;
    private boolean isInZone = true;
    public static LivingEntity CurrentEntity;
    public LivingEntity myEntity;
    protected SuperhotEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }
    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int Amplifier){


        double BPS = pLivingEntity.moveDist;
        System.out.println(BPS);



        boolean hasrun = false;
        for (Entity entity : pLivingEntity.level().getEntitiesOfClass(Entity.class, createPlayerBoundingBox(pLivingEntity, ZoneRange))) {
            if (entity != pLivingEntity) {




                entity.setDeltaMovement(entity.getDeltaMovement().normalize().x * BPS,entity.getDeltaMovement().normalize().y * BPS, entity.getDeltaMovement().normalize().z * BPS);

                if(BPS < 0.1){
                    entity.noPhysics = true;
                    entity.setDeltaMovement(0,0,0);





                }
                else{

                    entity.noPhysics = false;

                }


            }
        }
        pLivingEntity.moveDist = 0;
        hasrun = true;
        if (hasrun)return  true;





        return super.applyEffectTick(pLivingEntity, Amplifier);
    }

    public static double getCorrectValue(double Value){
        if(Math.abs(Value) < 0) Value = 0 - Value;
        return Value;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
    public static AABB createPlayerBoundingBox(LivingEntity ThisEntity, double range) {
        // Get the player's position
        Vec3 Epos = ThisEntity.position();

        // Create a bounding box around the player, inflated by the specified range
        return new AABB(
                Epos.x - range, Epos.y - range, Epos.z - range, // Min corner
                Epos.x + range, Epos.y + range, Epos.z + range  // Max corner
        );
    }



}
