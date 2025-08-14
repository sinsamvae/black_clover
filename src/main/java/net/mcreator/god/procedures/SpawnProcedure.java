package net.mcreator.god.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.god.init.GodModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (entity instanceof PathfinderMob) {
				if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(GodModAttributes.LEVEL.get()))
					_livingEntity2.getAttribute(GodModAttributes.LEVEL.get()).setBaseValue(1);
			} else if (entity instanceof Monster) {
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(GodModAttributes.LEVEL.get()))
					_livingEntity4.getAttribute(GodModAttributes.LEVEL.get()).setBaseValue(3);
			} else if (entity instanceof AbstractGolem) {
				if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(GodModAttributes.LEVEL.get()))
					_livingEntity6.getAttribute(GodModAttributes.LEVEL.get()).setBaseValue(4);
			}
		}
	}
}
