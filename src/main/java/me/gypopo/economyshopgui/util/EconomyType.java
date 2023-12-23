package me.gypopo.economyshopgui.util;

public enum EconomyType {

    EXP("EXP"),
    ITEM("Item"),
    VAULT("Vault"),
    LEVELS("Levels"),
    ECOBITS("EcoBits"),
    COINS_ENGINE("CoinsEngine"),
    PLAYER_POINTS("PlayerPoints"),
    GEMS_ECONOMY("GemsEconomy"),
    ULTRA_ECONOMY("UltraEconomy"),
    ;

    private final String name;

    EconomyType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static EcoType getFromString(String type) {
        return null;
    }
}
