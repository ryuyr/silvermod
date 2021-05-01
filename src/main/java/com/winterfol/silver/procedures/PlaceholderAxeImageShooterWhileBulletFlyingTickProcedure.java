package com.winterfol.silver.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.winterfol.silver.SilverModElements;
import com.winterfol.silver.SilverMod;

@SilverModElements.ModElement.Tag
public class PlaceholderAxeImageShooterWhileBulletFlyingTickProcedure extends SilverModElements.ModElement {
	public PlaceholderAxeImageShooterWhileBulletFlyingTickProcedure(SilverModElements instance) {
		super(instance, 9);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SilverMod.LOGGER.warn("Failed to load dependency entity for procedure PlaceholderAxeImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SilverMod.LOGGER.warn("Failed to load dependency x for procedure PlaceholderAxeImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SilverMod.LOGGER.warn("Failed to load dependency y for procedure PlaceholderAxeImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SilverMod.LOGGER.warn("Failed to load dependency z for procedure PlaceholderAxeImageShooterWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SilverMod.LOGGER.warn("Failed to load dependency world for procedure PlaceholderAxeImageShooterWhileBulletFlyingTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double time = 0;
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.ENCHANTED_HIT, x, y, z, (int) 1, 0.5, 0.5, 0.5, 0);
		}
		time = (double) ((time) + 18);
		entity.rotationYaw = (float) (0);
		entity.setRenderYawOffset(entity.rotationYaw);
		entity.prevRotationYaw = entity.rotationYaw;
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
			((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
			((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
		}
		entity.rotationPitch = (float) ((time));
		if (((time) > 342)) {
			time = (double) 0;
		}
	}
}
