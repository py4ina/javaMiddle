package com.learn.enum_lern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class Operation implements Serializable {
    private final transient String name;

    protected Operation(String name) {
        this.name = name;
    }

    public static Operation PLUS = new Operation("+") {
        protected double eval(double x, double y) {
            return x + y;
        }
    };

    public static Operation MINUS = new Operation("-") {
        protected double eval(double x, double y) {
            return x - y;
        }
    };

    public static Operation TIMES = new Operation("*") {
        protected double eval(double x, double y) {
            return x * y;
        }
    };

    public static Operation DIVIDE = new Operation("/") {
        protected double eval(double x, double y) {
            return x / y;
        }
    };

    protected abstract double eval(double x, double y);

    @Override
    public String toString() {
        return this.name;
    }

    public final boolean equals(Object that){
        return super.equals(that);
    }

    public final int hashCode(){
        return super.hashCode();
    }

    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final Operation[] VALUES = {PLUS, MINUS, TIMES, DIVIDE};

    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }
}
