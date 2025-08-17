
package net.mcreator.god.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.god.world.inventory.Menu2Menu;
import net.mcreator.god.procedures.OpenMenuOnKeyPressedProcedure;
import net.mcreator.god.procedures.Open5Procedure;
import net.mcreator.god.procedures.Open4Procedure;
import net.mcreator.god.procedures.Open3Procedure;
import net.mcreator.god.procedures.Open2Procedure;
import net.mcreator.god.procedures.AddStrenghProcedure;
import net.mcreator.god.procedures.AddStaProcedure;
import net.mcreator.god.procedures.AddIntelProcedure;
import net.mcreator.god.procedures.AddHealthProcedure;
import net.mcreator.god.GodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Menu2ButtonMessage {
	private final int buttonID, x, y, z;

	public Menu2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Menu2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Menu2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Menu2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = Menu2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenMenuOnKeyPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Open2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Open4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Open3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Open5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			AddHealthProcedure.execute(entity);
		}
		if (buttonID == 6) {

			AddStrenghProcedure.execute(entity);
		}
		if (buttonID == 7) {

			AddStaProcedure.execute(entity);
		}
		if (buttonID == 8) {

			AddIntelProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GodMod.addNetworkMessage(Menu2ButtonMessage.class, Menu2ButtonMessage::buffer, Menu2ButtonMessage::new, Menu2ButtonMessage::handler);
	}
}
