package com.winterfol.silver.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.winterfol.silver.enchantment.CasterImageEnchantment;
import com.winterfol.silver.SilverModElements;
import com.winterfol.silver.SilverMod;

@SilverModElements.ModElement.Tag
public class EnchantmentCasterImageProcedure extends SilverModElements.ModElement {
	public EnchantmentCasterImageProcedure(SilverModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SilverMod.LOGGER.warn("Failed to load dependency entity for procedure EnchantmentCasterImage!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SilverMod.LOGGER.warn("Failed to load dependency x for procedure EnchantmentCasterImage!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SilverMod.LOGGER.warn("Failed to load dependency y for procedure EnchantmentCasterImage!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SilverMod.LOGGER.warn("Failed to load dependency z for procedure EnchantmentCasterImage!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SilverMod.LOGGER.warn("Failed to load dependency world for procedure EnchantmentCasterImage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack iteminhand = ItemStack.EMPTY;
		iteminhand = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		if (((EnchantmentHelper.getEnchantmentLevel(CasterImageEnchantment.enchantment, (iteminhand)) != 0))) {
			if ((((iteminhand).getDisplayName().getString()).contains("Axe"))) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(((iteminhand)).getItem(), (int) 60);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("silver:loz_sword_shoot_low")),
							SoundCategory.NEUTRAL, (float) 1, (float) 0.7);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("silver:loz_sword_shoot_low")),
							SoundCategory.NEUTRAL, (float) 1, (float) 0.7, false);
				}
				{
					ItemStack _ist = (iteminhand);
					if (_ist.attemptDamageItem((int) 2, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(((iteminhand)).getItem(), (int) 30);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("silver:loz_sword_shoot")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("silver:loz_sword_shoot")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				{
					ItemStack _ist = (iteminhand);
					if (_ist.attemptDamageItem((int) 2, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
