package questions.serialization;

import java.io.*;

public class SerializationDemo {

    public static <T extends Serializable> T copy(T obj) throws IOException, ClassNotFoundException {
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
