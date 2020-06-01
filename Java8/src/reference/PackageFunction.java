package reference;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.*;

/**
 * Created by Junior on 01/06/2020.
 * Reference: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 */
public class PackageFunction {

    public static void main(String[] args){

       BiPredicate<Integer, Integer> validate = (number1, number2) -> number1 > 0 && number2 > 10;

        BiFunction<Integer, Integer, Integer> sum = (number1, number2) -> number1 + number2;
       if (validate.test(1, 50)) {
            System.out.println(sum.apply(1,50));
       }

        BiConsumer<Integer, String> concat = (age, name) -> System.out.println("Name: " +  name + ", Age: " +age);
       concat.accept(10, "Junior");

        Consumer<String> print = name -> System.out.println(name);
        print.accept("Felipe");


        IntFunction resultBigInteger = (number) -> BigInteger.ONE;
        System.out.println(resultBigInteger.apply(68));

        IntFunction resultString = (number) -> "Texte testing...";
        System.out.println(resultString.apply(100));

        ToIntFunction resultOnlyInt = value -> 10;
        System.out.println(resultOnlyInt.applyAsInt(100));
        System.out.println(resultOnlyInt.applyAsInt("String paramenter"));
        System.out.println(resultOnlyInt.applyAsInt(BigDecimal.ZERO));

        ToIntBiFunction resultBiOnlyInt = (value1, value2 ) -> 10;
        System.out.println(resultBiOnlyInt.applyAsInt(100, ""));
        System.out.println(resultBiOnlyInt.applyAsInt("String paramenter", new Object()));
        System.out.println(resultBiOnlyInt.applyAsInt(BigDecimal.ZERO, 68l));




    }

}
