package me.gypopo.economyshopgui.providers;

import me.gypopo.economyshopgui.util.ItemType;
import me.gypopo.economyshopgui.util.exceptions.ItemLoadException;
import org.bukkit.inventory.ItemStack;

public interface ItemProvider {

    ItemType getType();

    ItemStack getItem(String id) throws ItemLoadException;

    String getItem(ItemStack stack);
}
