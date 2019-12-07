package com.learn.enum_lern;

public enum Country {
    US {

        public String getCurrency() {
            return "DOLLAR";
        }
    },
    RUSSIA {

        public String getCurrency() {
            return "RUBLE";
        }
    },
    INDIA {

        public String getCurrency() {
            return "RUPEE";
        }
    };

    public abstract String getCurrency();
}
