package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PreTransactionEvent extends Event implements Cancellable {

    private static final HandlerList handlerList = new HandlerList();
    private final int amount;
    private boolean cancelled;
    private double price;
    private final ShopItem shopItem;
    private final Player player;
    private final Transaction.Type transactionType;

    public PreTransactionEvent(ShopItem shopItem, Player player, int amount, double price, Transaction.Type transactionType) {
        this.amount = amount;
        this.shopItem = shopItem;
        this.player = player;
        this.price = price;
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
     * @return The price the player will pay/get for the item(s) after the transaction is made
     */
    public double getPrice() {
        return this.price;
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
     *
     * @see #getShopItem()
     * @return The ItemStack that is used for this transaction
     */
    @Deprecated
    public ItemStack getItemStack() {
        return this.shopItem.getItemToGive();
    }

    /**
     *
     * @return The {@link ShopItem} that is used for this transaction
     */
    public ShopItem getShopItem() {
        return this.shopItem;
    }

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