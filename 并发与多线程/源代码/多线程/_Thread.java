import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.corba.se.impl.orbutil.closure.Future;

public class _Thread{
    public static void main(String args[]) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("通过Thread来创建线程！！！");
            }
        }.start();
        Thread y=new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("通过实现Runnable接口来创建线程！！！");
            }
        }); 
        y.start();
    }
}