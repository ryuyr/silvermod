package com.winterfol.silver.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.winterfol.silver.SilverModElements;
import com.winterfol.silver.SilverMod;

@SilverModElements.ModElement.Tag
public class PlaceholderSwordImageShooterWhileBulletFlyingTickProcedure extends SilverModElements.ModElement {
	public PlaceholderSwordImageShooterWhileBulletFlyingTickProcedure(SilverModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SilverMod.LOGGER.warn("Failed to load dependency entity for procedure PlaceholderSwordImageShooterWhileBulletFlyingTick!");
			return;
		}
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
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double time = 0;
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, x, y, z, (int) 1, 0.2, 0.2, 0.2, 0);
		}
		entity.getPersistentData().putDouble("time", ((entity.getPersistentData().getDouble("time")) + 1));
		if (((entity.getPersistentData().getDouble("time")) > 10)) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 0, 0);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ENCHANT, x, y, z, (int) 20, 0, 0, 0, 3);
			}
			if (!entity.world.isRemote())
				entity.remove();
		}
	}
}
