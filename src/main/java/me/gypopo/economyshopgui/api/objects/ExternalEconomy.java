package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.providers.economys.ExternalEconomyProvider;
import org.bukkit.OfflinePlayer;

public abstract class ExternalEconomy extends ExternalEconomyProvider {

    /**
     * Used to retrieve the amount of money a player has
     *
     *
     * @param p The player to check its balance
     * @return The amount of money in their balance
     */
    @Override
    public abstract double getBalance(OfflinePlayer p);

    /**
     * Called upon depositing balance to the player, for example when selling shop items<br>
     *
     *
     * @param p The player to deposit balance to
     * @param amount The amount to deposit
     */
    @Override
    public abstract void depositBalance(OfflinePlayer p, double amount);

    /**
     * Called upon withdrawing balance from the player, for example when buying shop items<br>
     *
     *
     * @param p The player to withdraw balance from
     * @param amount The amount to withdraw
     */
    @Override
    public abstract void withdrawBalance(OfflinePlayer p, double amount);

    /**
     * @return The name of this external economy provider used for specifying the economy in the config as 'economy: EXTERNAL:&lt;name&gt;'
     */
    @Override
    public abstract String getName();

    /**
     * The plural name of an economy is used to format price amounts != 1 by {@link ExternalEconomyProvider#formatPrice(double)}
     * <br><br>
     * Example using {@code %price% Coins}:<br>
     * {@code 23} would format as {@code 23 Coins} inside messages
     * <br><br>
     * Example using {@code $%price%}:<br>
     * {@code 23.98} would format as {@code $23.98} inside messages
     * @return The plural name of the economy
     */
    @Override
    public abstract String getPlural();

    /**
     * The singular name of an economy is used to format price amount == 1 by {@link ExternalEconomyProvider#formatPrice(double)}
     * <br><br>
     * Example using {@code %price% Coin}:<br>
     * {@code 1} would format as {@code 1 Coin} inside displayed prices
     * <br><br>
     * Example using {@code $%price%}:<br>
     * {@code 1} would format as {@code $1} inside displayed prices
     * @return The singular name of the economy
     */
    @Override
    public abstract String getSingular();

    /**
     * The friendly name of an economy is used to display in messages without displaying a actual price amount
     * <br><br>
     * Example using {@code Coins}:<br>
     * You do not have enough {@code Coins} to buy this item
     * <br><br>
     * Example using {@code money}:<br>
     * You do not have enough money to buy this item
     * @return The friendly name of the economy
     */
    @Override
    public abstract String getFriendly();

    /**
     * @return Whether the price formatter should display decimal places
     */
    @Override
    public abstract boolean isDecimal();
}