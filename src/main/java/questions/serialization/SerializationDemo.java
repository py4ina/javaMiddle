package questions.serialization;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        {
            Object[] src = new Object[0];
            Object[] dst = deepCopy(src);
            System.out.println(src != dst);
        } {
            Object[] src = {new Object[0]};
            Object[] dst = deepCopy(src);
            System.out.println(src[0] != dst[0]);
        } {
            Object[] src0 = {new Object[1]};
            Object[] src1 = {src0};
            src0[0] = src1;
            Object[] dst = deepCopy(src0);
            System.out.println(((Object[])dst[0])[0] == dst);
        }
    }

    public static <T extends Serializable> T deepCopy(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput objectOutput = new ObjectOutputStream(buff);
        objectOutput.writeObject(obj);
        objectOutput.flush();
        objectOutput.close();
        byte[] rawData = buff.toByteArray();
        ObjectInput objectInput = new ObjectInputStream(new ByteArrayInputStream(rawData));
        return (T) objectInput.readObject();
    }
}
