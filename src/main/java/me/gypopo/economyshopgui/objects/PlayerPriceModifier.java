package me.gypopo.economyshopgui.objects;

import java.util.HashMap;
import java.util.Map;

public class PlayerPriceModifier {
    private final Map<String, PriceModifierData> sectionModifiers = new HashMap<>();
    private final Map<String, PriceModifierData> itemModifiers = new HashMap<>();

    public Map<String, PriceModifierData> getSectionModifiers() {
        return this.sectionModifiers;
    }

    public Map<String, PriceModifierData> getItemModifiers() {
        return this.itemModifiers;
    }
}