package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PostTransactionEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final double price;
    private final ItemStack itemStack;
    private final Player player;
    private final Transaction.Type type;
    private final Transaction.Result result;

    public PostTransactionEvent(ItemStack itemStack, Player player, double price, Transaction.Type type, Transaction.Result result) {
        this.itemStack = itemStack;
        this.player = player;
        this.price = price;
        this.type = type;
        this.result = result;
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
     * @return The final price the player has payd/gotten for the item(s) with this transaction
     */
    public double getPrice() {
        return this.price;
    }

    /**
     *
     * @return The itemStack that should be given to the player
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

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
