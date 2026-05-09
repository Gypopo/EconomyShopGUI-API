package me.gypopo.economyshopgui.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PriceModifierData {
    private final Map<PriceModifierType, Double> modifiers = new HashMap<>();

    public Double get(PriceModifierType type) {
        return this.modifiers.get(type);
    }
    public double getOr(PriceModifierType type, double def) {
        return this.modifiers.getOrDefault(type, def);
    }

    public void set(PriceModifierType type, double value) {
        this.modifiers.put(type, value);
    }

    public Set<PriceModifierType> keySet() {
        return this.modifiers.keySet();
    }
}