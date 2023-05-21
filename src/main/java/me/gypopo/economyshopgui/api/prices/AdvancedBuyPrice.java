package me.gypopo.economyshopgui.api.prices;

import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

// A utility class that stores the multiple buy prices of a ShopItem
// The premium version of EconomyShopGUI allows items to have multiple buy prices with different currencies.
// This allows the item to be purchased using either one type of currency or using all types at the same time.

// Developers using the API connected to the premium version should check if {@link EconomyShopGUIHook#hasMultipleBuyPrices()}
// returns true or false before using {@link EconomyShopGUIHook#getItemBuyPrice(ShopItem, ...)} because doing so will return 0 when multiple prices have been configured.
// On the other hand when {@link EconomyShopGUIHook#hasMultipleBuyPrices()} returns true, this class should be used for getting the items price(s) instead

// Some notes on using this:
// When the item is configured to have multiple buy prices and {@link #requireAll()} is true,
// all buy prices are required for the item to be purchased.
// When the item is configured to have any buy price and {@link #requireAll()} is false,
// only one of the buy prices from {@link #getBuyTypes()} is required to purchase the item.
public class AdvancedBuyPrice {

    public AdvancedBuyPrice(ShopItem shopItem) {}

    /**
     * This will return all possible currency types this item has.
     * An empty list is returned if the item cannot be purchased or has no sell prices set
     *
     * @return A list of all possible buy prices for this item
     */
    public List<EcoType> getBuyTypes() {
        return null;
    }

    /**
     * This will return whether the item can be bought(Similar to how buy prices can be negative to disable them)
     *
     * @return Whether this item can be bought
     */
    public boolean isBuyAble() {
        return false;
    }

    /**
     * This will return whether this item is configured to require all registered buy prices in order to buy this item.
     * Returns false if only one buy price(#getBuyPrices(#getBuyTypes[0], ItemStack)) is required to purchase the item.
     *
     * @return Whether this item requires all registered buy prices up on purchasing the item
     */
    public boolean requireAll() {
        return false;
    }

    /**
     * This will return the buy price of the item matching the given {@link EcoType}.
     * If the {@link EcoType} is null, all buy prices will be returned for the ShopItem
     *
     * @param ecoType The currency type to get the buy price for
     * @param amount Amount of the item
     * @return Buy price of the item for the specified EcoType, if null, this will return all buy prices the item has.
     * <p>
     * Returns an empty Map if no buy prices were found matching the given EcoType
     */
    public Map<EcoType, Double> getBuyPrices(@Nullable EcoType ecoType, int amount) {
        return null;
    }

    /**
     * This will return the buy price of the item matching the given {@link EcoType}.
     * If the {@link EcoType} is null, all buy prices will be returned for the ShopItem
     * <p>
     * <b>In addition to {@link #getBuyPrices(EcoType, int)}, this method will apply any discounts for the player if present</b>
     *
     * @param ecoType The currency type to get the buy price for
     * @param player Player to check for discounts
     * @param amount Amount of the item
     * @return Buy price of the item for the specified EcoType, if null, this will return all buy prices the item has.
     * <p>
     * Returns an empty Map if no buy prices were found matching the given EcoType
     */
    public Map<EcoType, Double> getBuyPrices(@Nullable EcoType ecoType, Player player, int amount) {
        return null;
    }

}
