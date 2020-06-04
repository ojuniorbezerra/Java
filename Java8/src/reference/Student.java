package reference;

/**
 * Created by Junior on 04/06/2020.
 */
public class Student{
    int id;
    String name;
    int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}