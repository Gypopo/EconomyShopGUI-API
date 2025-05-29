package me.gypopo.economyshopgui.objects.shops;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.objects.ShopPageItems;
import me.gypopo.economyshopgui.objects.mappings.ClickAction;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

public interface ShopSection {

    /**
     * @return Gets the shop category name used by the plugin
     */
    String getSection();

    /**
     *
     * @return All shop items within this shop category
     */
    Collection<ShopItem> getShopItems();

    /**
     * Returns a ShopItem object by its config path (eg. {@link ShopItem#getItemPath()})<br>
     * This is similar to using {@link EconomyShopGUIHook#getShopItem(String)} but only searches this section
     *
     * @param itemPath The config path of the item
     * @return The ShopItem object stored by this config path
     */
    ShopItem getShopItem(String itemPath);

    /**
     * Gets the ShopPageItems by the page index, starting at 1
     *
     * @param page The page to get
     * @return The page contents
     */
    ShopPageItems getShopPageItems(int page);

    /**
     *
     * @return The total amount of pages within this section
     */
    int getPages();

    /**
     *
     * @return Whether this shop is a sub category
     */
    boolean isSubSection();

    /**
     *
     * @return Whether this shop is hidden from the main menu
     */
    boolean isHidden();

    /**
     * <b>This is a premium only feature and will return {@link false} for the free version</b>
     * <br>
     * @return Whether this shop category has click commands
     */
    boolean isCommandItem();

    /**
     * <b>This is a premium only feature and will return {@link Collections#EMPTY_LIST} for the free version</b>
     * <br>
     * @return Returns a list of the click commands for this shop item
     */
    List<String> getClickCommands();

    /**
     * <b>This is a premium only feature and will return {@link Collections#EMPTY_LIST} for the free version</b>
     * <br>
     * @return Whether the inventory is closed when click commands are executed
     */
    boolean isCloseMenu();

    /**
     *
     * @return The type of this shop
     */
    ShopType getType();

    /**
     *
     * @return A list of all {@link ShopItem#itemLoc} stored within this section
     */
    List<String> getItemLocs();

    /**
     *
     * @param clickType The click type (eg. LEFT, SHIFT_LEFT, RIGHT, SHIFT_RIGHT)
     * @return The action which is taken upon clicking this shop item
     */
    ClickAction getClickAction(ClickType clickType);

    /**
     * Returns the page of the ShopItem by its {@link ShopItem#itemLoc}
     *
     * @param itemLoc The {@link ShopItem#itemLoc} of the shop item
     * @return The page index where the ShopItem is located in
     */
    int getPageForShopItem(String itemLoc);

    /**
     * Opens this shop category for the player
     *
     * @param p The player to open the shop for
     * @param disabledBackButton Whether the back button should be disabled
     */
    void openShopSection(Player p, boolean disabledBackButton);

    /**
     * Opens this shop category for the player
     *
     * @param p The player to open the shop for
     * @param disabledBackButton Whether the back button should be disabled
     */
    void openShopSection(Player p, boolean disabledBackButton, String rootSection);

    /**
     * Opens this shop category for the player
     *
     * @param p The player to open the shop for
     * @param page The page of the shop to open
     * @param disabledBackButton Whether the back button should be disabled
     */
    void openShopSection(Player p, int page, boolean disabledBackButton);

    /**
     * Opens this <b>sub</b> shop category for the player
     *
     * @param p The player to open the shop for
     * @param page The page of the shop to open
     * @param disabledBackButton Whether the back button should be disabled
     * @param rootSection The section name of the root section
     */
    void openShopSection(Player p, int page, boolean disabledBackButton, @Nullable String rootSection);

    /**
     * Dynamically reloads the existing shop item within this section from config
     *
     * @param itemPath The config path of this item ()
     */
    void reloadItem(String itemPath);
}