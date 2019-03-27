package questions.serialization;

import java.io.Serializable;

public class ShallowCopy {
    public static void main(String[] args) {
        Person husband = new Person();
        husband.name = "A";
        Person wife = new Person();
        wife.name = "B";
        husband.couple = wife;
        wife.couple = husband;

        Person husband2 = new Person(husband);
        System.out.println(husband2);
    }
}

class Person implements Serializable {
    public transient String name;
    public Person couple;

    Person(){}

    Person(Person source) {
        this.name = source.name;
        this.couple = source.couple;
    }
}
