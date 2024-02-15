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
And don't forget to make EconomyShopGUI load before your plugin inside the plugin.yml just like so `softdepend: [EconomyShopGUI, EconomyShopGUI-Premium]`!

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
        <version>VERSION</version>
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
## Example usage inside a plugin:
AutoSellChests is a good example which uses the API of EconomyShopGUI to sell contents of the chest and sell it to the shop via the API.
See this class which gets the sell prices of the items within the chest: https://github.com/Gypopo/AutoSellChests/blob/main/src/main/java/me/gypopo/autosellchests/scheduler/SellScheduler.java#L126

## More info:
For more info on how to use the API, refer to our wiki for detailed info: https://wiki.gpplugins.com/economyshopgui/api/api-usage
