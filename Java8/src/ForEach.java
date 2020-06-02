import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Junior on 01/06/2020.
 */
public class ForEach {

    public static void main(String[] args ){


        methodReferences(Arrays.asList("Junior", "Joao"));
    }

    public static void methodReferences(List<String> list){
        list.forEach(System.out::println);

    }
}
