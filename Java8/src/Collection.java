import dto.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Junior on 04/06/2020.
 *  Reference: https://www.codementor.io/@sureshatta/java-8-collection-api-changes-part1-map-5kdf0vjkx
 */
public class Collection {

    public static void main(String[] args){
        groupingBy();
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return ta -> seen.add(keyExtractor.apply(ta));
    }
    @FunctionalInterface
    public interface StudentI {
        String getName();
    }
    private static void groupingBy(){

        List<String> names = Arrays.asList("Junior", "Gabriela", "Felipe", "Junior");

        Map<String, Long> qtdNames = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(qtdNames);

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Junior", 31));
        students.add(new Student(2, "Gabriela", 30));
        students.add(new Student(2, "Gabriela", 30));
        students.add(new Student(3, "Murilo", 2));
        students.add(new Student(3, "Murilo", 2));


        Set<String> namesSet = students.stream().filter(s -> s.age >= 30).map(s -> s.name).collect(Collectors.toSet());

        System.out.println(namesSet);

//
//        Function<Student, Function> name = stud -> stud::getName;
//
//
//        Function<Function, Predicate> distinct = (keyExtractor) -> {
//            Set<Object> seen = ConcurrentHashMap.newKeySet();
//            return t -> seen.add(keyExtractor.apply(t));
//        };
//        name.apply(new Student(1,"", 10));
//
//        distinct.apply()
//        Double ageAV = students.stream().filter(s -> distinct.apply(name.apply(s))).collect(Collectors.averagingDouble(s -> s.age));



        Double ageAV = students.stream().filter(distinctByKey(Student::getName)).collect(Collectors.averagingDouble(s -> s.age));


        System.out.println(ageAV);

        Map<String, String> map = new HashMap<>();
        map.put("C", "c");
        map.put("B", "b");
        map.compute("B", (k, v) -> v.concat(" - new "));
        System.out.println(map.get("B"));// prints "b - new"


        Map<String, String> map2 = new HashMap<>();
        map2.put("C", "c");
        map2.put("B", "b");
        map2.merge("B", "New", (v1, v2) -> v2 + " - "+v1);
        System.out.println(map2.get("B"));// prints New - b

        Map<String, String> map3 = new HashMap<>();
        map3.put("C", "c");
        map3.put("B", "b");
        map3.putIfAbsent("B", "c");
        System.out.println(map3.get("B"));// prints "b"
        map3.replaceAll((k,v) -> "x" );
        map3.forEach((k,v) -> System.out.print(k + " " + v + " "));// prints B x C x
    }
}
