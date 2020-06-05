package dto;

/**
 * Created by Junior on 04/06/2020.
 */
public class Student{
    public int id;
    public String name;
    public int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

}