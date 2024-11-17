package net.spydereye.firstmod.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.spydereye.firstmod.sounds.ModSounds;

public class swapPlayersBodyItem extends Item {
    public swapPlayersBodyItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        world.playSound(player, player.blockPosition(), ModSounds.BOOGIE_WOOGIE_CLAP.get(), SoundSource.PLAYERS);
        LivingEntity HitEntity = getLookedAtEntity(player, 100);


        if(HitEntity != null && player.level() instanceof ServerLevel){
            HitEntity.setInvisible(true);
            Vec3 playerPos = player.position();
            Vec3 entityPos = HitEntity.position();

            HitEntity.teleportTo(playerPos.x, playerPos.y, playerPos.z);
            // Teleport the player to the entity's position

            player.teleportTo(entityPos.x, entityPos.y, entityPos.z);
            HitEntity.setInvisible(false);


            // Teleport the entity to the player's original position

        }

        return super.use(world, player, hand);
    }

    public static LivingEntity getLookedAtEntity(Player player, double range) {
        Vec3 start = new Vec3(player.getX(), player.getEyeY(), player.getZ());
        System.out.println(start);// Player's eye position
        Vec3 lookVector = player.getLookAngle().scale(range);
        // Direction the player is looking
        Vec3 end = start.add(lookVector); // End point of the raycast

        ClipContext blockContext = new ClipContext(start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player);
        HitResult blockHit = player.level().clip(blockContext);

        // Adjust end point if a block is hit within the range
        if (blockHit.getType() == HitResult.Type.BLOCK) {
            end = blockHit.getLocation(); // Update end to the block's hit position
        }

        // Check for block collisions along the raycast path
        AABB aabb = new AABB(start, end); // Inflate slightly for easier detection
        LivingEntity closestEntity = null;
        double closestDistance = range;



        // Loop through each living entity in the bounding box
        for (LivingEntity entity : player.level().getEntitiesOfClass(player, aabb) {
            if (entity != player) {
                // Calculate distance from player to entity
                double distanceToEntity = start.distanceTo(entity.position());
                if (distanceToEntity <= closestDistance) {
                    closestEntity = entity;
                    closestDistance = distanceToEntity; // Update closest distance
                }
            }
        }

        return closestEntity; // Return the closest entity in line of sight

    }


}