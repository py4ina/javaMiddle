package questions.io_strim;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class _1_charset {
    public static void main(String[] args) throws UnsupportedEncodingException {

        try(InputStream inputStream = new URL("https://jsehelper.blogspot.com/2016/01/java-core-1.html").openStream()) {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            char[] buffer = new char[16];
            int count;
            while ((count = reader.read(buffer)) != -1){
                System.out.print(new String(buffer, 0, count));
            }
            System.out.println(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
