import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool{
    public static void main(String[] args){
        ExecutorService exe=Executors.newCachedThreadPool();
        exe.execute(()->{
            System.out.println("asd");
        });
        exe.shutdown();
    }
}