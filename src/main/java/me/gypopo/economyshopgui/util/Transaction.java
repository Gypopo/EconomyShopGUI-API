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
            return type == Type.BUY_SCREEN || type == Type.BUY_STACKS_SCREEN ? BUY : SELL;
        }
    }

    public enum Type {
        SELL_GUI_SCREEN(""),
        SELL_ALL_COMMAND(""),
        SELL_ALL_SCREEN(""),
        SELL_SCREEN(""),
        BUY_SCREEN(""),
        BUY_STACKS_SCREEN(""),
        ;

        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Result {
        // Success
        SUCCESS,
        SUCCESS_COMMANDS_EXECUTED,
        NOT_ALL_ITEMS_ADDED,

        // Failed
        NOT_ENOUGH_SPACE,
        INSUFFICIENT_FUNDS,
        NO_INVENTORY_SPACE,
        NEGATIVE_ITEM_PRICE,
        TRANSACTION_CANCELLED,
        NO_ITEMS_FOUND,
        NO_ITEM_STOCK_LEFT,
        ;
    }
}
