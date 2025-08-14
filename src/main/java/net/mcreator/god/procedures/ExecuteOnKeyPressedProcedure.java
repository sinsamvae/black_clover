package net.mcreator.god.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.god.network.GodModVariables;
import net.mcreator.god.init.GodModEntities;
import net.mcreator.god.entity.WindSlashEntity;
import net.mcreator.god.entity.WindBladeEntity;
import net.mcreator.god.entity.WindBirdEntity;
import net.mcreator.god.entity.TornadoEntity;
import net.mcreator.god.GodMod;

import java.util.List;
import java.util.Comparator;

public class ExecuteOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double wait = 0;
		double a = 0;
		double b = 0;
		double c = 0;
		if ((((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
				.getString(("skill" + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move))).equals("Crescent Kamaitachi")) {
			if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana >= 10) {
				if (entity.isShiftKeyDown()) {
					entity.getPersistentData().putDouble("rep", 0);
					entity.getPersistentData().putDouble("distance_c", 1);
					((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
							.putDouble(("cooldown" + new java.text.DecimalFormat("##").format((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move)), 80);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					for (int index0 = 0; index0 < 10; index0++) {
						wait = wait + 1;
						GodMod.queueServerWork((int) wait, () -> {
							entity.getPersistentData().putDouble("rep", (Math.PI * (entity.getYRot() / 180) * (-1) - Math.PI / 3));
							entity.getPersistentData().putDouble("distance_c", (entity.getPersistentData().getDouble("distance_c") + Mth.nextDouble(RandomSource.create(), 0.5, 1)));
							for (int index1 = 0; index1 < 30; index1++) {
								entity.getPersistentData().putDouble("rep", (entity.getPersistentData().getDouble("rep") + (0.6 * Math.PI) / 30));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CLOUD, (entity.getX() + Math.sin(entity.getPersistentData().getDouble("rep")) * 2 * entity.getPersistentData().getDouble("distance_c")),
											(entity.getY() + 1.5 + entity.getLookAngle().y), (entity.getZ() + Math.cos(entity.getPersistentData().getDouble("rep")) * 2 * entity.getPersistentData().getDouble("distance_c")), 4, 0.3, 0.05, 0.3, 0);
								{
									final Vec3 _center = new Vec3((entity.getX() + Math.sin(entity.getPersistentData().getDouble("rep")) * 2 * entity.getPersistentData().getDouble("distance_c")), (entity.getY() + 1.5 + entity.getLookAngle().y),
											(entity.getZ() + Math.cos(entity.getPersistentData().getDouble("rep")) * 2 * entity.getPersistentData().getDouble("distance_c")));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity || entityiterator instanceof ItemEntity || entityiterator instanceof ExperienceOrb
												|| (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
												|| (entity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) || new Object() {
													public boolean checkGamemode(Entity _ent) {
														if (_ent instanceof ServerPlayer _serverPlayer) {
															return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
														} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
															return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
																	&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
														}
														return false;
													}
												}.checkGamemode(entityiterator) || new Object() {
													public boolean checkGamemode(Entity _ent) {
														if (_ent instanceof ServerPlayer _serverPlayer) {
															return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
														} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
															return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
																	&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
														}
														return false;
													}
												}.checkGamemode(entityiterator))) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entity),
													(float) (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel);
										}
									}
								}
							}
						});
					}
				} else {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new WindSlashEntity(GodModEntities.WIND_SLASH.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				{
					double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana - 10;
					entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				GodMod.LOGGER.info("Not Enough Mana!");
			}
		}
		if ((((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
				.getString(("skill" + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move))).equals("Swift White Hawk")) {
			if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana >= 30) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WindBirdEntity(GodModEntities.WIND_BIRD.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel * 1.5), 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.8, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana - 30;
					entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				GodMod.LOGGER.info("Not Enough Mana!");
			}
		}
		if ((((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
				.getString(("skill" + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move))).equals("Towering Tornado")) {
			if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana >= 30) {
				{
					double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana - 30;
					entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = GodModEntities.TORNADO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof TornadoEntity) {
							entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x), 0, (entity.getLookAngle().z)));
						}
					}
				}
			} else {
				GodMod.LOGGER.info("Not Enough Mana!");
			}
		}
		if ((((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
				.getString(("skill" + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move))).equals("Wind Blades Shower")) {
			if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana >= 60) {
				{
					double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).mana - 60;
					entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				a = entity.getYRot();
				b = entity.getXRot();
				c = 10;
				for (int index2 = 0; index2 < 4; index2++) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WindBladeEntity(GodModEntities.WIND_BLADE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel * 1.4), 1);
						_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
						_entityToSpawn.shoot(((-1) * (Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a)) + Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(a - 90)))),
								((-1) * Math.cos(Math.toRadians(c)) * Math.sin(Math.toRadians(b))),
								(Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a)) + Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(a - 90))), 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					c = (-1) * c;
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WindBladeEntity(GodModEntities.WIND_BLADE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel * 1.4), 1);
						_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
						_entityToSpawn.shoot(((-1) * (Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a)) + Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(a - 90)))),
								((-1) * Math.cos(Math.toRadians(c)) * Math.sin(Math.toRadians(b))),
								(Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a)) + Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(a - 90))), 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					c = (-1) * c + 10;
				}
			} else {
				GodMod.LOGGER.info("Not Enough Mana!");
			}
		}
	}
}
