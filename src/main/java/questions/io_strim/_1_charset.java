package questions.io_strim;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class _1_charset {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[256];

        for (int k = 0; k < 256; k++){
            bytes[k] = (byte) (k - 128);
        }

        System.out.println(new String(bytes, "UTF-8"));
//
//        for (String name : Charset.availableCharsets().keySet()){
//            System.out.println(new String(bytes, name));
//        }
    }
}
