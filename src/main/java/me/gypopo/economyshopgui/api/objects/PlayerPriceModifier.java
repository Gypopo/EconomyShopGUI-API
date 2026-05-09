package me.gypopo.economyshopgui.api.objects;

import me.gypopo.economyshopgui.objects.PriceModifierData;

import java.util.Collections;
import java.util.Map;

public class PlayerPriceModifier {
    private final Map<String, PriceModifierData> sectionModifiers;
    private final Map<String, PriceModifierData> itemModifiers;

    public PlayerPriceModifier(me.gypopo.economyshopgui.objects.PlayerPriceModifier modifiers) {
        this.sectionModifiers = Collections.unmodifiableMap(modifiers.getSectionModifiers());
        this.itemModifiers = Collections.unmodifiableMap(modifiers.getItemModifiers());
    }

    public Map<String, PriceModifierData> getSectionModifiers() {
        return this.sectionModifiers;
    }

    public Map<String, PriceModifierData> getItemModifiers() {
        return this.itemModifiers;
    }
}