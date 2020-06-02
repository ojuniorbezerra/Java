package reference;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by Junior on 01/06/2020.
 */
public class ReferenceMethod {

    public static int multiply(int a, int b){
    return a * b;
    }

    public static void main(String[] args){

        BiFunction<Integer, Integer, Integer> multiply = ReferenceMethod::multiply;
        System.out.println(multiply.apply(5,5));


        String[] list = {"Junior", "Rafael", "Joao", "Aline"};

        Arrays.sort(list, String::compareTo);

        for (String value : list){
            System.out.println(value);
        }
    }
}
