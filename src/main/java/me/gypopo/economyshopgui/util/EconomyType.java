package me.gypopo.economyshopgui.util;

public enum EconomyType {

    ITEM("Item"),
    VAULT("Vault"),
    PLAYER_POINTS("PlayerPoints"),
    GEMS_ECONOMY("GemsEconomy"),
    GEMS_ECONOMY_CURRENCY("GemsEconomy"),
    ULTRA_ECONOMY("UltraEconomy"),
    ULTRA_ECONOMY_CURRENCY("UltraEconomy"),
    ;

    private final String name;

    EconomyType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
