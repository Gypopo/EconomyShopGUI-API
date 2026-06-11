package me.gypopo.economyshopgui.util;

public class Transaction {

    public enum Mode {
        BUY(""),
        SELL(""),
        ;

        private String name;

        Mode(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static Mode getFromType(Type type) {
            return type == Type.BUY_SCREEN || type == Type.BUY_STACKS_SCREEN || type == Type.QUICK_BUY || type == Type.SHOPSTAND_BUY_SCREEN || type == Type.API_BUY ? BUY : SELL;
        }
    }

    public enum Type {
        SELL_GUI_SCREEN(""),
        SELL_ALL_COMMAND(""),
        SELL_ALL_SCREEN(""),
        SELL_SCREEN(""),
        BUY_SCREEN(""),
        BUY_STACKS_SCREEN(""),
        QUICK_SELL(""),
        QUICK_BUY(""),
        SHOPSTAND_BUY_SCREEN(""),
        SHOPSTAND_SELL_SCREEN(""),
        AUTO_SELL_CHEST(""),
        API_BUY("api"),
        API_SELL("api"),
        ;

        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String getMode() {return Transaction.Mode.getFromType(this).getName(); }
    }

    public enum Result {
        // Success
        SUCCESS,
        SUCCESS_COMMANDS_EXECUTED,

        // Pre checks (API usage)
        ITEM_ERROR, // ShopItem has a item error
        DISPLAY_ITEM, // ShopItem is a display item
        NEGATIVE_ITEM_PRICE, // ShopItem has none or a negative price
        NO_PERMISSIONS, // Player has no shop or item permissions
        REQUIREMENTS_FAILED, // Player does not meet requirements of shop item

        // Transaction cancel reasons
        INSUFFICIENT_FUNDS, // Not enough money
        NO_INVENTORY_SPACE, // Not enough space in inv
        TRANSACTION_CANCELLED, // Transaction cancelled by PreTransactionEvent
        NO_ITEMS_FOUND, // In sell transaction, if player doesn't have the items in the inventory to sell
        NOT_ENOUGH_ITEMS, // Amount of items being bought/sold is smaller then the min-sell/min-buy setting
        TO_MANY_ITEMS, // Amount of items being bought/sold is larger as the max-sell/max-buy setting

        // Premium transaction cancel reasons
        NO_ITEM_STOCK_LEFT, // Not enough item stock left
        REACHED_SELL_LIMIT, // Can't sell the amount of items cause of item sell limit
        CANT_STORE_PAYMENT, // If the item has a ITEM sell price and cannot fit inside the player's inventory
        ;
    }
}
