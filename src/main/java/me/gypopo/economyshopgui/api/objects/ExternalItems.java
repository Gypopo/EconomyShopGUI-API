package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.providers.items.ExternalItemsProvider;
import me.gypopo.economyshopgui.util.exceptions.ItemLoadException;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public abstract class ExternalItems extends ExternalItemsProvider {

    /**
     * Used to create a external item provider that hooks into the plugin
     * <br><br>
     * Items can then be used as 'material: "EXTERNAL:&lt;providerPrefix>:&lt;materialName>"'
     * @param provider The plugin instance which is providing the custom items(e.g. your plugin)
     * @param providerPrefix The material prefix that will be used in configs
     */
    public ExternalItems(Plugin provider, String providerPrefix) {
        super(provider, providerPrefix);
    }

    /**
     * The method that is called to upon loading this item
     *
     * @param id The &lt;materialName> part specified in configs
     * @return The custom item that is identified by this ID
     */
    @Override
    public abstract ItemStack getItem(String id) throws ItemLoadException;

    /**
     * The method called to get the id of the item (Returns NULL if none matches)
     * <br><br>
     * This method is for example called upon using the '/eshop addhanditem' command to determine the material name/id of this item
     * <br><br>
     * THIS METHOD SHOULD RETURN {@link null} IF THE ITEM DOESN'T MATCH ONE OF THE ITEMS PROVIDED BY THIS HOOK
     * @param stack The item to get the material for
     * @return String Material name/id of this item or NULL if none matches
     */
    @Override
    public abstract String getItem(ItemStack stack);
}