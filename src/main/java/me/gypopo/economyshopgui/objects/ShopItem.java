package me.gypopo.economyshopgui.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ShopItem {

    /**
     * @return The item which is given to players upon buying
     */
    public ItemStack getItemToGive() {
        return null;
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
     * <p>
     * 1 = global stock
     * <p>
     * 2 = player stock
     * @return The limited stock mode this item uses
     */
    public int getLimitedStockMode() { return 0; }

    /**
     * 0 = no stock mode
     * <p>
     * 1 = global stock
     * <p>
     * 2 = player stock
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
     * Returns whether the given amount is larger than the maximum amount to buy
     *
     * @param amount The amount to check for
     * @return Whether the given amount is larger than the maximum amount to buy
     */
    public boolean isMaxSell(int amount) {
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
}
