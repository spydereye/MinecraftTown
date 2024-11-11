package net.spydereye.firstmod;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraftforge.common.world.StructureModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import java.lang.reflect.*;

import java.util.Optional;

public class StructureLayoutGen {

    public static final DeferredRegister<MapCodec<? extends StructureModifier>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_MODIFIER_SERIALIZERS, ExampleMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }

    public static void placeStructure(ServerLevel world, BlockPos pos, String structureName) {
        // Load the structure
        ResourceLocation location = ResourceLocation.tryBuild(ExampleMod.MOD_ID, structureName);
        StructureTemplate template = null;
        if (location != null ) {

            // Get an Optional<StructureTemplate> from the StructureManager
            Optional<StructureTemplate> templateOptional = Optional.of(world.getStructureManager().getOrCreate(location));


            // Check if the structure template is present
            if (templateOptional.isPresent()) {

                // Extract the StructureTemplate from the Optional
                template = templateOptional.get();
            }

        }
        if (template != null ) {
            // Place the structure at the given position
            System.out.println("The structure has been placed!");

            template.fillFromWorld(
                    world,
                    pos,
                    template.getSize(),
                    true,
                    null// Set a flag (2 means force block updates)
            );
            System.out.println(template.placeInWorld(world,pos, pos, new StructurePlaceSettings(), world.random, 2));
        }


    }
}
