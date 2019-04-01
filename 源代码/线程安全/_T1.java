import java.util.concurrent.ExecutionException;

public class _T1 {
    public static void main(String[] args) {
        Test1 x = new Test();
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

class Test1 {
    public synchronized void T() {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(Thread.currentThread().getName() + "??T????" + i + "??");
        }
    }
}