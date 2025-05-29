package me.gypopo.economyshopgui.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ShopItem {

    public final String section = "";
    public final String itemLoc = "";

    /**
     * @return The path this item is located inside the shops.yml
     */
    public String getItemPath() {
        return null;
    }

    /**
     * @return The item displayed in shop
     */
    public ItemStack getShopItem() {
        return null;
    }

    /**
     * @return The item which is given to players upon buying
     */
    public ItemStack getItemToGive() {
        return null;
    }

    /**
     * Returns whether this item is a display item
     * <p>
     * DisplayItems cannot be bought/sold to/from shop.
     * <p>
     * Using {@link EconomyShopGUIHook#getShopItem(ItemStack)} won't return any display items
     *
     * @return Whether this item is a display item. DisplayItems cannot be bought/sold to shop
     */
    public boolean isDisplayItem() { return false; }

    /**
     * @return Whether this shop item is linked to a subsection
     */
    public boolean isLinked() {
        return false;
    }

    /**
     * Returns the linked subsection if {@link #isLinked()} is true, else this will return null
     *
     * @return Returns the linked subsection
     */
    public String getSubSection() {
        return null;
    }

    /**
     * @return Returns whether this shop item is hidden from shop
     */
    public boolean isHidden() {
        return false;
    }

    /**
     * @return Whether this shop item failed to load
     */
    public boolean hasItemError() { return false; }

    /**
     *
     * @param world The world name
     * @return Whether a season modifier is active for this world
     */
    public boolean hasSeasonModifier(String world) {
        return false;
    }

    /**
     * Checks if this item should refill limited stock when its sold
     * <p>
     * Use {@link EconomyShopGUIHook#sellItemStock(ShopItem, UUID, int)} to refill an items stock
     *
     * @return Whether this item should refill its stock upon selling
     */
    public boolean isRefillStock() {
        return false;
    }

    /**
     * 0 = no stock mode
     * <br>
     * 1 = global stock
     * <br>
     * 2 = player stock
     *
     * @return The limited stock mode this item uses
     */
    public int getLimitedStockMode() { return 0; }

    /**
     * 0 = no stock mode
     * <br>
     * 1 = global stock
     * <br>
     * 2 = player stock
     *
     * @return The limited sell mode this item uses
     */
    public int getLimitedSellMode() { return 0; }

    /**
     * Returns the {@link EcoType} of this item.
     * <p>
     * When no specific item {@link EcoType} has been specified, this will return the sections default.
     * <p>
     * When no section economy has been specified, this will return the default economy type.
     *
     * @return The {@link EcoType} the item uses
     */
    public EcoType getEcoType() {
        return null;
    }

    /**
     * Returns the maximum amount of items which can be bought in one transaction
     *
     * @return The maximum amount of items which can be bought in one transaction, '0' if not set
     */
    public int getMaxBuy() {
        return 0;
    }

    /**
     * Returns whether the given amount is larger than the maximum amount to buy
     *
     * @param amount The amount to check for
     * @return Whether the given amount is larger than the maximum amount to buy
     */
    public boolean isMaxBuy(int amount) {
        return false;
    }

    /**
     * Returns the maximum amount of items which can be sold in one transaction
     *
     * @return The maximum amount of items which can be sold in one transaction, '0' if not set
     */
    public int getMaxSell() {
        return 0;
    }

    /**
     * Returns whether the given amount is larger than the maximum amount to sell
     *
     * @param amount The amount to check for
     * @return Whether the given amount is larger than the maximum amount to sell
     */
    public boolean isMaxSell(int amount) {
        return false;
    }

    /**
     * Returns the minimum amount of items which can be bought in one transaction
     *
     * @return The minimum amount of items which can be bought in one transaction, '0' if not set
     */
    public int getMinBuy() {
        return 0;
    }

    /**
     * Returns whether the given amount is smaller than the minimum amount to buy
     *
     * @param amount The amount to check for
     * @return Whether the given amount is smaller than the minimum amount to buy
     */
    public boolean isMinBuy(int amount) {
        return false;
    }

    /**
     * Returns the minimum amount of items which can be sold in one transaction
     *
     * @return The minimum amount of items which can be sold in one transaction, '0' if not set
     */
    public int getMinSell() {
        return 0;
    }

    /**
     * Returns whether the given amount is smaller than the minimum amount to sell
     *
     * @param amount The amount to check for
     * @return Whether the given amount is smaller than the minimum amount to sell
     */
    public boolean isMinSell(int amount) {
        return false;
    }

    /**
     * Returns the stack size of the item
     *
     * @return The stack size of the item
     */
    public int getStackSize() {
        return 1;
    }

    /**
     * Returns whether the item uses DynamicPricing
     *
     * @return Whether DyanmicPricing is enabled for this item
     */
    public boolean isDynamicPricing() {
        return false;
    }
}
