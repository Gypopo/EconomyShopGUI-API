package me.gypopo.economyshopgui.providers.items;

import me.gypopo.economyshopgui.util.ExternalItemType;
import me.gypopo.economyshopgui.util.ItemType;
import me.gypopo.economyshopgui.util.exceptions.ItemLoadException;
import me.gypopo.economyshopgui.providers.ItemProvider;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ExternalItemsProvider implements ItemProvider {

    private final ItemType TYPE;

    public ExternalItemsProvider(Plugin provider, String providerPrefix) {
        TYPE = new ExternalItemType(provider, providerPrefix);
    }

    /**
     * @return A simple representation of this economy
     */
    @Override
    public final ItemType getType() {
        return this.TYPE;
    }

    /**
     * The method that is called to upon loading this item
     *
     * @param id The &lt;materialName> part specified in configs
     * @return The custom item that is identified by this ID
     */
    @Override
    public ItemStack getItem(String id) throws ItemLoadException {
        return null;
    }

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
    public String getItem(ItemStack stack) {
        return "";
    }
}