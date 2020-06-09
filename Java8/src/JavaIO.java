import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Junior on 09/06/2020.
 */
public class JavaIO {

    public static void main(String[] args) throws IOException {

        File f = new File("C:\\");
        Files.list(f.toPath()).forEach(System.out::println);


        Stream.of(f.list()).forEach(System.out::println);


        File fileLines = new File("C:\\Users\\Junior\\Documents\\apex_crash.txt");

        Files.lines(Paths.get(fileLines.getPath())).forEach(System.out::println);
    }
}
