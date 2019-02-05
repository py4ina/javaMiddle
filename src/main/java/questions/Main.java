package questions;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Object ref = new User(25, "Mike");
        Class aClass = ref.getClass();
        Method[] methods = aClass.getMethods();
        System.out.println(Arrays.toString(methods));
    }
}

class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }
}