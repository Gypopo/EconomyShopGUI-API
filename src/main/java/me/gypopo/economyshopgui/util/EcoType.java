package me.gypopo.economyshopgui.util;

import javax.annotation.Nullable;
import java.util.Objects;

public class EcoType {

    EconomyType type;
    private final String currency;

    public EcoType(EconomyType type) {
        this.type = type;
        this.currency = null;
    }

    public EcoType(EconomyType type, String currency) {
        this.type = type;
        this.currency = currency;
    }

    public EconomyType getType() {
        return this.type;
    }

    @Nullable
    public String getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return this.currency == null ? this.type.getName() : this.type.getName() + ":" + this.currency;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            EcoType holder = (EcoType) object;
            return this.type.equals(holder.type) && Objects.equals(this.currency, holder.currency);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.currency);
    }
}
