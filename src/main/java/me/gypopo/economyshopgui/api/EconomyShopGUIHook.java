package me.gypopo.economyshopgui.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EconomyShopGUIHook {

    public EconomyShopGUIHook() {}

    /**
     * Gets a item sell price
     * If the item couldn't be found inside the shop, this will return null
     *
     * @param item The item to get the sell price for
     * @return The sell price of the item, if not found this will return null
     */
    public static Double getItemSellPrice(ItemStack item) {
        return null;
    }

    /**
     * Gets a item buy price
     * If the item couldn't be found inside the shop, this will return null
     *
     * @param item The item to get the buy price for
     * @return The buy price of the item, if not found this will return null
     */
    public static Double getItemBuyPrice(ItemStack item) {
        return null;
    }

    /**
     * Gets a item buy price with any discount included for the player if present
     * If the item couldn't be found inside the shop, this will return null
     *
     * @param player Player to check for discounts
     * @param item The item to get the buy price for
     * @return The buy price of the item, if not found this will return null
     */
    public static Double getItemBuyPrice(Player player, ItemStack item) {
        return null;
    }

}
