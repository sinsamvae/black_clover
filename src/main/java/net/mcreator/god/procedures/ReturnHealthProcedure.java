package net.mcreator.god.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnHealthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Health: "
				+ (new java.text.DecimalFormat("##").format(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0));
	}
}
