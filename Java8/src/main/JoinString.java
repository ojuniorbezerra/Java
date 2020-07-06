package main;
import java.util.StringJoiner;

/**
 * Created by Junior on 09/06/2020.
 */
public class JoinString {


    public static void main(String[] args ){

        StringJoiner string = new StringJoiner(",");


        string.add("Junior");
        string.add("Rafael");
        string.add("Gabi");


        System.out.println(string);

        System.out.println(getSelect().concat(getWhere()));

    }
    private static String getSelect(){
        StringJoiner select = new StringJoiner(" , ", "SELECT ", " FROM USER ");
        select.add("id");
        select.add("created_at");
        select.add("mother_name");
        return select.toString();
    }

    private static String getWhere(){
        StringJoiner where = new StringJoiner(" AND ", " WHERE ", "; ");
        where.add(String.format("id = %s", 10));
        where.add(String.format("name = %s", "Junior"));
        where.add(String.format("age > %s", 50));
        return where.toString();
    }
}
