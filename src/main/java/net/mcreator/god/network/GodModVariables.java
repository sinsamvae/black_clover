package net.mcreator.god.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.god.GodMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GodModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		GodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.kingdom = original.kingdom;
			clone.mana = original.mana;
			clone.maxmana = original.maxmana;
			clone.endurance = original.endurance;
			clone.maxendurance = original.maxendurance;
			clone.race = original.race;
			clone.attribute = original.attribute;
			clone.variant = original.variant;
			clone.level = original.level;
			clone.status = original.status;
			clone.xp = original.xp;
			clone.strenght = original.strenght;
			clone.SP = original.SP;
			clone.Health = original.Health;
			clone.MaxHealth = original.MaxHealth;
			clone.intel = original.intel;
			clone.SELECT = original.SELECT;
			clone.move = original.move;
			clone.abilityselect = original.abilityselect;
			clone.joined = original.joined;
			clone.skilllist = original.skilllist;
			clone.magicskillcount = original.magicskillcount;
			clone.raceboostgiven = original.raceboostgiven;
			clone.SocialClass = original.SocialClass;
			clone.invited_to_guild = original.invited_to_guild;
			clone.guild_name = original.guild_name;
			clone.guild_owner_logic = original.guild_owner_logic;
			clone.guild_itemstack = original.guild_itemstack;
			clone.ManaRegenFactor = original.ManaRegenFactor;
			clone.skin_color = original.skin_color;
			clone.eye_color = original.eye_color;
			clone.mouth = original.mouth;
			clone.hair = original.hair;
			clone.hair_color = original.hair_color;
			if (!event.isWasDeath()) {
				clone.grimoire = original.grimoire;
				clone.scroll_guild = original.scroll_guild;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("god", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String kingdom = "";
		public double mana = 100.0;
		public double maxmana = 100.0;
		public double endurance = 100.0;
		public double maxendurance = 100.0;
		public String race = "\"Human\"";
		public String attribute = "Wind";
		public String variant = "\"\"";
		public double level = 50.0;
		public String status = "\"Healthy\"";
		public double xp = 0;
		public double strenght = 0;
		public double SP = 0;
		public double Health = 0;
		public double MaxHealth = 0;
		public double intel = 1.0;
		public double SELECT = 1.0;
		public double move = 1.0;
		public ItemStack abilityselect = ItemStack.EMPTY;
		public boolean joined = false;
		public String skilllist = "\"\"";
		public double magicskillcount = 0.0;
		public boolean raceboostgiven = false;
		public String SocialClass = "";
		public boolean grimoire = false;
		public String invited_to_guild = "\"\"";
		public String guild_name = "\"\"";
		public boolean guild_owner_logic = false;
		public ItemStack guild_itemstack = ItemStack.EMPTY;
		public double scroll_guild = 0;
		public double ManaRegenFactor = 1.0;
		public double skin_color = 0;
		public double eye_color = 0;
		public double mouth = 0;
		public double hair = 0;
		public double hair_color = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				GodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("kingdom", kingdom);
			nbt.putDouble("mana", mana);
			nbt.putDouble("maxmana", maxmana);
			nbt.putDouble("endurance", endurance);
			nbt.putDouble("maxendurance", maxendurance);
			nbt.putString("race", race);
			nbt.putString("attribute", attribute);
			nbt.putString("variant", variant);
			nbt.putDouble("level", level);
			nbt.putString("status", status);
			nbt.putDouble("xp", xp);
			nbt.putDouble("strenght", strenght);
			nbt.putDouble("SP", SP);
			nbt.putDouble("Health", Health);
			nbt.putDouble("MaxHealth", MaxHealth);
			nbt.putDouble("intel", intel);
			nbt.putDouble("SELECT", SELECT);
			nbt.putDouble("move", move);
			nbt.put("abilityselect", abilityselect.save(new CompoundTag()));
			nbt.putBoolean("joined", joined);
			nbt.putString("skilllist", skilllist);
			nbt.putDouble("magicskillcount", magicskillcount);
			nbt.putBoolean("raceboostgiven", raceboostgiven);
			nbt.putString("SocialClass", SocialClass);
			nbt.putBoolean("grimoire", grimoire);
			nbt.putString("invited_to_guild", invited_to_guild);
			nbt.putString("guild_name", guild_name);
			nbt.putBoolean("guild_owner_logic", guild_owner_logic);
			nbt.put("guild_itemstack", guild_itemstack.save(new CompoundTag()));
			nbt.putDouble("scroll_guild", scroll_guild);
			nbt.putDouble("ManaRegenFactor", ManaRegenFactor);
			nbt.putDouble("skin_color", skin_color);
			nbt.putDouble("eye_color", eye_color);
			nbt.putDouble("mouth", mouth);
			nbt.putDouble("hair", hair);
			nbt.putDouble("hair_color", hair_color);
			return nbt;
		}

		public void readNBT(Tag tag) {
			if (tag == null) {
				tag = writeNBT();
			}
			CompoundTag nbt = (CompoundTag) tag;
			if (nbt == null) {
				nbt = (CompoundTag) writeNBT();
			}
			kingdom = nbt.getString("kingdom");
			mana = nbt.getDouble("mana");
			maxmana = nbt.getDouble("maxmana");
			endurance = nbt.getDouble("endurance");
			maxendurance = nbt.getDouble("maxendurance");
			race = nbt.getString("race");
			attribute = nbt.getString("attribute");
			variant = nbt.getString("variant");
			level = nbt.getDouble("level");
			status = nbt.getString("status");
			xp = nbt.getDouble("xp");
			strenght = nbt.getDouble("strenght");
			SP = nbt.getDouble("SP");
			Health = nbt.getDouble("Health");
			MaxHealth = nbt.getDouble("MaxHealth");
			intel = nbt.getDouble("intel");
			SELECT = nbt.getDouble("SELECT");
			move = nbt.getDouble("move");
			abilityselect = ItemStack.of(nbt.getCompound("abilityselect"));
			joined = nbt.getBoolean("joined");
			skilllist = nbt.getString("skilllist");
			magicskillcount = nbt.getDouble("magicskillcount");
			raceboostgiven = nbt.getBoolean("raceboostgiven");
			SocialClass = nbt.getString("SocialClass");
			grimoire = nbt.getBoolean("grimoire");
			invited_to_guild = nbt.getString("invited_to_guild");
			guild_name = nbt.getString("guild_name");
			guild_owner_logic = nbt.getBoolean("guild_owner_logic");
			guild_itemstack = ItemStack.of(nbt.getCompound("guild_itemstack"));
			scroll_guild = nbt.getDouble("scroll_guild");
			ManaRegenFactor = nbt.getDouble("ManaRegenFactor");
			skin_color = nbt.getDouble("skin_color");
			eye_color = nbt.getDouble("eye_color");
			mouth = nbt.getDouble("mouth");
			hair = nbt.getDouble("hair");
			hair_color = nbt.getDouble("hair_color");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		GodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.kingdom = message.data.kingdom;
					variables.mana = message.data.mana;
					variables.maxmana = message.data.maxmana;
					variables.endurance = message.data.endurance;
					variables.maxendurance = message.data.maxendurance;
					variables.race = message.data.race;
					variables.attribute = message.data.attribute;
					variables.variant = message.data.variant;
					variables.level = message.data.level;
					variables.status = message.data.status;
					variables.xp = message.data.xp;
					variables.strenght = message.data.strenght;
					variables.SP = message.data.SP;
					variables.Health = message.data.Health;
					variables.MaxHealth = message.data.MaxHealth;
					variables.intel = message.data.intel;
					variables.SELECT = message.data.SELECT;
					variables.move = message.data.move;
					variables.abilityselect = message.data.abilityselect;
					variables.joined = message.data.joined;
					variables.skilllist = message.data.skilllist;
					variables.magicskillcount = message.data.magicskillcount;
					variables.raceboostgiven = message.data.raceboostgiven;
					variables.SocialClass = message.data.SocialClass;
					variables.grimoire = message.data.grimoire;
					variables.invited_to_guild = message.data.invited_to_guild;
					variables.guild_name = message.data.guild_name;
					variables.guild_owner_logic = message.data.guild_owner_logic;
					variables.guild_itemstack = message.data.guild_itemstack;
					variables.scroll_guild = message.data.scroll_guild;
					variables.ManaRegenFactor = message.data.ManaRegenFactor;
					variables.skin_color = message.data.skin_color;
					variables.eye_color = message.data.eye_color;
					variables.mouth = message.data.mouth;
					variables.hair = message.data.hair;
					variables.hair_color = message.data.hair_color;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
