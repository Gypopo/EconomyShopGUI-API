package me.gypopo.economyshopgui.util;

import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class ExternalItemType extends ItemType {

    private final String provider;
    private final String providerPrefix;

    public ExternalItemType(Plugin provider, String providerPrefix) {
        super(ItemProviderType.EXTERNAL);
        this.provider = provider.getName();
        this.providerPrefix = providerPrefix;
    }

    public ExternalItemType(String providerPrefix) {
        super(ItemProviderType.EXTERNAL);
        this.provider = "";
        this.providerPrefix = providerPrefix;
    }

    @Override
    public String getName() {
        return this.provider;
    }

    @Override
    public String getPrefix() {
        return this.providerPrefix;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof ExternalItemType) {
            ExternalItemType type = (ExternalItemType) object;
            return type.providerPrefix.equals(this.providerPrefix);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.providerPrefix);
    }
}