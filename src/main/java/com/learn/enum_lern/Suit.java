package com.learn.enum_lern;

import java.io.ObjectStreamException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Suit implements Comparable {
    private final String name;
    private static int nextOrdinal = 0;

    private final int ordinal = nextOrdinal++;

    public Suit(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return ordinal - ((Suit)o).ordinal;
    }

    public String toString(){
        return name;
    }

    public static final Suit CLUBS = new Suit("clubs");
    public static final Suit DIAMONDS = new Suit("diamonds");
    public static final Suit HEARTS = new Suit("hearts");
    public static final Suit SPADES = new Suit("spades");

    private static final Suit[] PRIVATE_VALUES = {CLUBS, DIAMONDS, HEARTS, SPADES};
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    private Object readResolve() throws ObjectStreamException {
        return PRIVATE_VALUES[ordinal];
    }
}
