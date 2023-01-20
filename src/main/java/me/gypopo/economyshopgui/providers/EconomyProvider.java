package me.gypopo.economyshopgui.providers;

import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.OfflinePlayer;

public interface EconomyProvider {

    double getBalance(OfflinePlayer p);

    void depositBalance(OfflinePlayer p, double amount);

    void withdrawBalance(OfflinePlayer p, double amount);

    EcoType getType();

    String getPlural();

    String getSingular();

}
