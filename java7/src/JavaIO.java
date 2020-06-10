import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by Junior on 09/06/2020.
 */
public class JavaIO {
    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {

//        checkFileAndDirectoryNio2();

//        createFileAndDirectoryNio2();

        createTemporaryFileNio2();
    }

    private static void createTemporaryFileNio2() throws IOException {
        Path p = Paths.get(HOME+"/");

        Files.createTempFile(p, "test", null);

        Path fileTemp = Files.createTempFile(null, null);

        System.out.println(Files.exists(fileTemp));//true
        System.out.println(Files.isWritable(fileTemp));//true
    }

    private static void createFileAndDirectoryNio2() throws IOException {
        Path p = Paths.get(HOME+"/Downloads/"+ UUID.randomUUID().toString() + ".txt");

        if(Files.notExists(p)){
            Files.createFile(p); //created
        }

        Path diretory = Paths.get(HOME+"/Downloads/"+ UUID.randomUUID().toString());

        if(Files.notExists(diretory)){
            Files.createDirectory(diretory);
        }

        System.out.println(Files.exists(diretory));
        System.out.println(Files.isRegularFile(diretory));
        System.out.println(Files.isDirectory(diretory));


        Path subDir = diretory.resolve("teste");

        if(Files.notExists(subDir)){
            Files.createDirectory(subDir);
        }

    }

    public static void checkFileAndDirectoryNio2(){
        Path path = Paths.get(HOME);
        path.forEach(System.out::println);


        Path filePath = Paths.get(HOME + "/testing.txt");

        System.out.println(Files.notExists(filePath)); //output: true

        System.out.println(Files.isRegularFile(filePath));//output: false

        System.out.println(Files.isDirectory(filePath));//output: false

        Path myFolder = Paths.get(HOME + "/Downloads");

        System.out.println(Files.isRegularFile(myFolder));//output: false

        System.out.println(Files.isDirectory(myFolder));//output: true

        Path myFileTest = Paths.get(HOME + "/Downloads/test.txt");

        System.out.println(Files.isExecutable(myFolder));//output: false

        if(Files.isRegularFile(myFileTest )){
            if(Files.isWritable(myFileTest )){
                //can todo something
            }
        }

        Path myFileTest2 = Paths.get(HOME + "/Downloads/test2.txt");

        try {
            System.out.println(Files.isSameFile(myFileTest, myFileTest2)); // NoSuchFileException
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
