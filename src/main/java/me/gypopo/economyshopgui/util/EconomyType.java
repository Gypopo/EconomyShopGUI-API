package me.gypopo.economyshopgui.util;

public enum EconomyType {

    EXP("EXP"),
    LEVELS("Levels"),
    ITEM("Item"),
    VAULT("Vault"),
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
