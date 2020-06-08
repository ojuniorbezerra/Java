import java.util.Base64;

/**
 * Created by Junior on 08/06/2020.
 */
public class Base64Encoder {

    public static void main(String[] args){
        Base64.Encoder encoder = Base64.getEncoder();

        String str = encoder.encodeToString("Testing...".getBytes());
        System.out.println(str);

        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println(new String(decoder.decode(str)));




    }
}
