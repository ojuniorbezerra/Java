import dto.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntBiFunction;

/**
 * Created by Junior on 08/06/2020.
 */
public class ParallelArray {
    public static void main(String[] args ){
        int[] arr = {1,2,4,3,6};
        for (int i : arr){
            System.out.println(i);
        }

        Arrays.parallelSort(arr);

        for (int i : arr){
            System.out.println(i);
        }
       Student[] students = {
               new Student(1, "Junior", 31),
               new Student(2, "Gabriela", 30),
               new Student(4, "Gabi", 26),
               new Student(8, "Rafael", 17),
               new Student(3, "Murilo", 2),
       };

        System.out.println("Classic order");

        Arrays.parallelSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if( o1.age > o2.age) return 1;
                else if( o1.age < o2.age) return -1;
                else return 0;
            }
        });

        Arrays.stream(students).forEach(s -> System.out.println(s.age));

        System.out.println("Lambda order");
        Arrays.parallelSort(students, (o1, o2) -> {
                if( o1.age > o2.age) return 1;
                else if( o1.age < o2.age) return -1;
                else return 0;
            });


        Arrays.stream(students).forEach(s -> System.out.println(s.age));

        System.out.println("lambda and Integer comparing order");
        Arrays.parallelSort(students, (o1, o2) ->Integer.compare(o1.age, o2.age));

        Arrays.stream(students).forEach(s -> System.out.println(s.age));

        System.out.println("lambda and comparation order");

        Arrays.parallelSort(students, Comparator.comparing((Student s) -> s.age ));

        Arrays.stream(students).forEach(s -> System.out.println(s.age));

        System.out.println("lambda, comparation and Method Reference for order");

        Arrays.parallelSort(students, Comparator.comparing(Student::getAge));

        Arrays.stream(students).forEach(s -> System.out.println(s.age));


    }
}
