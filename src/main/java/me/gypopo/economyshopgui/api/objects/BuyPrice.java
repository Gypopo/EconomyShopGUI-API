package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.OfflinePlayer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BuyPrice {

    private final OfflinePlayer player;
    private final int amount;
    private final ShopItem shopItem;
    private final Map<EcoType, Double> prices;

    public BuyPrice(OfflinePlayer player, int amount, ShopItem shopItem, Map<EcoType, Double> prices) {
        this.player = player;
        this.amount = amount;
        this.shopItem = shopItem;
        this.prices = prices;
    }

    public BuyPrice(OfflinePlayer player, int amount, ShopItem shopItem, EcoType ecoType, double price) {
        this.player = player;
        this.amount = amount;
        this.shopItem = shopItem;
        this.prices = new HashMap<>(Collections.singletonMap(ecoType, price));
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
     * @return The amount of this transaction
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     *
     * @return The ShopItem which matched the given item stack
     */
    public ShopItem getShopItem() {
        return this.shopItem;
    }

    /**
     *
     * @return The prices for this shopItem
     */
    public Map<EcoType, Double> getPrices() {
        return this.prices;
    }

    /**
     * Gets the price of this shop item matching the given EcoType
     * If the item does not have a price matching the EcoType, this will return -1
     *
     * @param ecoType The requested economy type
     * @return The price for this economy type
     */
    public double getPrice(EcoType ecoType) {
        return this.prices.getOrDefault(ecoType, -1d);
    }

    /**
     * Update the item's DynamicPricing and stock limit
     */
    public BuyPrice updateLimits() {
        if (this.shopItem.getLimitedStockMode() != 0)
            EconomyShopGUIHook.buyItemStock(this.shopItem, this.player.getUniqueId(), this.amount);
        if (this.shopItem.isDynamicPricing())
            EconomyShopGUIHook.buyItem(this.shopItem, this.amount);

        return this;
    }
}