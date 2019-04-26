package com.learn;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Person();
        animal.eat();
        animal = new Eagle();
        animal.eat();
    }
}

interface Animal{
    public void eat();
}


class Person implements Animal{
    public void eat(){ System.out.println("Eating Food");}
}



class Eagle implements Animal{
    public void eat(){ System.out.println("Eating Snake");}
}