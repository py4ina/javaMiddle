package com.learn.equals_hashCode;

import lombok.Data;

import java.util.Objects;

@Data
public class PhoneNumber {
    private final short areaCode;
    private final short exchange;
    private final short extension;

    public PhoneNumber(int areaCode, int exchange, int extension) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(exchange, 999, "exchange");
        rangeCheck(extension, 9999, "extension");

        this.areaCode = (short) areaCode;
        this.exchange = (short) exchange;
        this.extension = (short) extension;
    }

    private void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max){
            try {
                throw new IllegalAccessException(name + ": " + arg);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                exchange == that.exchange &&
                extension == that.extension;
    }

    @Override
    public int hashCode() {
        return 42;
//        return Objects.hash(areaCode, exchange, extension);
    }
}
