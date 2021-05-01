package com.winterfol.silver.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import java.util.Map;

import com.winterfol.silver.SilverModElements;
import com.winterfol.silver.SilverMod;

@SilverModElements.ModElement.Tag
public class PlaceholderSwordImageShooterWhileBulletFlyingTickProcedure extends SilverModElements.ModElement {
	public PlaceholderSwordImageShooterWhileBulletFlyingTickProcedure(SilverModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SilverMod.LOGGER.warn("Failed to load dependency x for procedure PlaceholderSwordImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SilverMod.LOGGER.warn("Failed to load dependency y for procedure PlaceholderSwordImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SilverMod.LOGGER.warn("Failed to load dependency z for procedure PlaceholderSwordImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SilverMod.LOGGER.warn("Failed to load dependency world for procedure PlaceholderSwordImageShooterWhileBulletFlyingTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, x, y, z, (int) 1, 0.5, 0.5, 0.5, 0);
		}
	}
}
