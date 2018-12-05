package questions.reflections;

public class Rabbit {
    @Deprecated
    @RabbitAnnotation
    private String name;

    @Deprecated
    private String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
