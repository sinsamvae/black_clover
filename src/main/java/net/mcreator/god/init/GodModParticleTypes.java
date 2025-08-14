
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.god.GodMod;

public class GodModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GodMod.MODID);
	public static final RegistryObject<SimpleParticleType> LEVEL_UP_PARTICLES = REGISTRY.register("level_up_particles", () -> new SimpleParticleType(false));
}
