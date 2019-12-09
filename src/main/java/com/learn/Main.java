package com.learn;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");

        engine.eval("print('Hello World!!!')");

        FileReader fileReader = new FileReader("/home/vitalik/IdeaProjects/javaMiddle/src/main/java/com/learn/demo.js");
        engine.eval(fileReader);

    }
}