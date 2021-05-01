
package com.winterfol.silver.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import com.winterfol.silver.SilverModElements;

@SilverModElements.ModElement.Tag
public class CasterImageEnchantment extends SilverModElements.ModElement {
	@ObjectHolder("silver:caster_image")
	public static final Enchantment enchantment = null;
	public CasterImageEnchantment(SilverModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("caster_image"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(Items.WOODEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_AXE, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
