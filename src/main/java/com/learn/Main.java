package com.learn;

public class Main {

    public static void main(String[] args) {
        if (a() && b()){

        }
    }

    private static boolean a (){
        System.out.println("a");
        return true;
    }

    private static boolean b (){
        System.out.println("b");
        return true;
    }
}

class Superclass {
    public static int field;
    public static int getField() { return field; }
    public static void setField(int value) { field = value; }
}

class Superclass2 {
    public int field;
    public int getField() { return field; }
    public void setField(int value) { field = value; }
}

class Subclass extends Superclass2 {
    public int field;

    public int getField() {
        return field;
    }

    public void setField(int value) {
        field = value;
    }

    public static void main(String[] params) {
        Superclass2 sup = new Subclass();
        sup.field = 1;
        System.out.println("Subclass field: " + sup.getField());
    }
}
