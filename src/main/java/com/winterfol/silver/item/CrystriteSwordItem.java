
package com.winterfol.silver.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import com.winterfol.silver.SilverModElements;

@SilverModElements.ModElement.Tag
public class CrystriteSwordItem extends SilverModElements.ModElement {
	@ObjectHolder("silver:crystrite_sword")
	public static final Item block = null;
	public CrystriteSwordItem(SilverModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 512;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CrystriteItem.block, (int) (1)));
			}
		}, 3, -1.6f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("crystrite_sword"));
	}
}
