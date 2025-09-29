package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.api.objects.ExternalEconomy;
import me.gypopo.economyshopgui.providers.economys.ExternalEconomyProvider;

/**
 * Triggered when the plugin loads its economy providers before registering any shop category's or items AND on /sreload
 * When using a {@link ExternalEconomy} economy, developers will want to use this event to register their external economy providers
 */
public class EconomyPreLoadEvent extends CustomEvent {

    /**
     * When registering an external economy, it is available to use on shop category's/items using 'economy: EXTERNAL:&lt;name>'
     * <br><br>
     * Optionally when overriding the {@link ExternalEconomyProvider#getCurrencyName()} method with the name of your currency,
     * you will need to use the setting 'economy: EXTERNAL:&lt;name>:&lt;currency>' to use your currency on shop category's/items
     *
     * @param economy The economy provider instance to register
     */
    public void registerExternal(ExternalEconomy economy) {}
}