import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _T4 {
    private Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        _T4 x = new _T4();
        new Thread("Thread1") {
            public void run() {
                x.T1();
            }
        }.start();
        new Thread("Thread2"){
            @Override
            public void run() {
                x.T1();
            }
        }.start();
    }
    private void T1() {                
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "执行了T1方法");
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了对象锁");
        }
    }
}
