package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.util.EcoType;
import me.gypopo.economyshopgui.util.Transaction;

import java.util.Map;

public class TransactionResult {
    private final Transaction.Result result;
    private final Map<EcoType, Double> prices;
    private final int amount;

    public TransactionResult(Transaction.Result result) {
        this.result = result;
        this.prices = null;
        this.amount = 0;
    }

    public TransactionResult(Transaction.Result result, Map<EcoType, Double> prices, int amount) {
        this.result = result;
        this.prices = prices;
        this.amount = amount;
    }

    /**
     * Gets the result of this transaction, a transaction is completed if either SUCCESS or SUCCESS_COMMANDS_EXECUTED
     *
     * @return The result of this transaction
     */
    public Transaction.Result getResult() {
        return this.result;
    }

    /**
     * Gets the prices withdrawn from the players balance
     * <br><br>
     * <b>NOTE</b> that these prices may be different from the expected prices of the {@link EconomyShopGUIHook#purchaseItem} method used if {@link allowQuantityChange} is true
     *
     * @return The prices withdrawn from the player's balance
     */
    public Map<EcoType, Double> getPrices() {
        return this.prices;
    }

    /**
     * Returns the amount of items from this transaction
     * <br><br>
     * <b>NOTE</b> that this amount may be different from the amount used within the {@link EconomyShopGUIHook#purchaseItem} method if {@link allowQuantityChange} is true
     *
     * @return The actual amount of items bought/sold
     */
    public int getAmount() {
        return this.amount;
    }
}