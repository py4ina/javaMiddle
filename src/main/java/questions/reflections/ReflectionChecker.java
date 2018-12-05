package questions.reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionChecker {

    public void showClassName(Object object) {
        Class aClass = object.getClass();
        System.out.println(aClass.getName());
    }

    public void showClassFields(Object object){
        Class aClass = object.getClass();
        Field [] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }

    public void showClassMethods(Object object){
        Class aClass = object.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }

    public void showFieldsAnnotations(Object object){
        Class aClass = object.getClass();
        Field [] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation: annotations){
                System.out.println(field + "--->" + annotation.toString());
            }
        }
    }

    public void fillPrivetFilds(Object object) throws IllegalAccessException {
        Class aClass = object.getClass();
        Field [] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            Annotation annotations = field.getAnnotation(RabbitAnnotation.class);

            if (annotations != null) {
                field.setAccessible(true);
                field.set(object, "Field");
                field.setAccessible(false);
            }

        }
    }
}
