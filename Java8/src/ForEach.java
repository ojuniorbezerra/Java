import reference.MyConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Junior on 01/06/2020.
 */
public class ForEach {

    public static void main(String[] args ){


        methodReferences(Arrays.asList("Junior", "Joao"));
    }

    public static void methodReferences(List<String> list){
        list.forEach(System.out::println);

        List<Integer> myList = new ArrayList<Integer>();

        myList.add(5);
        myList.add(3);

        myList.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        MyConsumer consumer = new MyConsumer();
        myList.forEach(consumer);
    }

}
