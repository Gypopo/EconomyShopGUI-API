package me.gypopo.economyshopgui.util;

import me.gypopo.economyshopgui.util.serializer.SerializerType;

import java.util.Objects;

public class ItemProviderType {
    public static final ItemProviderType EXECUTEABLE_ITEMS = new ItemProviderType("ExecutableItems", "ei");
    public static final ItemProviderType HEAD_DATABASE = new ItemProviderType("HeadDatabase", "hdb");
    public static final ItemProviderType ITEMS_ADDER = new ItemProviderType("ItemsAdder", "ia", SerializerType.ADVENTURE);
    public static final ItemProviderType MMO_ITEMS = new ItemProviderType("MMOItems", "mmoitem", SerializerType.BUKKIT_V2);
    public static final ItemProviderType ORAXEN = new ItemProviderType("Oraxen", "oraxen");
    public static final ItemProviderType BREWERY = new ItemProviderType("Brewery", "brewery");
    public static final ItemProviderType NEXO = new ItemProviderType("Nexo", "nexo");
    public static final ItemProviderType SLIMEFUN = new ItemProviderType("Slimefun", "sf");
    public static final ItemProviderType ECOITEMS = new ItemProviderType("EcoItems", "ecoitems", SerializerType.ADVENTURE);
    //MYTHIC_ITEMS("MythicItems", "mythicitems"),
    public static final ItemProviderType MYTHIC_MOBS = new ItemProviderType("MythicMobs", "mythicmobs");
    public static final ItemProviderType CRAFT_ENGINE = new ItemProviderType("CraftEngine", "craftengine");
    public static final ItemProviderType EXTERNAL = new ItemProviderType("EXTERNAL", "external");
    //CRACKSHOT,
    //EXECUTEABLE_BLOCKS,
    //ULTIMATE_FISHING, ?

    public static final ItemProviderType[] VALUES = new ItemProviderType[]{EXECUTEABLE_ITEMS, HEAD_DATABASE, ITEMS_ADDER,
            MMO_ITEMS, ORAXEN, BREWERY, NEXO, SLIMEFUN, ECOITEMS, MYTHIC_MOBS, CRAFT_ENGINE, EXTERNAL};

    public final String name;
    public final String prefix;
    public final SerializerType serializer;

    public ItemProviderType(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
        this.serializer = null;
    }

    public ItemProviderType(String name, String prefix, SerializerType serializer) {
        this.name = name;
        this.prefix = prefix;
        this.serializer = serializer;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public SerializerType getSerializer() {
        return this.serializer;
    }

    public static ItemProviderType fromName(String name) {
        for (ItemProviderType type : VALUES) {
            if (type.name.equals(name))
                return type;
        }

        return null;
    }

    public static ItemProviderType fromPrefix(String prefix) {
        for (ItemProviderType type : VALUES) {
            if (type.prefix.equals(prefix))
                return type;
        }

        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof ItemProviderType) {
            ItemProviderType type = (ItemProviderType) object;
            return this.name.equals(type.name) && this.prefix.equals(type.prefix);
        }
        if (object instanceof ItemType) {
            ItemType type = (ItemType) object;
            return type.providerType == this;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.prefix);
    }
}