package me.gypopo.economyshopgui.api;

import me.gypopo.economyshopgui.objects.ShopItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.UUID;

public class EconomyShopGUIHook {

    public EconomyShopGUIHook() {}

    /**
     * Gets a item sell price
     * If the item couldn't be found inside the shop, this will return null
     * <p>
     * Note: This method does NOT check for player permissions NOR any price multipliers
     *
     * @param item The item to get the sell price for
     * @return The sell price of the item, if not found this will return null
     * @see #getItemSellPrice(ShopItem, ItemStack)
     */
    @Nullable
    @Deprecated
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
     * @see #getItemSellPrice(ShopItem, ItemStack, Player)
     */
    @Nullable
    @Deprecated
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
     * @see #getItemBuyPrice(ShopItem, ItemStack)
     */
    @Nullable
    @Deprecated
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
     * @see #getItemBuyPrice(ShopItem, ItemStack, Player)
     */
    @Nullable
    @Deprecated
    public static Double getItemBuyPrice(Player player, ItemStack item) {
        return null;
    }

    /**
     * Gets an item sell price
     *
     * @param shopItem The shopItem to get the price from
     * @param item The item to get the sell price for
     * @return The sell price of the item, if not found this will return null
     * @see #getItemSellPrice(ShopItem, ItemStack, Player)
     */
    public static Double getItemSellPrice(ShopItem shopItem, ItemStack item) {
        return null;
    }

    /**
     * Gets an item sell price.
     * <p>
     * <b>In addition to {@link #getItemBuyPrice(ShopItem, ItemStack)}, this method will apply any multipliers for the player if present</b>
     *
     * @param shopItem The shopItem to get the price from
     * @param player Player to check for permissions
     * @param item The item to get the sell price for
     * @return The sell price of the item
     */
    public static Double getItemSellPrice(ShopItem shopItem, ItemStack item, Player player) {
        return null;
    }

    /**
     * Gets an item buy price
     *
     * @param shopItem The shopItem to get the price from
     * @param item The item to get the amount from
     * @return The buy price of the item
     * @see #getItemBuyPrice(ShopItem, ItemStack, Player)
     */
    public static Double getItemBuyPrice(ShopItem shopItem, ItemStack item) {
        return null;
    }

    /**
     * Gets the buy price of the item given as argument
     * <p>
     * <b>In addition to {@link #getItemBuyPrice(ShopItem, ItemStack)}, this method will apply any discounts for the player if present</b>
     *
     * @param shopItem The shop item to get the price from
     * @param player Player to check for discounts and permissions
     * @param item The item to get the amount from
     * @return The buy price of the item
     */
    public static Double getItemBuyPrice(ShopItem shopItem, ItemStack item, Player player) {
        return null;
    }

    /**
     * When DynamicPricing is enabled,
     * this method will 'purchase' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @see #buyItem(ShopItem, int)
     * @param item The shop item to change the DynamicPricing for
     * @param amount The amount of items that are purchased
     */
    @Deprecated
    public static void buyItem(ItemStack item, int amount) {}

    /**
     * When DynamicPricing is enabled,
     * this method will 'sell' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @see #sellItem(ItemStack, int)
     * @param item The shop item to change the DynamicPricing for
     * @param amount The amount of items that are sold
     */
    @Deprecated
    public static void sellItem(ItemStack item, int amount) {}

    /**
     * When DynamicPricing is enabled,
     * this method will 'purchase' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @param shopItem The shop item to change the DynamicPricing for
     * @param amount The amount of items that are purchased
     */
    public static void buyItem(ShopItem shopItem, int amount) {}

    /**
     * When DynamicPricing is enabled,
     * this method will 'sell' the items given from the market and change the DynamicPrice for the item accordingly
     *
     * @param shopItem The shop item to change the DynamicPricing for
     * @param amount The amount of items that are sold
     */
    public static void sellItem(ShopItem shopItem, int amount) {}

    /**
     * Returns the {@link ShopItem} matching the given {@link ItemStack}
     * <p>
     * If the item doesn't match any ShopItem, this will return null
     *
     * @param item The item to match
     * @return The ShopItem matching the ItemStack
     */
    @Nullable
    public static ShopItem getShopItem(ItemStack item) {
        return null;
    }

