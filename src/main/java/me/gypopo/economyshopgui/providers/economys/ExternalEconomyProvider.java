package me.gypopo.economyshopgui.providers.economys;

import me.gypopo.economyshopgui.api.objects.ExternalEconomy;
import me.gypopo.economyshopgui.providers.EconomyProvider;
import me.gypopo.economyshopgui.util.EcoType;
import me.gypopo.economyshopgui.util.EconomyType;
import org.bukkit.OfflinePlayer;

/**
 * The internal class that powers the {@link ExternalEconomy} class
 */
public class ExternalEconomyProvider implements EconomyProvider {

    @Override
    public double getBalance(OfflinePlayer p) {
        return 0;
    }
    @Override
    public void depositBalance(OfflinePlayer p, double amount) {}
    @Override
    public void withdrawBalance(OfflinePlayer p, double amount) {}

    public String getName() {
        return "EconomyProviderName";
    }

    /**
     * Optionally override this method when using a specific currency
     * @return
     */
    public String getCurrencyName() {
        return null;
    }

    /**
     * @return A simple representation of this economy
     */
    @Override
    public final EcoType getType() {
        return new EcoType(EconomyType.EXTERNAL, this.getName() + (this.getCurrencyName() != null ? ":" + this.getCurrencyName() : ""));
    }

    /**
     * Defaults to '$'
     * @return The plural name of this economy
     */
    @Override
    public String getPlural() {
        return "$";
    }

    /**
     * Defaults to '$'
     * @return The singular name of this economy
     */
    @Override
    public String getSingular() {
        return "$";
    }

    /**
     * Defaults to 'money'
     * @return The friendly name of your economy
     */
    @Override
    public String getFriendly() {
        return "money";
    }

    /**
     * Defaults to true
     * @return Whether to use decimals
     */
    @Override
    public boolean isDecimal() {
        return true;
    }

    /**
     * Optionally override this method to use a custom formatter,
     * by default the settings inside the config.yml at path 'currency-symbols.{@link this#getName()}' will be used.
     * <br>
     * If these settings are not specified for this specific economy, the 'currency-format', 'locale' and 'abbreviations' settings will be used as a default format option
     * @param amount The amount to format
     * @return The formatted string
     */
    @Override
    public String formatPrice(double amount) {
        return "";
    }
}