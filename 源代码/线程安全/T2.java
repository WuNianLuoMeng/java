import java.util.concurrent.ExecutionException;

public class T2 {
    public static void main(String[] args) {
        Test x = new Test();
        new Thread("Thread1") {
            @Override
            public void run() {
                x.T();
            }
        }.start();
        new Thread("Thread2") {
            @Override
            public void run() {
                x.T();
            }
        }.start();
    }

}

class Test {
    final Object obj = new Object();
    public void T() {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "调用了T方法" + i + "次");
            }            
        }
        System.out.println(Thread.currentThread().getName()+"使用！！！");
    }
}