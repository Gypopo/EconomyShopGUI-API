package me.gypopo.economyshopgui.objects;

import org.bukkit.inventory.ItemStack;

public class ShopItem {

    /**
     * @return The item which is given to players upon buying
     */
    public ItemStack getItemToGive() {
        return null;
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
}
