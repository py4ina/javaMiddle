package patterns._5_prototype;

public class PrototypeApp {
    public static void main(String[] args) {
        Human original = new Human(18, "Vasia");
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory humanFactory = new HumanFactory(copy);
        Human human_1 = humanFactory.makeCopy();
        System.out.println(human_1);
    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    private void setPrototype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }
}