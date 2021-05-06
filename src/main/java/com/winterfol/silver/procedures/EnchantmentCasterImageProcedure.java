package com.winterfol.silver.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.winterfol.silver.item.PlaceholderSwordImageShooterItem;
import com.winterfol.silver.item.PlaceholderAxeImageShooterItem;
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
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack iteminhand = ItemStack.EMPTY;
		iteminhand = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		if ((((EnchantmentHelper.getEnchantmentLevel(CasterImageEnchantment.enchantment, (iteminhand)) != 0))
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == (ItemStack.EMPTY)
						.getItem()))) {
			if (((iteminhand).getItem() instanceof AxeItem)) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(((iteminhand)).getItem(),
							(int) (80 - ((EnchantmentHelper.getEnchantmentLevel(CasterImageEnchantment.enchantment, (iteminhand))) * 15)));
				{
					ItemStack _ist = (iteminhand);
					if (_ist.attemptDamageItem((int) 2, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof LivingEntity) {
					Entity _ent = entity;
					if (!_ent.world.isRemote()) {
						PlaceholderAxeImageShooterItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 0.5, (float) 11, (int) 5);
					}
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(((iteminhand)).getItem(),
							(int) (60 - ((EnchantmentHelper.getEnchantmentLevel(CasterImageEnchantment.enchantment, (iteminhand))) * 15)));
				{
					ItemStack _ist = (iteminhand);
					if (_ist.attemptDamageItem((int) 2, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof LivingEntity) {
					Entity _ent = entity;
					if (!_ent.world.isRemote()) {
						PlaceholderSwordImageShooterItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 4, (int) 1);
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
