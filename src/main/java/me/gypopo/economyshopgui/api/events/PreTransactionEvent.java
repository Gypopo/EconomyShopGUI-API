package me.gypopo.economyshopgui.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PreTransactionEvent extends Event implements Cancellable {

    private static final HandlerList handlerList = new HandlerList();
    private boolean cancelled;
    private double price;
    private final ItemStack itemStack;
    private final Player player;
    private final String transactionMode;

    public PreTransactionEvent(ItemStack itemStack, Player player, double price, String transactionMode) {
        this.itemStack = itemStack;
        this.player = player;
        this.price = price;
        this.transactionMode = transactionMode;
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
     * @return The ItemStack that is used for this transaction
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     *
     * @return The player that is making the transaction
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the transaction mode
     * <p>
     * Valid transaction modes:
     * {@code BUY}, {@code SELL}, {@code BUY_STACKS}, {@code SELL_ALL}
     *
     * @return Whether the player purchases or sells an item
     */
    public String getTransactionMode() {
        return this.transactionMode;
    }
}