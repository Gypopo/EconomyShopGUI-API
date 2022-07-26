package me.gypopo.economyshopgui.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EconomyShopGUIHook {

    public EconomyShopGUIHook() {}

    /**
     * Gets a item sell price
     * If the item couldn't be found inside the shop, this will return null
     * <p>
     * Note: This method does NOT check for player permissions
     *
     * @param item The item to get the sell price for
     * @return The sell price of the item, if not found this will return null
     */
    public static Double getItemSellPrice(ItemStack item) {
        return null;
    }

    /**
     * Gets a item sell price.
     * If the item couldn't be found inside the shop, this will return null.
     * <p>
     * Note: This method DOES check if the player has the required permissions to sell items in the required shop category("EconomyShopGUI.shop.[section/all]")
     * <p>
     *
     * @param player Player to check for permissions
     * @param item The item to get the sell price for
     * @return The sell price of the item, if not found this will return null
     */
    public static Double getItemSellPrice(Player player, ItemStack item) {
        return null;
    }

    /**
     * Gets a item buy price
     * If the item couldn't be found inside the shop, this will return null
     * <p>
     * Note: This method does NOT check for player permissions nor discounts
     *
     * @see #getItemBuyPrice(Player, ItemStack)
     * @param item The item to get the buy price for
     * @return The buy price of the item, if not found this will return null
     */
    public static Double getItemBuyPrice(ItemStack item) {
        return null;
    }

    /**
     * Gets the buy price of the item given as argument
     * If the item couldn't be found inside the shop or the player doesn't have permissions, this will return null
     * <p>
     * <b>In addition to {@link #getItemBuyPrice(ItemStack)}, this method will:</b>
     * <p>
     * 1. apply any discounts for the player if present
     * <p>
     * 2. check if the player has the required permissions to buy this item("EconomyShopGUI.shop.[section/all]")
     *
     * @param player Player to check for discounts and permissions
     * @param item The item to get the buy price for
     * @return The buy price of the item, if not found this will return null
     */
    public static Double getItemBuyPrice(Player player, ItemStack item) {
        return null;
    }

    /**
     * When DynamicPricing is enabled,
     * this method will 'purchase' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @param item The shop item to change the DynamicPricing for
     * @param amount The amount of items that are purchased
     */
    public static void buyItem(ItemStack item, int amount) {}

    /**
     * When DynamicPricing is enabled,
     * this method will 'sell' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @param item The shop item to change the DynamicPricing for
     * @param amount The amount of items that are sold
     */
    public static void sellItem(ItemStack item, int amount) {}

}
