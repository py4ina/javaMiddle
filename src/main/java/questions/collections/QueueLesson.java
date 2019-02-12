package questions.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;

public class QueueLesson {
    public static void main(String[] args) {
//        Queue<Car> cars = new ArrayBlockingQueue<>(5);
        Deque<Car> cars = new ArrayDeque<>();

//        cars.add(new Car("A"));
//        cars.add(new Car("B"));
//        cars.add(new Car("C"));
//        cars.add(new Car("D"));
//        cars.add(new Car("E"));
//        cars.add(new Car("F"));

        System.out.println(cars);

        Queue lifoQueue = Collections.asLifoQueue(cars);
        lifoQueue.add(new Car("A"));
        lifoQueue.add(new Car("B"));
        lifoQueue.add(new Car("C"));
        lifoQueue.add(new Car("D"));
        lifoQueue.add(new Car("E"));
        lifoQueue.add(new Car("F"));
        System.out.println(lifoQueue);
    }
}

@Data
@AllArgsConstructor
@EqualsAndHashCode
class Car {
    private String name;
}