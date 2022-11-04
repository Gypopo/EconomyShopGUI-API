package me.gypopo.economyshopgui.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
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
}
