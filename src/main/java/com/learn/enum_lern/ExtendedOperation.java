package com.learn.enum_lern;

import java.io.ObjectStreamException;

public abstract class ExtendedOperation extends Operation {
    protected ExtendedOperation(String name) {
        super(name);
    }

    public static Operation LOG = new ExtendedOperation("log") {
        protected double eval(double x, double y) {
            return Math.log(x) / Math.log(y);
        }
    };

    public static Operation EXP = new ExtendedOperation("exp") {
        protected double eval(double x, double y) {
            return Math.pow(x, y);
        }
    };

    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final Operation[] VALUES = {LOG, EXP};

    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }
}
