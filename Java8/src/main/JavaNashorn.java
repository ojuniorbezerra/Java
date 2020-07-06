package main;
import javax.script.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Junior on 09/06/2020.
 */
public class JavaNashorn {

    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {

        ScriptEngine se = new ScriptEngineManager().getEngineByName("Nashorn");

        se.eval(new FileReader(JavaNashorn.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("/", "//") + "js/hello.js".replaceAll("/", "//")));


        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        ee.eval("print('Hello Nashorn');");

        ScriptEngine se2 = new ScriptEngineManager().getEngineByName("Nashorn");
        se2.eval(new FileReader(JavaNashorn.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("/", "//") + "js/func.js".replaceAll("/", "//")));

        Invocable invocable = (Invocable)se2;
        invocable.invokeFunction("functionDemo1");


        invocable.invokeFunction("functionDemo2", "Junior");
    }
}
