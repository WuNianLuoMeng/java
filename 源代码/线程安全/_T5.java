import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _T5{
    private Lock lock=new ReentrantLock();
    public static void main(String[] args){
        _T5 x=new _T5();
        new Thread("Thread1"){
            @Override
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

    public void T1(){
        if(lock.tryLock()){
            try{
                System.out.println(Thread.currentThread().getName()+"����T1����");
                try{
                    Thread.currentThread().sleep(1000);
                } catch (Exception e){

                }                
            } catch (Exception e){

            } finally{
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"�ͷ�����Դ");
            }
        } else{
            System.out.println(Thread.currentThread().getName()+"��ȡ��ʧ��"); 
        }
    }
}