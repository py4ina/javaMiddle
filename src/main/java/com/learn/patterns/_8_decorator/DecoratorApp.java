package com.learn.patterns._8_decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface quotesDecorator =
                new QuotesDecorator(
                    new RightBracketDecorator(
                        new LeftBracketDecorator(
                                new QuotesDecorator(
                                        new Printer("Quotes-Decorator")))));
        quotesDecorator.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {

    String value;
    public Printer(String value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }

}

abstract class Decorator implements PrinterInterface {
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    public void print(){
        component.print();
    }
}

class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("'");
        super.print();
        System.out.print("'");
    }
}

class LeftBracketDecorator extends Decorator {
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        super.print();
        System.out.print("]");
    }
}