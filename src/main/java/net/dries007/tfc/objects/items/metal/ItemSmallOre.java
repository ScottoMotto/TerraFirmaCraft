/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package net.dries007.tfc.objects.items.metal;

import java.util.EnumMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.dries007.tfc.objects.Metal;
import net.dries007.tfc.objects.Ore;
import net.dries007.tfc.util.IMetalObject;
import net.dries007.tfc.util.OreDictionaryHelper;

public class ItemSmallOre extends Item implements IMetalObject
{
    private static final EnumMap<Ore, ItemSmallOre> MAP = new EnumMap<>(Ore.class);

    public static ItemSmallOre get(Ore ore)
    {
        return MAP.get(ore);
    }

    public static ItemStack get(Ore ore, int amount)
    {
        return new ItemStack(MAP.get(ore), amount);
    }

    public final Ore ore;

    public ItemSmallOre(Ore ore)
    {
        this.ore = ore;
        if (MAP.put(ore, this) != null) throw new IllegalStateException("There can only be one.");
        setMaxDamage(0);
        OreDictionaryHelper.register(this, "ore");
        OreDictionaryHelper.register(this, "ore", ore);
        OreDictionaryHelper.register(this, "ore", ore, "small");
    }

    @Override
    public Metal getMetal(ItemStack stack)
    {
        return ore.metal;
    }

    @Override
    public int getSmeltAmount(ItemStack stack)
    {
        return 10; //todo: config
    }
}
