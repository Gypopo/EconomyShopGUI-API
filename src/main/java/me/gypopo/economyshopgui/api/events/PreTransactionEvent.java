package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PreTransactionEvent extends CustomEvent implements Cancellable {

    private final int amount;
    private boolean cancelled;
    private double price;
    private final double originalPrice;
    private final Map<EcoType, Double> prices;
    private final Map<EcoType, Double> originalPrices;
    private final ShopItem shopItem;
    private final Player player;
    private final Map<ShopItem, Integer> items;
    private final Transaction.Type transactionType;

    public PreTransactionEvent(ShopItem shopItem, Player player, int amount, double price, Transaction.Type transactionType) {
        this.amount = amount;
        this.shopItem = shopItem;
        this.player = player;
        this.price = price;
        this.originalPrice = this.price;
        this.transactionType = transactionType;
        this.items = new HashMap<>();
        this.prices = new HashMap<>();
        this.originalPrices = new HashMap<>();
    }

    public PreTransactionEvent(Map<ShopItem, Integer> items, Map<EcoType, Double> prices, Player player, int amount, Transaction.Type transactionType) {
        this.amount = amount;
        this.shopItem = (ShopItem) items.keySet().toArray()[0];
        this.player = player;
        this.price = prices.get(this.shopItem.getEcoType());
        this.originalPrice = this.price;
        this.prices = prices;
        this.originalPrices = Collections.unmodifiableMap(this.prices);
        this.items = items;
        this.transactionType = transactionType;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     *
     * @return The amount of items in this transaction
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     *
     * @return The price the player will pay/get for the item(s) after the transaction is made
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the original price
     *
     * When multiple event listeners modify the {@link #setPrice(double)}, the final price for this event may be unexpected as other plugins also modify it.
     * In that case, developers should use this price as a reference
     */
    public final double getOriginalPrice() {
        return this.originalPrice;
    }

    /**
     * When the transaction mode is either
     * {@link Transaction.Type#SELL_ALL_COMMAND} or {@link Transaction.Type#SELL_GUI_SCREEN}, this will return the prices of the items sold.
     * Else this will return an empty map.
     * <p>
     * The key is the {@link EcoType} where the value is the total cost price per economy type.
     * <p>
     * See {@link ShopItem#getEcoType()} to see which items use what {@link EcoType}.
     *
     * @return All currency types together the costs which are used in this transaction
     */
    public Map<EcoType, Double> getPrices() {
        return this.prices;
    }

    /**
     * Returns an unmodifiable map of the original prices
     *
     * When multiple event listeners modify the {@link #getPrices()} map, the final prices for this event may be unexpected as other plugins also modify it.
     * In that case, developers should use this map as a reference
     */
    public final Map<EcoType, Double> getOriginalPrices() {
        return this.originalPrices;
    }

    /**
     * Can be used to add/remove a multiplier to the price of the item
     *
     * @param price The new price the player is going to pay for the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @see #getShopItem()
     * @return The ItemStack that is used for this transaction
     */
    @Deprecated
    public ItemStack getItemStack() {
        return this.shopItem.getItemToGive();
    }

    /**
     * See {@link #getItems()} to get all items sold when the {@link #getTransactionType()} is either
     * {@link Transaction.Type#SELL_ALL_COMMAND} or {@link Transaction.Type#SELL_GUI_SCREEN}.
     *
     * @return The {@link ShopItem} that is used for this transaction
     */
    public ShopItem getShopItem() {
        return this.shopItem;
    }

    /**
     * When the transaction mode is either
     * {@link Transaction.Type#SELL_ALL_COMMAND} or {@link Transaction.Type#SELL_GUI_SCREEN}, this will return the items sold.
     * Else this will return an empty map.
     * <p>
     * The key is the {@link ShopItem} where the value is the amount of items sold
     *
     * @return All items which are sold during this transaction
     */
    public Map<ShopItem, Integer> getItems() { return this.items; }

    /**
     *
     * @return The player that is making the transaction
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the transaction type
     * <p>
     * Valid transaction types:
     * {@code BUY_SCREEN}, {@code SELL_SCREEN}, {@code BUY_STACKS_SCREEN}, {@code SELL_ALL_SCREEN}
     *
     * @return The transaction type
     */
    public Transaction.Type getTransactionType() {
        return this.transactionType;
    }
}