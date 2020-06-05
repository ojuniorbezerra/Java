package reference;

import dto.Hello;

/**
 * Created by Junior on 01/06/2020.
 */
public class ReferenceInstance {

    public void display(){
        System.out.println("Reference Interface");
    }

    public static void main(String[] args){

        ReferenceInstance ri = new ReferenceInstance();
        MyInterface myInterface = ri::display;
        myInterface.display();


        HelloInterface testHello = Hello::new;

        testHello.display("Text reference to constructor");

    }
}
