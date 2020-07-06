import java.util.concurrent.CompletableFuture;

/**
 * Created by Junior on 06/07/2020.
 */
public class CompletableFutureExemplos {

    public static void main(String[] args){

//        int value = longNetWorkProgress(10);
//        System.out.println(value);

        //---------------------- supplyAsync -----------------------------
//        CompletableFuture.supplyAsync(() -> longNetWorkProgress( 10 ))
//                .thenAccept((value) -> System.out.println(value));
//        sleepLittle();


        //---------------------- runAsync -----------------------------
        // without return, simple process in background
//        CompletableFuture.runAsync(() -> backgroundProcess());
//        sleepLittle();

        //---------------------- currentThread -----------------------------

//        currentThreadAnalasy(); //result Thread[main,5,main]
//        CompletableFuture.supplyAsync(() -> currentThreadAnalasy())
//                .thenAccept(System.out::println); // result Thread[ForkJoinPool.commonPool-worker-1,5,main]

    //---------------------- join  -----------------------------
        //current join with pool of thread
//        CompletableFuture.runAsync(() -> backgroundProcess()).join();

        //---------------------- EXCEPTION  -----------------------------
//        CompletableFuture.runAsync(() -> exceptionProcess());
//           with join() you can see the exception in the console
    }

    private static void exceptionProcess() {
        throw new RuntimeException();
    }

    public static int currentThreadAnalasy(){
        System.out.println(Thread.currentThread());
        return 5;
    }
    public static  int longNetWorkProgress(int value){
        sleepLittle();
        return value * 5;
    }

    public static void sleepLittle(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void backgroundProcess(){
        System.out.println("Finish process");
        sleepLittle();

    }
}
