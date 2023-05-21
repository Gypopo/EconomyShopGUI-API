package me.gypopo.economyshopgui.api.prices;

import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

// A utility class that stores the multiple sell prices of a ShopItem
// The premium version of EconomyShopGUI(since v4.9.0) allows items to have multiple sell prices with different currencies.
// This allows the item to be sold using either one type of currency or using all types at the same time.

// Developers using the API connected to the premium version should check if {@link EconomyShopGUIHook#hasMultipleSellPrices()}
// returns true or false before using {@link EconomyShopGUIHook#getItemSellPrice(ShopItem, ...)} because doing so will return 0 when multiple prices have been configured.
// On the other hand when {@link EconomyShopGUIHook#hasMultipleSellPrices()} returns true, this class should be used for getting the items price(s) instead

// Some notes on using this:
// When the item is configured to have multiple sell prices and {@link #giveAll()} is true,
// all sell prices will be given to the player up on selling the item.
// When the item is configured to have only one sell price and {@link #giveAll()} is false,
// only one of the sell prices from {@link #getSellTypes()} is given to the player up on selling the item.
public class AdvancedSellPrice {

    public AdvancedSellPrice(ShopItem shopItem) {}

    /**
     * This will return all possible currency types this item has.
     * An empty list is returned if the item cannot be sold or has no sell prices set
     *
     * @return A list of all possible sell prices for this item
     */
    public List<EcoType> getSellTypes() {
        return null;
    }

    /**
     * This will return whether the item can be sold(Similar to how sell prices can be negative to disable them)
     *
     * @return Whether this item can be sold
     */
    public boolean isSellAble() {
        return false;
    }

    /**
     * This will return whether this item is configured to give all registered sell prices when selling this item.
     * Returns false if only the first sell price(#getSellPrices(#getSellTypes[0], ItemStack)) should be given to the player on selling the item
     *
     * @return Whether this item gives all registered sell prices up on selling the item
     */
    public boolean giveAll() {
        return false;
    }

    /**
     * This will return the sell price of the item matching the given {@link EcoType}.
     * If the {@link EcoType} is null, all possible sell prices will be returned for the ShopItem
     *
     * @param ecoType The currency type to get the sell price for
     * @param item Item to get the sell price for
     * @return Sell price of the item for the specified EcoType, if null, this will return all possible sell prices the item has.
     * <p>
     * Returns an empty Map if no sell prices were found matching the given EcoType
     */
    public Map<EcoType, Double> getSellPrices(@Nullable EcoType ecoType, ItemStack item) {
        return null;
    }

    /**
     * This will return the sell price of the item matching the given {@link EcoType}.
     * If the {@link EcoType} is null, all possible sell prices will be returned for the ShopItem
     * <p>
     * <b>In addition to {@link #getSellPrices(EcoType, ItemStack)}, this method will apply any sell multipliers for the player if present</b>
     *
     * @param ecoType The currency type to get the buy price for
     * @param player Player to check for discounts
     * @param item Item to get the sell price for
     * @return Sell price of the item for the specified EcoType, if null, this will return all possible sell prices the item has.
     * <p>
     * Returns an empty Map if no sell prices were found matching the given EcoType
     */
    public Map<EcoType, Double> getSellPrices(@Nullable EcoType ecoType, Player player, ItemStack item) {
        return null;
    }

    /**
     * This will return the sell price of the item matching the given {@link EcoType}.
     * If the {@link EcoType} is null, all possible sell prices will be returned for the ShopItem
     * <p>
     * <b>In addition to {@link #getSellPrices(EcoType, Player, ItemStack)}, this method will exactly calculate the DynamicPrice</b>
     * <p><p>
     * This method is only useful when {@link ShopItem#isDynamicPricing()} returns true
     * @param ecoType The currency type to get the buy price for
     * @param player Player to check for discounts
     * @param item Item to get the sell price for
     * @param amount The amount of the item
     * @param sold The amount that is already sold this batch, this method should be used instead of {@link #getSellPrices(EcoType, Player, ItemStack)} or {@link #getSellPrices(EcoType, ItemStack)} because this will exactly calcule the dynamic sell price of the item
     * @return Sell price of the item for the specified EcoType, if null, this will return all possible sell prices the item has.
     * <p>
     * Returns an empty Map if no sell prices were found matching the given EcoType
     */
    public Map<EcoType, Double> getSellPrices(@Nullable EcoType ecoType, Player player, ItemStack item, int amount, int sold) {
        return null;
    }
}
