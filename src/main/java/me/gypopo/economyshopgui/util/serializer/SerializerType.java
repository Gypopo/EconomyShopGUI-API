package me.gypopo.economyshopgui.util.serializer;

public enum SerializerType {
    BUKKIT,
    BUKKIT_V2,

    ADVENTURE,

    CUSTOM_V1,
    CUSTOM_V2,

    ;

    final SerializerType type;

    SerializerType() {
        this.type = this;
    }

    public boolean isBukkit() {// Whether the lore can be applied to ItemMeta without reflection
        return this == BUKKIT || this == BUKKIT_V2;
    }
}
