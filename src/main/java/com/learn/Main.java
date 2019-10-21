package com.learn;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(new Integer(random.nextInt(100)));
        }

        for (int i = 0; i < 7; i++) {
            Integer integer = queue.poll();
            System.out.println("Обрабатываем Integer:" + integer);
        }

        Queue<Customer> customers = new PriorityQueue<>(7, Comparator.comparingInt(Customer::getId));
        addDataToQueue(customers);
        pollDataFromQueue(customers);


    }

    private static void addDataToQueue(Queue<Customer> customerPriorityQueue){
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int id = random.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Vova_"+id));
        }
    }

    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue){
        while (true){
            Customer customer = customerPriorityQueue.poll();
            if (customer == null) break;
            System.out.println("Обработка клиента с id=" + customer.getId());
        }
    }
}

@Data
@AllArgsConstructor
class Customer {
    private int id;
    private String name;
}
