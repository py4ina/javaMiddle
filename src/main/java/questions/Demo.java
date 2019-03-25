package questions;

public class Demo {
    public static void main(String args[]){
        Vehicle v = new Car();
        v.kmToMiles(10);
    }
}

class Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри родительского класса/статического метода");
    }
}

class Car extends Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри дочернего класса/статического метода ");
    }
}