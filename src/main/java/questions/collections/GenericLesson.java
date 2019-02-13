package questions.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class GenericLesson {
    public static void main(String[] args) {
        Integer i = mock(1);
    }

    private static void testGenericsA() {
        ArrayList<Integer> integers = new ArrayList<>(10);
        integers.set(0, new Integer(1));
        ArrayList<Object> objects = new ArrayList<>(10);
        copyGen(integers, objects);
        Object noCast = objects.get(0);
    }

    public static <T> void copyGen(ArrayList<? extends T> src, ArrayList<? super T> dst ) {
        int length = min(src.size(), dst.size());
        for (int k = 0; k < length; k++) {
            dst.set(k, src.get(k));
        }
    }

    public static <T> T mock(T arg) {
        return null;
    }
}

@Data
@AllArgsConstructor
class Printer<T, N> {
    private T data;
    private N data2;

    void printData(){
        System.out.println(this.data);
        System.out.println(this.data2);
    }
}

@Data
@AllArgsConstructor
class A {
    int data;
}

@Data
@AllArgsConstructor
class B {
    String data;
}