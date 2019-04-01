import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool{
    public static void main(String[] args){
        ExecutorService exe=Executors.newCachedThreadPool();  //创建线程池
        exe.execute(()->{
            System.out.println("asd");
        });
        exe.shutdown();  //关闭线程池
    }
}