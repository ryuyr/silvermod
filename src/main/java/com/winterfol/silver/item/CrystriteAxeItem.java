
package com.winterfol.silver.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import com.winterfol.silver.SilverModElements;

@SilverModElements.ModElement.Tag
public class CrystriteAxeItem extends SilverModElements.ModElement {
	@ObjectHolder("silver:crystrite_axe")
	public static final Item block = null;
	public CrystriteAxeItem(SilverModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.4f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("crystrite_axe"));
	}
}
