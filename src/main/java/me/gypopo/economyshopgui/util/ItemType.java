package me.gypopo.economyshopgui.util;

import me.gypopo.economyshopgui.util.serializer.SerializerType;

public class ItemType {

    public final ItemProviderType providerType;

    public ItemType(ItemProviderType providerType) {
        this.providerType = providerType;
    }

    public String getName() {
        return this.providerType.name;
    }

    public String getPrefix() {
        return this.providerType.prefix;
    }

    public SerializerType getSerializer() {
        return this.providerType.serializer;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof ItemProviderType) {
            return object == this.providerType;
        }
        if (object instanceof ItemType) {
            ItemType type = (ItemType) object;
            return type.providerType == this.providerType;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.providerType.hashCode();
    }
}