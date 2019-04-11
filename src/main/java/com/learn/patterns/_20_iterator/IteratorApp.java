package com.learn.patterns._20_iterator;

public class IteratorApp {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        Iterator iterator = concreteAggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Agregate {
    Iterator getIterator();
}

class ConcreteAggregate implements Agregate {
    String[] tasks = {"A", "B", "C"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index<tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
