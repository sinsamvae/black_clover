package net.mcreator.god.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class EntityhurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getAmount());
		}
	}

	public static void execute(double amount) {
		execute(null, amount);
	}

	private static void execute(@Nullable Event event, double amount) {
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
	}
}
