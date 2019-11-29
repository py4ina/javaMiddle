package com.learn.enum_lern;

public abstract class Operation {
    private String name;

    public Operation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    protected abstract double eval(double x, double y);

    public static final Operation PLUS = new Operation("+") {
        @Override
        double eval(double x, double y) {
            return x + y;
        }
    };

    public static final Operation MINUS = new Operation("-") {
        @Override
        double eval(double x, double y) {
            return x - y;
        }
    };

    public static final Operation TIMES = new Operation("*") {
        @Override
        double eval(double x, double y) {
            return x * y;
        }
    };

    public static final Operation DIVIDED_BY = new Operation("/") {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };
}
