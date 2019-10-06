package com.learn.equals_hashCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhoneNumber {
    @EqualsAndHashCode.Include
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
}
