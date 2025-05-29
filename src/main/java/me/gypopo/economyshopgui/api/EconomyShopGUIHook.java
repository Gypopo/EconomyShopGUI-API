package me.gypopo.economyshopgui.api;

import me.gypopo.economyshopgui.api.objects.BuyPrice;
import me.gypopo.economyshopgui.api.objects.SellPrice;
import me.gypopo.economyshopgui.api.objects.SellPrices;
import me.gypopo.economyshopgui.api.prices.AdvancedBuyPrice;
import me.gypopo.economyshopgui.api.prices.AdvancedSellPrice;
import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.objects.shops.ShopSection;
import me.gypopo.economyshopgui.providers.EconomyProvider;
import me.gypopo.economyshopgui.util.EcoType;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.*;

public class EconomyShopGUIHook {

    public EconomyShopGUIHook() {}

    /**
     * This will return whether the item can be sold
     * <p>
     * Checks if the item has a sell price at all and if it isn't negative
     *
     * @return Whether this item can be sold to the store
     */
    public static boolean isSellAble(ShopItem shopItem) {
        return false;
    }

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
     * Gets an item sell price.
     * <p>
     * <b>In addition to {@link #getItemSellPrice(ShopItem, ItemStack, Player)}, this method will exactly calculate the DynamicPrice</b>
     * <p><p>
     * This method is only useful when {@link ShopItem#isDynamicPricing()} returns true
     * @param shopItem The shopItem to get the price from
     * @param player Player to check for permissions
     * @param item The item to get the sell price for
     * @param amount The amount of the item
     * @param sold The amount that is already sold this batch, this method should be used instead of {@link #getItemSellPrice(ShopItem, ItemStack, Player)} or {@link #getItemSellPrice(ShopItem, ItemStack)} because this will exactly calcule the dynamic sell price of the item
     * @return The sell price of the item
     */
    public static Double getItemSellPrice(ShopItem shopItem, ItemStack item, Player player, int amount, int sold) {
        return null;
    }

    /**
     * Gets an item sell price.
     * <p>
     * <b>In addition to {@link #getItemSellPrice(ShopItem, ItemStack)}, this method will exactly calculate the DynamicPrice</b>
     * <p><p>
     * This method is only useful when {@link ShopItem#isDynamicPricing()} returns true
     * @param shopItem The shopItem to get the price from
     * @param item The item to get the sell price for
     * @param amount The amount of the item
     * @param sold The amount that is already sold this batch, this method should be used instead of {@link #getItemSellPrice(ShopItem, ItemStack)} or {@link #getItemSellPrice(ShopItem, ItemStack)} because this will exactly calcule the dynamic sell price of the item
     * @return The sell price of the item
     */
    public static Double getItemSellPrice(ShopItem shopItem, ItemStack item, int amount, int sold) {
        return null;
    }

    /**
     * Returns a map with sell prices for this item<br><br>
     * This method returns only prices of ShopItems that meet the following requirements:<br>
     * - ShopItem is found inside shop ({@link EconomyShopGUIHook#getShopItem(Player, ItemStack) != null})<br>
     * - ShopItem does not have an item error ({@link ShopItem#hasItemError()})<br>
     * - ShopItem is not a display item ({@link ShopItem#isDisplayItem()})
     * - ShopItem is sellable ({@link EconomyShopGUIHook#isSellAble(ShopItem)} ()})<br>
     * - ShopItem is maximum sell limit ({@link ShopItem#isMaxSell(int)})<br>
     * - Player does have permissions for <b>EconomyShopGUI.shop.{section}</b><br>
     * - Player does have permissions for this specific shop item <b>EconomyShopGUI.shop.{section}.item.{permission}</b><br>
     * - Player does meet the requirements of this item<br>
     * - If there is enough sell stock available ({@link EconomyShopGUIHook#getSellLimit(ShopItem, UUID)})<br>
     *<br><br>
     * It is important to call the {@link SellPrice#updateLimits()} method which should be called after the items have been sold,
     * since this makes sure all item limits(sell stock, dynamic pricing) gets updated accordingly!
     * @param item The ItemStack to be sold
     * @param player The player to check for permissions, multipliers, sell limits
     * @return The prices of the item, or null if none available
     */
    public static Optional<SellPrice> getSellPrice(OfflinePlayer player, ItemStack item) {
        Objects.requireNonNull(item, "Item cannot be null");
        Objects.requireNonNull(player, "Player cannot be null");

        boolean online = player.isOnline();
        int amount = item.getAmount();

        ShopItem shopItem = !online ? EconomyShopGUIHook.getShopItem(item) :
                EconomyShopGUIHook.getShopItem((Player) player, item);

        if (shopItem == null || shopItem.hasItemError())
            return Optional.empty();

        if (shopItem.isMaxSell(amount))
            return Optional.empty();

        if (shopItem.getLimitedSellMode() != 0) {
            int stock = EconomyShopGUIHook.getSellLimit(shopItem, player.getUniqueId());
            if (amount > stock)
                return Optional.empty();
        }

        SellPrice price;
        if (EconomyShopGUIHook.hasMultipleSellPrices(shopItem)) {
            Map<EcoType, Double> prices = !online ? EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, item, item.getAmount(), 0) :
                    EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, (Player) player, item, item.getAmount(), 0);

            price = new SellPrice(player, amount, shopItem, prices);
        } else {
            double sellPrice = !online ? EconomyShopGUIHook.getItemSellPrice(shopItem, item, item.getAmount(), 0) :
                    EconomyShopGUIHook.getItemSellPrice(shopItem, item, (Player) player, item.getAmount(), 0);

            price = new SellPrice(player, amount, shopItem, shopItem.getEcoType(), sellPrice);
        }

        return Optional.of(price);
    }

    /**
     * Returns a map with sell prices for the given items<br><br>
     * This method returns only prices of ShopItems that meet the following requirements:<br>
     * - ItemStack is not null ({@code item != null})<br>
     * - ItemStack is not AIR ({@link ItemStack#getType()} != Material.AIR)<br>
     * - ShopItem is found inside shop ({@link EconomyShopGUIHook#getShopItem(Player, ItemStack) != null})<br>
     * - ShopItem does not have an item error ({@link ShopItem#hasItemError()})<br>
     * - ShopItem is not a display item ({@link ShopItem#isDisplayItem()})
     * - ShopItem is sellable ({@link EconomyShopGUIHook#isSellAble(ShopItem)} ()})<br>
     * - ShopItem is maximum sell limit ({@link ShopItem#isMaxSell(int)})<br>
     * - Player does have permissions for <b>EconomyShopGUI.shop.{section}</b><br>
     * - Player does have permissions for this specific shop item <b>EconomyShopGUI.shop.{section}.item.{permission}</b><br>
     * - Player does meet the requirements of this item<br>
     * - If there is enough sell stock available ({@link EconomyShopGUIHook#getSellLimit(ShopItem, UUID)})<br>
     *<br><br>
     * It is important to call the {@link SellPrices#updateLimits()} method which should be called after the items have been sold,
     * since this makes sure all item limits(sell stock, dynamic pricing) gets updated accordingly!
     * @param player The player to check for permissions, multipliers, sell limits
     * @param items The ItemStacks to be sold
     * @return The prices of the items, or an empty
     */
    public static SellPrices getSellPrices(OfflinePlayer player, ItemStack... items) {
        Objects.requireNonNull(player, "Player cannot be null");
        Objects.requireNonNull(items, "Items cannot be null");

        boolean online = player.isOnline();

        Map<EcoType, Double> prices = new HashMap<>();
        Map<ShopItem, Integer> shopItems = new HashMap<>();
        for (ItemStack item : items) {
            if (item == null || item.getType() == Material.AIR)
                continue;

            ShopItem shopItem = !online ? EconomyShopGUIHook.getShopItem(item) :
                    EconomyShopGUIHook.getShopItem((Player) player, item);

            if (shopItem == null || !EconomyShopGUIHook.isSellAble(shopItem))
                continue;

            int alreadySold = shopItems.getOrDefault(shopItem, 0);

            if (shopItem.isMaxSell(item.getAmount() + alreadySold))
                continue; // Max sell reached

            if (shopItem.getLimitedSellMode() != 0) {
                int stock = EconomyShopGUIHook.getSellLimit(shopItem, player.getUniqueId());
                if ((item.getAmount() + alreadySold) > stock)
                    continue; // Sell limit reached
            }

            if (EconomyShopGUIHook.hasMultipleSellPrices(shopItem)) {
                Map<EcoType, Double> sellPrices = !online ? EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, item, item.getAmount(), alreadySold) :
                        EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, (Player) player, item, item.getAmount(), alreadySold);

                for (EcoType ecoType : sellPrices.keySet()) {
                    prices.put(ecoType, prices.getOrDefault(ecoType, 0d) + sellPrices.get(ecoType));
                }
            } else {
                double sellPrice = !online ? EconomyShopGUIHook.getItemSellPrice(shopItem, item, item.getAmount(), alreadySold) :
                        EconomyShopGUIHook.getItemSellPrice(shopItem, item, (Player) player, item.getAmount(), alreadySold);

                prices.put(shopItem.getEcoType(), prices.getOrDefault(shopItem.getEcoType(), 0d) + sellPrice);
            }

            shopItems.put(shopItem, alreadySold + item.getAmount());
        }

