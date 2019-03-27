package questions.serialization;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloningDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        {
            Object[] src = new Object[0];
            Object[] dst = shalCopy(src);
            System.out.println(src != dst);
        } {
            Object[] src = {new Object[0]};
            Object[] dst = shalCopy(src);
            System.out.println(src[0] == dst[0]);
        } {
            Object[] src0 = {new Object[1]};
            Object[] src1 = {src0};
            src0[0] = src1;
            Object[] dst = shalCopy(src0);
            System.out.println(((Object[])dst[0])[0] != dst);
        }
    }

    public static <T extends Cloneable> T shalCopy(T obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Object.class.getDeclaredMethod("clone");
        m.setAccessible(true);
        return (T) m.invoke(obj);
    }
}