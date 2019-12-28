package com.learn;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HashSet<A> hashSet = new HashSet<>();
        hashSet.add(A.builder().a(1).build());
        hashSet.add(A.builder().a(1).build());

        System.out.println(hashSet);
    }
}

@Data
@AllArgsConstructor
@Builder
class A{
    private int a;
    private int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a);
    }
}