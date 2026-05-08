package me.gypopo.economyshopgui.api.events;

import me.gypopo.economyshopgui.api.objects.ExternalItems;

/**
 * Triggered when the plugin loads its item providers before registering any shop category's or items
 * When using a {@link ExternalItems} provider, developers will want to use this event to register their external provider
 */
public class ItemProviderPreLoadEvent extends CustomEvent {

    /**
     * When registering an external items provider, it is available to use on shop category's/items using 'material: EXTERNAL:&lt;prefix>:&lt;materialName>'
     *
     * @param provider The economy provider instance to register
     */
    public void registerExternal(ExternalItems provider) {}
}