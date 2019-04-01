import java.util.concurrent.ExecutionException;

public class _T2 {
    public static void main(String[] args) {
        Test2 x = new Test2();
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

class Test2 {
    final Object obj = new Object();
    public void T() {
        System.out.println(Thread.currentThread().getName()+"调用");
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "调用T方法" + i + "次");
            }
        }
    }
}