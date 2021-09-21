# EconomyShopGUI-API
The API of EconomyShopGUI can be used by developers to integrate with your plugin.
## Introduction:
Latest version: [![](https://jitpack.io/v/Gypopo/EconomyShopGUI-API.svg)](https://jitpack.io/#Gypopo/EconomyShopGUI-API)

If any issues are found, you may submit a issue on the issue tracker.

The API has been added since version 3.9/1.12 of EconomyShopGUI, this means the server where the API is used needs to have the same or later version of EconomyShopGUI installed.

As of now, the API is similar for the free and premium version, meaning that if the server running the API has EconomyShopGUI Premium installed that this will just work fine, the same for the free version.
However, if you plan on using the API for servers with the free or premium version, you should add a softdepend to your plugin.yml for both versions.
## Integrating with the API:
Integrating with the API is very simple. 
Just add the repository and dependancy to the pom.xml when using maven or the build.gradle when using gradle. 
And don't forget to make EconomyShopGUI load before your plugin inside the plugin.yml just like so softdepend: `[EconomyShopGUI, EconomyShopGUI-Premium]`!

**Using the pom.xml in maven:**
```XML
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.Gypopo</groupId>
        <artifactId>EconomyShopGUI-API</artifactId>
        <version>Tag</version>
    </dependency>
</dependencies>
```
**Using the build.gradle in gradle**
```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
        implementation 'com.github.Gypopo:EconomyShopGUI-API:VERSION'
}
```
## Example usage:
When integrated with the API, calling methods is as simple as:
```java
EconomyShopGUIHook.someMethod();
```
Example to get the prices of certain items:
```java
Double buyPrice = EconomyShopGUIHook.getItemBuyPrice(new ItemStack(Material.COBBLESTONE));
if (buyPrice != null) p.sendMessage(ChatColor.GREEN + "The buy price of the item is: " + buyPrice);

Double buyPriceDiscounted = EconomyShopGUIHook.getItemBuyPrice(p, new ItemStack(Material.BEETROOT));
if (buyPriceDiscounted != null) p.sendMessage(ChatColor.GREEN + "The discounted buy price of the item is: " + buyPriceDiscounted);

Double sellPrice = EconomyShopGUIHook.getItemSellPrice(new ItemStack(Material.BEDROCK));
if (sellPrice != null) p.sendMessage(ChatColor.GREEN + "The sell price of the item is: " + sellPrice);
```
## Methods:
The below methods are available for developers to use within their plugin.
Suggetions can be made to expand the API.
```java
/**
 * Gets a item sell price
 * If the item couldn't be found inside the shop, this will return null
 *
 * @param item The item to get the sell price for
 * @return The sell price of the item, if not found this will return null
 */
public static Double getItemSellPrice(ItemStack item) {
    return null;
}

/**
 * Gets a item buy price
 * If the item couldn't be found inside the shop, this will return null
 *
 * @param item The item to get the buy price for
 * @return The buy price of the item, if not found this will return null
 */
public static Double getItemBuyPrice(ItemStack item) {
    return null;
}

/**
 * Gets a item buy price with any discount included for the player if present
 * If the item couldn't be found inside the shop, this will return null
 *
 * @param player Player to check for discounts
 * @param item The item to get the buy price for
 * @return The buy price of the item, if not found this will return null
 */
public static Double getItemBuyPrice(Player player, ItemStack item) {
    return null;
}
```
