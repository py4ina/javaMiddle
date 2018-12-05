package questions.reflections;

public class ReflectionExample {
    public static void main(String[] args) {
        ReflectionChecker checker = new ReflectionChecker();
        Rabbit rabbit = new Rabbit();

//        checker.showClassName(rabbit);
//        checker.showClassFields(rabbit);
//        checker.showClassMethods(rabbit);
//        checker.showFieldsAnnotations(rabbit);

        try {
            checker.fillPrivetFilds(rabbit);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(rabbit.getName());
        System.out.println(rabbit.getAge());
    }
}
