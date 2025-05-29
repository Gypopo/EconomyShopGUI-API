package me.gypopo.economyshopgui.objects;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ShopPageItems {

    /**
     *
     * @return The inventory size of this page
     */
    public int getSize() {
        return 0;
    }

    /**
     * Returns a map of the items stored in this page,<br>
     * where the key of the map is the slot within the GUI and the value is the {@link ShopItem#getShopItem()} item stack
     *
     * @return The items of this page
     */
    public Map<Integer, ItemStack> getItems() {
        return new HashMap<>();
    }

    /**
     *
     * @param slot The slot within the page
     * @return Returns the item index({@link ShopItem#itemLoc})
     */
    public String getItem(int slot) {
        return new String();
    }
}