    /**
     * Returns the amount of items left in stock.
     * <p>
     * If the item is restocking(can be bought later), this will return <b>-2</b>, if the item cannot be bought ever again, this will return <b>-3</b> or <b>-4</b>.
     * <p>
     * Use {@link ShopItem#getLimitedStockMode()} to determine whether this {@link ShopItem} is using player or global stock
     *
     *
     * @param shopItem The shopItem to get the limited stock for
     * @param uuid The player's uuid to get the item stock for, can be null when this item is GlobalStock
     * @return The amount of items in stock left
     */
    public static int getItemStock(ShopItem shopItem, @Nullable UUID uuid) {
        return 0;
    }

    /**
     * Returns the time left in millis to restock the item stock in GlobalStock or PlayerStock
     * <p>
     * Use {@link ShopItem#getLimitedStockMode()} to determine whether this {@link ShopItem} is using player or global stock
     *
     *
     * @param shopItem The shopItem to get the restocking time for
     * @param uuid The player's uuid to get the item's restocking time for, can be null when this item is GlobalStock
     * @return The time left to restock, or null when this item is not restocking
     */
    public static Long getItemStockRestockTime(ShopItem shopItem, @Nullable UUID uuid) {
        return null;
    }

    /**
     * Try's to purchase the amount of items from limited stock.
     * <p>
     * Returns the total amount of items which could be purchased.
     * <p>
     * Developers should use {@link #getItemStock(ShopItem, UUID)} to check and see if there is enough stock available before purchasing.
     * <p>
     * Use {@link ShopItem#getLimitedStockMode()} to determine whether this {@link ShopItem} is using player or global stock
     *
     *
     * @param shopItem The shopItem to purchase the limited stock from
     * @param uuid The player's uuid to purchase the item stock from, can be null when this item is GlobalStock
     * @return Returns the total amount of items which could be purchased
     */
    public static int buyItemStock(ShopItem shopItem, @Nullable UUID uuid, int amount) {
        return 0;
    }

    /**
     * Sells the amount of items to the limited stock.
     * <p>
     * Use {@link ShopItem#getLimitedStockMode()} to determine whether this {@link ShopItem} is using player or global stock
     *
     *
     * @param shopItem The shopItem to sell the limited stock for
     * @param uuid The player's uuid to sell the item stock for, can be null when this item is GlobalStock
     */
    public static void sellItemStock(ShopItem shopItem, @Nullable UUID uuid, int amount) {}

    /**
     * Returns the limit of items left that can be sold to shop.
     * <p>
     * If the item is restocking(can be sold later), this will return <b>-2</b>, if the item cannot be sold ever again, this will return <b>-3</b> or <b>-4</b>.
     * <p>
     * Use {@link ShopItem#getLimitedSellMode()} to determine whether this {@link ShopItem} is using player or global sell limit
     *
     * @param shopItem The shopItem to get the sell limit for
     * @param uuid The player's uuid to get the sell limit for, can be null when this item is GlobalLimit
     * @return The amount left that can be sold to shop
     */
    public static int getSellLimit(ShopItem shopItem, @Nullable UUID uuid) {
        return 0;
    }

    /**
     * Returns the time left in millis to restock the sell limit in GlobalLimit or PlayerLimit
     * <p>
     * Use {@link ShopItem#getLimitedSellMode()} to determine whether this {@link ShopItem} is using player or global sell limit
     *
     *
     * @param shopItem The shopItem to get the restocking time for
     * @param uuid The player's uuid to get the item's restocking time for, can be null when this item is GlobalLimit
     * @return The time left to restock, or null when this item is not restocking
     */
    public static Long getSellLimitRestockTime(ShopItem shopItem, @Nullable UUID uuid) {
        return null;
    }

    /**
     * Reduces the sell limit by the given amount
     * <p>
     * Returns the total amount of items which could be sold
     * <p>
     * Developers should use {@link #getSellLimit(ShopItem, UUID)} to check and see if there is enough stock available before purchasing.
     * <p>
     * Use {@link ShopItem#getLimitedSellMode()} to determine whether this {@link ShopItem} is using player or global sell limit
     *
     *
     * @param shopItem The shopItem to reduce the sell limit for
     * @param uuid The player's uuid to reduce the sell limit for, can be null when this item is GlobalStock
     * @return Returns the total amount of items which could be purchased
     */
    public static int sellItemLimit(ShopItem shopItem, @Nullable UUID uuid, int amount) {
        return 0;
    }

}
