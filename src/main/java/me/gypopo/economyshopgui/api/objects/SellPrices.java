package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.OfflinePlayer;

import java.util.Map;

public class SellPrices {

    private final OfflinePlayer player;
    private final Map<ShopItem, Integer> items;
    private final Map<EcoType, Double> prices;

    public SellPrices(OfflinePlayer player, Map<ShopItem, Integer> items, Map<EcoType, Double> prices) {
        this.player = player;
        this.items = items;
        this.prices = prices;
    }

    /**
     *
     * @return The player in this transaction
     */
    public OfflinePlayer getPlayer() {
        return this.player;
    }

    /**
     *
     * @return The items which matched the given item stacks
     */
    public Map<ShopItem, Integer> getItems() {
        return this.items;
    }

    /**
     *
     * @return The prices for these items
     */
    public Map<EcoType, Double> getPrices() {
        return this.prices;
    }

    /**
     * Gets the price matching the given EcoType
     * If there is no price matching the EcoType, this will return -1
     *
     * @param ecoType The requested economy type
     * @return The price for this economy type
     */
    public double getPrice(EcoType ecoType) {
        return this.prices.getOrDefault(ecoType, -1d);
    }

    /**
     *
     * @return Whether this SellPrices class contains any items with the calculated sell prices
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * Update the item's DynamicPricing and stock limit
     */
    public SellPrices updateLimits() {
        for (ShopItem item : this.items.keySet()) {
            if (item.isRefillStock())
                EconomyShopGUIHook.sellItemStock(item, this.player.getUniqueId(), this.items.get(item));
            if (item.getLimitedSellMode() != 0)
                EconomyShopGUIHook.sellItemLimit(item, this.player.getUniqueId(), this.items.get(item));
            if (item.isDynamicPricing())
                EconomyShopGUIHook.sellItem(item, this.items.get(item));
        }

        return this;
    }
}