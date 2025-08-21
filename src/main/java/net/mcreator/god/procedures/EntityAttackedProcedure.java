package net.mcreator.god.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.god.network.GodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double damage = 0;
		double hit = 0;
		double dmg = 0;
		if (sourceentity instanceof Player) {
			if (damagesource.is(DamageTypes.PLAYER_ATTACK)) {
				damage = Math.round(0.1 * (sourceentity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).strenght);
				KnockbackProcedure.execute(entity, sourceentity, 0.8);
			}
			entity.getPersistentData().putBoolean("hit", true);
			entity.getPersistentData().putDouble("deal", damage);
		}
	}
}
