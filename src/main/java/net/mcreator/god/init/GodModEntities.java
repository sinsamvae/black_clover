
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.god.entity.WindSlashEntity;
import net.mcreator.god.entity.WindBladeEntity;
import net.mcreator.god.entity.WindBirdEntity;
import net.mcreator.god.entity.TornadoEntity;
import net.mcreator.god.GodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GodMod.MODID);
	public static final RegistryObject<EntityType<WindSlashEntity>> WIND_SLASH = register("wind_slash",
			EntityType.Builder.<WindSlashEntity>of(WindSlashEntity::new, MobCategory.MISC).setCustomClientFactory(WindSlashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 0.6f));
	public static final RegistryObject<EntityType<WindBirdEntity>> WIND_BIRD = register("wind_bird",
			EntityType.Builder.<WindBirdEntity>of(WindBirdEntity::new, MobCategory.MISC).setCustomClientFactory(WindBirdEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 0.6f));
	public static final RegistryObject<EntityType<TornadoEntity>> TORNADO = register("tornado",
			EntityType.Builder.<TornadoEntity>of(TornadoEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TornadoEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WindBladeEntity>> WIND_BLADE = register("wind_blade",
			EntityType.Builder.<WindBladeEntity>of(WindBladeEntity::new, MobCategory.MISC).setCustomClientFactory(WindBladeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 0.6f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TornadoEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TORNADO.get(), TornadoEntity.createAttributes().build());
	}
}
