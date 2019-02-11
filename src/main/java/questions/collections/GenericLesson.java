package questions.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GenericLesson {
    public static void main(String[] args) {
//        Printer<Integer> printerInteger = new Printer<>();
//        printerInteger.setData(new A(123).getData());
//        printerInteger.printData();

        Printer<String, Integer> printer = new Printer<>("AA", 22);
        printer.printData();
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