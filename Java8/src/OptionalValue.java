import dto.Student;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Junior on 05/06/2020.
 * Nunca, nunca, use null para uma variável Optional ou valor de retorno.
 * Nunca use Optional.get() a menos que você possa provar que o Optional está presente.
 * Prefira métodos alternativos do que Optional.isPresent()e Optional.get().
 * Geralmente é uma má ideia criar um Optional para o propósito específico dos métodos de encadeamento e a partir dele obter um valor.
 * Usar um Optional com um outro Optional aninhado, ou que tenha um resultado intermediário de Optional, provavelmente é uma solução muito complexa.
 * Evite usar Optional em campos, parâmetros de método e coleções.
 * Não use Optional para envolver qualquer tipo de coleção (List, Set, Map). Em vez disso, use uma coleção vazia para representar a ausência de valores.
 */
public class OptionalValue {

    public static void main(String[] args){

        try {
            Optional name = Optional.of(findNameOfClient(5l));
            System.out.println(name.isPresent());
        }catch (NullPointerException er){
            System.out.println("When use of the value don't be null");
        }

        Optional name = Optional.ofNullable(findNameOfClient(5l));
        name.ifPresent(n -> System.out.println(n));
        System.out.println(name.isPresent());


        Optional nameFound = Optional.ofNullable(findNameOfClient(2l));
        nameFound.ifPresent(n -> System.out.println(n));
        System.out.println(nameFound.isPresent());

        Optional<Student> student = findStudent(5l);
        if(student.isPresent()) {
            String nameStudent = student.map(Student::getName).get();
            System.out.println(nameStudent);
        }

        Optional<Student> student2 = findStudent(5l);
        String nameStudent2 = student2.map(Student::getName).orElse("NOT FOUND");
        System.out.println(nameStudent2);

        try {
            Optional<Student> student3 = findStudent(5l);
            student3.map(Student::getName).orElseThrow(NotFound::new);
        } catch (NotFound notFound) {
            System.out.println("I chose the exception when the optional is empty");
        }


        List names = new ArrayList();
        names.add("Junior");
        names.add(null);
        names.add("Gabi");


        try {
            Optional toReturn = Optional.empty();
            toReturn.get();
        }catch(NoSuchElementException err){
            System.out.println("When use of the value don't be empty");
        }



    }


    private static Optional<Student> findStudent(Long id){
        if(id.equals(2l)) return Optional.of(new Student(1,"Junior", 5));
        return Optional.empty();
    }

    private static String findNameOfClient(Long id){
        if(id.equals(2l)) return "Junior";
        return null;
    }
}
