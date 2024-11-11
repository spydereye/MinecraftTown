package net.spydereye.firstmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.event.GatherComponentsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class BoogieWoogie {
    @SubscribeEvent
    public static void OnPlayerInteractEvent(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().is()){

        }
    }
}
