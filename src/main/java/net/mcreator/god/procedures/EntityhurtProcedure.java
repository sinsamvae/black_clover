package net.mcreator.god.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.god.network.GodModVariables;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class EntityhurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		ItemStack shield = ItemStack.EMPTY;
		double dodge = 0;
		double hit = 0;
		double wait = 0;
		double armor = 0;
		double Random = 0;
		double resistance_level = 0;
		double count = 0;
		double current_health = 0;
		double health_reduction = 0;
		double dmg = 0;
		dmg = amount;
		((LivingHurtEvent) event).setAmount(((float) 0));
		if (entity.getPersistentData().getBoolean("hit")) {
			entity.getPersistentData().putBoolean("hit", false);
			dmg = dmg + entity.getPersistentData().getDouble("deal");
		}
		armor = entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0;
		dmg = dmg * (100 / (100 + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).defense));
		dmg = dmg * (10 / (10 + entity.getPersistentData().getDouble("level") * 22));
		dmg = dmg * (25 / (25 + armor));
		if (entity instanceof LivingEntity _livEnt6 && _livEnt6.isBlocking()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				shield = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				shield = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
			}
			if (shield.getItem() == Items.SHIELD) {
				dmg = dmg * 0.8;
			}
		}
		if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
			resistance_level = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0;
			dmg = dmg * (4 / (5 + resistance_level));
		}
		if ((entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0) > 0) {
			dmg = dmg - (entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0);
			if (dmg < 0) {
				dmg = 0;
			}
		}
		if (entity instanceof Player) {
			current_health = (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 20;
			current_health = current_health * (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).MaxHealth;
			current_health = current_health - dmg;
			current_health = current_health / (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).MaxHealth;
			current_health = current_health * 20;
			health_reduction = current_health / (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).MaxHealth;
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) current_health);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - dmg));
		}
	}
}
