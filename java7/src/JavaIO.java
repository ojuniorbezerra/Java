import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * Created by Junior on 09/06/2020.
 */
public class JavaIO {
    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {

        checkFileAndDirectoryNio();

        createFileAndDirectoryNio();

        createTemporaryFileNio();
        
        deleteFileNio();

        copyFileNio();

        moviFileNio();
    }

    private static void moviFileNio() throws IOException {

        Path dir1 = Paths.get(
                HOME + "/firstdir_" + UUID.randomUUID().toString());
        Path dir2 = Paths.get(
                HOME + "/otherdir_" + UUID.randomUUID().toString());

        Files.createDirectory(dir1);
        Files.createDirectory(dir2);

        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");

        Files.createFile(file1);
        Files.createFile(file2);

//        Files.move(file1, file2);//FileAlreadyExistsException if p2 exist

        Files.move(file1, file2, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileNio() throws IOException {
        Path p1 = Paths.get(HOME+"/teste.txt");
        if(Files.notExists(p1)) Files.createFile(p1);

        Path p2 = Paths.get(HOME+"/teste2.txt");
        if(Files.notExists(p2)) Files.createFile(p2);

//        Files.copy(p1, p2);//FileAlreadyExistsException if p2 exist
        Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);


        Path directory = Paths.get(HOME+"/test");
        if(Files.notExists(directory)) Files.createDirectory(directory);

        Path directory2 = Paths.get(HOME+"/test2");

        Files.copy(directory, directory2);

    }

    private static void deleteFileNio() throws IOException {
        Path p = Paths.get(HOME+"/teste.txt");
        if(Files.notExists(p)) Files.createFile(p);
        Path toDelete = p;

//        if(Files.exists(toDelete)) Files.delete(p);
        System.out.println(Files.deleteIfExists(p));//true

        Path dir = Paths.get(HOME+"/teste");
        if(Files.notExists(dir)) Files.createDirectory(dir);

        Path subDir = dir.resolve("texte.txt");

        Files.createFile(subDir);

        Files.delete(dir);//DirectoryNotEmptyException

    }

    private static void createTemporaryFileNio() throws IOException {
        Path p = Paths.get(HOME+"/");

        Files.createTempFile(p, "test", null);

        Path fileTemp = Files.createTempFile(null, null);

        System.out.println(Files.exists(fileTemp));//true
        System.out.println(Files.isWritable(fileTemp));//true
    }

    private static void createFileAndDirectoryNio() throws IOException {
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

    public static void checkFileAndDirectoryNio(){
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
