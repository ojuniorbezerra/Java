package reference;

import java.util.function.Consumer;

/**
 * Created by Junior on 03/06/2020.
 */
public class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}