        return new SellPrices(player, shopItems, prices);
    }

    /**
     * This method is similar to {@link EconomyShopGUIHook#getSellPrices(OfflinePlayer, ItemStack...)} but instead may dynamically cut item stacks into smaller amounts<br>
     * Meaning that any item stack may be cut using {@link ItemStack#setAmount(int)} when the full stack is not able to be sold, but rather a smaller amount<br>
     * Indexes of item stacks where the full stack is able to be sold, will be set to {@link null}<br><br>
     *
     * Developers should only use this method if they know exactly what it does!<br><br>
     *
     * This makes sure that the item limit/stock is always reached for 100% when selling items<br>
     * @param player The player to check for permissions, multipliers, sell limits
     * @param items The ItemStacks to be sold
     * @param allowModify Whether this method is allowed to modify the provided array of items
     * @return The prices of the items
     */
    public static SellPrices getCutSellPrices(OfflinePlayer player, ItemStack[] items, boolean allowModify) {
        Objects.requireNonNull(player, "Player cannot be null");
        Objects.requireNonNull(items, "Items cannot be null");

        boolean online = player.isOnline();

        Map<EcoType, Double> prices = new HashMap<>();
        Map<ShopItem, Integer> shopItems = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            ItemStack item = items[i];
            if (item == null || item.getType() == Material.AIR)
                continue;

            ShopItem shopItem = !online ? EconomyShopGUIHook.getShopItem(item) :
                    EconomyShopGUIHook.getShopItem((Player) player, item);

            if (shopItem == null || !EconomyShopGUIHook.isSellAble(shopItem))
                continue;

            int alreadySold = shopItems.getOrDefault(shopItem, 0);

            int limit = EconomyShopGUIHook.getMaxSell(shopItem, item.getAmount(), alreadySold);
            if (limit == -1) continue; // Maximum amount reached

            limit = EconomyShopGUIHook.getSellLimit(shopItem, player.getUniqueId(), limit, alreadySold);
            if (limit == -1) continue; // Sell limit reached

            if (EconomyShopGUIHook.hasMultipleSellPrices(shopItem)) {
                Map<EcoType, Double> sellPrices = !online ? EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, item, limit, alreadySold) :
                        EconomyShopGUIHook.getMultipleSellPrices(shopItem).getSellPrices(null, (Player) player, item, limit, alreadySold);

                for (EcoType ecoType : sellPrices.keySet()) {
                    prices.put(ecoType, prices.getOrDefault(ecoType, 0d) + sellPrices.get(ecoType));
                }
            } else {
                double sellPrice = !online ? EconomyShopGUIHook.getItemSellPrice(shopItem, item, limit, alreadySold) :
                        EconomyShopGUIHook.getItemSellPrice(shopItem, item, (Player) player, limit, alreadySold);

                prices.put(shopItem.getEcoType(), prices.getOrDefault(shopItem.getEcoType(), 0d) + sellPrice);
            }

            if (allowModify) {
                if (limit < item.getAmount()) {
                    item.setAmount(item.getAmount() - limit);
                } else items[i] = null;
            }

            shopItems.put(shopItem, alreadySold + limit);
        }

        return new SellPrices(player, shopItems, prices);
    }

    /**
     * This will return whether the item can be bought
     * <p>
     * Checks if the item has a buy price at all and if it isn't negative
     *
     * @return Whether this item can be bought from store
     */
    public static boolean isBuyAble(ShopItem shopItem) {
        return false;
    }

    /**
     * Gets an item buy price
     *
     * @param shopItem The shopItem to get the price from
     * @param item The item to get the amount from
     * @return The buy price of the item
     * @see #getItemBuyPrice(ShopItem, ItemStack, Player)
     */
    @Deprecated
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
    @Deprecated
    public static Double getItemBuyPrice(ShopItem shopItem, ItemStack item, Player player) {
        return null;
    }

    /**
     * Gets an item buy price
     *
     * @param shopItem The shopItem to get the price from
     * @param amount Amount of the item
     * @return The buy price of the item
     * @see #getItemBuyPrice(ShopItem, Player, int)
     */
    public static double getItemBuyPrice(ShopItem shopItem, int amount) {
        return 0d;
    }

    /**
     * Gets the buy price of the item given as argument
     * <p>
     * <b>In addition to {@link #getItemBuyPrice(ShopItem, int)}, this method will apply any discounts for the player if present</b>
     *
     * @param shopItem The shop item to get the price from
     * @param player Player to check for discounts and permissions
     * @param amount Amount of the item
     * @return The buy price of the item
     */
    public static double getItemBuyPrice(ShopItem shopItem, Player player, int amount) {
        return 0d;
    }

    /**
     * Returns a map with buy prices for the given items<br><br>
     * This method returns only prices of ShopItems that meet the following requirements:<br>
     * - ShopItem is found inside shop ({@link EconomyShopGUIHook#getShopItem(Player, ItemStack) != null})<br>
     * - ShopItem does not have an item error ({@link ShopItem#hasItemError()})<br>
     * - ShopItem is not a display item ({@link ShopItem#isDisplayItem()})
     * - ShopItem is buyable ({@link EconomyShopGUIHook#isBuyAble(ShopItem)} ()} ()})<br>
     * - ShopItem is maximum buy limit ({@link ShopItem#isMaxBuy(int)} (int)})<br>
     * - Player does have permissions for <b>EconomyShopGUI.shop.{section}</b><br>
     * - Player does have permissions for this specific item ({@link EconomyShopGUIHook#hasPermissions(ShopItem, Player)})<br>
     * - If there is enough stock available ({@link EconomyShopGUIHook#getItemStock(ShopItem, UUID)} (ShopItem, UUID)})<br>
     *<br>
     * @param player The player to check for permissions, discounts, multipliers, stock limits
     * @param item The ItemStack to be bought
     * @return The prices of the item, or an empty optional if the requirements are not met
     */
    public static Optional<BuyPrice> getBuyPrice(OfflinePlayer player, ItemStack item) {
        Objects.requireNonNull(item, "Item cannot be null");
        Objects.requireNonNull(player, "Player cannot be null");

        boolean online = player.isOnline();
        int amount = item.getAmount();

        ShopItem shopItem = !online ? EconomyShopGUIHook.getShopItem(item) :
                EconomyShopGUIHook.getShopItem((Player) player, item);

        if (shopItem == null || !EconomyShopGUIHook.isBuyAble(shopItem))
            return Optional.empty();

        if (shopItem.isMaxBuy(item.getAmount()))
            return Optional.empty();

        if (shopItem.getLimitedStockMode() != 0) {
            int stock = EconomyShopGUIHook.getItemStock(shopItem, player.getUniqueId());
            if (amount > stock)
                return Optional.empty();
        }

        BuyPrice price;
        if (EconomyShopGUIHook.hasMultipleBuyPrices(shopItem)) {
            Map<EcoType, Double> buyPrices = !online ? EconomyShopGUIHook.getMultipleBuyPrices(shopItem).getBuyPrices(null, amount) :
                    EconomyShopGUIHook.getMultipleBuyPrices(shopItem).getBuyPrices(null, (Player) player, amount);

            price = new BuyPrice(player, amount, shopItem, buyPrices);
        } else {
            double buyPrice = !online ? EconomyShopGUIHook.getItemBuyPrice(shopItem, amount) :
                    EconomyShopGUIHook.getItemBuyPrice(shopItem, (Player) player, amount);

            price = new BuyPrice(player, amount, shopItem, shopItem.getEcoType(), buyPrice);
        }

        return Optional.of(price);
    }

    /**
     * The premium version of EconomyShopGUI allows items to have multiple buy prices with different currencies.
     * This allows the item to be bought using either one type of currency or using all types at the same time.
     * <p>
     * This method returns true if the item allows to be bought using multiple buy prices, else will return false
     *
     * @param shopItem The shop item to check for multiple buy prices
     * @return Whether the item has multiple buy prices
     */
    public static boolean hasMultipleBuyPrices(ShopItem shopItem) {
        return false;
    }

    /**
     * If {@link #hasMultipleBuyPrices(ShopItem)} this will return the multiple buy prices utility class.
     * Else, this will return null.
     *
     * @param shopItem The shop item to check for multiple buy prices
     * @return The utility class for multiple buy prices
     */
    public static AdvancedBuyPrice getMultipleBuyPrices(ShopItem shopItem) {
        return new AdvancedBuyPrice(shopItem);
    }

    /**
     * The premium version of EconomyShopGUI allows items to have multiple sell prices with different currencies.
     * This allows the item to be sold using either one type of currency or using all types at the same time.
     * <p>
     * This method returns true if the item allows to be sold using multiple sell prices, else will return false
     *
     * @param shopItem The shop item to check for multiple buy prices
     * @return Whether the item has multiple buy prices
     */
    public static boolean hasMultipleSellPrices(ShopItem shopItem) {
        return false;
    }

    /**
     * If {@link #hasMultipleSellPrices(ShopItem)} this will return the multiple sell prices utility class.
     * Else, this will return null.
     *
     * @param shopItem The shop item to check for multiple sell prices
     * @return The utility class for multiple sell prices
     */
    public static AdvancedSellPrice getMultipleSellPrices(ShopItem shopItem) {
        return new AdvancedSellPrice(shopItem);
    }


    /**
     * Gets the registered EconomyProvider for the given type
     * <p>
     * Can be used to withdraw/deposit balances into a players account
     * using an economy provider registered within EconomyShopGUI
     *
     * @param ecoType The type of the Economy | Can be null which will return the default provider
     * @see ShopItem#getEcoType()
     * @return The registered EconomyProvider or null if not found
     */
    public static EconomyProvider getEcon(@Nullable EcoType ecoType) {
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
     * Returns the {@link ShopItem} matching the given {@link ItemStack}
     * <p>
     * This method will return null if the following conditions aren't met:
     * <p>
     * - The Player doesn't have the permissions to buy/sell items from/to the section of the shop item
     * <p>
     * - The Player doesn't have the permissions to buy/sell the specific shop item
     * <p>
     * - The Player doesn't have enough levels to purchase/sell this item
     * <p>
     * - The ShopItem is a displayItem and cannot be sold/bought
     * <p>
     *
     * @param item The item to match
     * @param player The player to check if they are allowed to purchase/sell the item
     * @return The ShopItem matching the ItemStack
     */
    @Nullable
    public static ShopItem getShopItem(Player player, ItemStack item) {
        return null;
    }

    /**
     * Returns the {@link ShopItem} located at the given config path received from {@link ShopItem#getItemPath()}
     * <p>
     * If no item is found at this item path, this will return null
     *
     * @param itemPath The itemPath inside the shops config
     * @return The ShopItem located at this config path
     */
    @Nullable
    public static ShopItem getShopItem(String itemPath) {
        return null;
    }

    /**
     * Returns the {@link ShopSection} for the given section name
     * <p>
     * If no section is found for this name, this will return null
     *
     * @param section The section name
     * @return The ShopSection for this name
     */
    @Nullable
    public static ShopSection getShopSection(String section) {
        return null;
    }

    /**
     * Returns a list of section names which are loaded
     *
     * @return All loaded shop categories by their names
     * @see EconomyShopGUIHook#getShopSection(String)
     */
    public static List<String> getShopSections() {
        return null;
    }

    /**
     * Returns a map of all shop category's by name
     *
     * @return A map of all loaded sections by name
     */
    public static Map<String, ShopSection> getSections() {
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

    /**
     * Checks whether the player has permissions to access the specific given shop item
     * <p>
     * This will return true if the player has the permission: 'EconomyShopGUI.shop.<section>.item.<permission>'
     *
     * @param shopItem ShopItem to check for permissions
     * @param player The player to check for permissions
     * @return Whether the player has permissions to purchase/sell this specific item
     */
    public static boolean hasPermissions(ShopItem shopItem, Player player) {
        return true;
    }

    /**
     * Checks whether the player has permissions to access the specific given shop item
     * <p>
     * This will return true if the player has the permission: 'EconomyShopGUI.<root>.<section>.item.<permission>'
     *
     * @param shopItem ShopItem to check for permissions
     * @param player The player to check for permissions
     * @param root The root permission to check, possible values are 'shop', 'sellall', 'sellallitem', 'sellallhand', 'sellgui'
     * @return Whether the player has permissions to purchase/sell this specific item
     */
    public static boolean hasPermissions(ShopItem shopItem, Player player, String root) {
        return true;
    }

    /**
     * Check for the maximum sell limit <b>per transaction</b>
     *
     * @return The amount of items which can be sold before reaching the limit
     * @since EconomyShopGUI v5.2.0 || EconomyShopGUI-Premium v4.4.0
     */
    private static int getMaxSell(ShopItem shopItem, int qty, int alreadySold) {
        if (shopItem.isMaxSell(alreadySold + qty)) {
            if (alreadySold >= shopItem.getMaxSell())
                return -1; // Item already reached max sell for this transaction
            qty = shopItem.getMaxSell() - alreadySold;
        }
        return qty;
    }

    /**
     * Check for item sell stock
     * <p>
     * This is a Premium only feature but calls to the API can still be made
     * on the free version without it throwing an error
     *
     * @return The amount of items which can be sold before reaching the limit
     * @since EconomyShopGUI-Premium v4.1.0
     */
    private static int getSellLimit(ShopItem shopItem, UUID playerUUID, int qty, int alreadySold) {
        if (shopItem.getLimitedSellMode() != 0) { // Check for sell limits
            int stock = EconomyShopGUIHook.getSellLimit(shopItem, playerUUID);
            if (stock <= alreadySold) {
                return -1; // Sell limit already reached
            } else if (stock < (qty + alreadySold)) {
                qty = stock - alreadySold; // The limit that is left after the AlreadySold
            }
        }
        return qty;
    }

}
