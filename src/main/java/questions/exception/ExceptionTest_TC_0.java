package questions.exception;

import java.io.IOException;

public class ExceptionTest_TC_0 {
    public static void main(String[] args){
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}