
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.god.network.SwitchMovesMessage;
import net.mcreator.god.network.OpenMessage;
import net.mcreator.god.network.ExecuteMessage;
import net.mcreator.god.GodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GodModKeyMappings {
	public static final KeyMapping SWITCH_MOVES = new KeyMapping("key.god.switch_moves", GLFW.GLFW_KEY_R, "key.categories.mine_clover") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GodMod.PACKET_HANDLER.sendToServer(new SwitchMovesMessage(0, 0));
				SwitchMovesMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN = new KeyMapping("key.god.open", GLFW.GLFW_KEY_B, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GodMod.PACKET_HANDLER.sendToServer(new OpenMessage(0, 0));
				OpenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXECUTE = new KeyMapping("key.god.execute", GLFW.GLFW_KEY_Z, "key.categories.mine_clover") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GodMod.PACKET_HANDLER.sendToServer(new ExecuteMessage(0, 0));
				ExecuteMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SWITCH_MOVES);
		event.register(OPEN);
		event.register(EXECUTE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SWITCH_MOVES.consumeClick();
				OPEN.consumeClick();
				EXECUTE.consumeClick();
			}
		}
	}
}
