package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.EcoType;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class PostTransactionEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final int amount;
    private final double price;
    private final Map<EcoType, Double> prices;
    private final ShopItem shopItem;
    private final Player player;
    private final Map<ShopItem, Integer> items;
    private final Transaction.Type type;
    private final Transaction.Result result;

    public PostTransactionEvent(ShopItem shopItem, Player player, int amount, double price, Transaction.Type type, Transaction.Result result) {
        this.amount = amount;
        this.shopItem = shopItem;
        this.player = player;
        this.price = price;
        this.type = type;
        this.result = result;
        this.items = new HashMap<>();
        this.prices = new HashMap<>();
    }

    public PostTransactionEvent(Map<ShopItem, Integer> items, Map<EcoType, Double> prices, Player player, int amount, Transaction.Type type, Transaction.Result result) {
        this.amount = amount;
        this.shopItem = items.size() >= 1 ? (ShopItem) items.keySet().toArray()[0] : null;
        this.player = player;
        this.price = this.shopItem != null ? prices.get(this.shopItem.getEcoType()) : 0;
        this.type = type;
        this.result = result;
        this.items = items;
        this.prices = prices;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
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
     * @return The final price the player has payd/gotten for the item(s) with this transaction
     */
    public double getPrice() {
        return this.price;
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
     * @see #getShopItem()
     * @return The itemStack that should be given to the player
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
     * @return The player that triggered this transaction
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the transaction type
     *
     * @return The method that is used for this transaction
     */
    public Transaction.Type getTransactionType() {
        return this.type;
    }

    /**
     * Returns the transaction result
     *
     * @return The result of this transaction
     */
    public Transaction.Result getTransactionResult() {
        return this.result;
    }
}
