public class _T3{
    public static void main(String[] args){

        Test3 x=new Test3();

        new Thread("Thread1"){
            @Override
            public void run() {
                Test3.T1();
            }
        }.start();
        new Thread("Thread2"){
            @Override
            public void run() {
                x.t();
            }
        }.start();
        new Thread("Thread3"){
          @Override
          public void run() {
              Test3.T2();
          }  
        }.start();

    }
}
class Test3{    
    public synchronized static void T1(){
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"调用了T1方法"+i+"次");
        }       
    }
    public synchronized static void T2(){
        for(int i=1;i<=2;i++){
            System.out.println(Thread.currentThread().getName()+"调用了T2方法"+i+"次");
        }
    }
    public void t(){
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"调用了t方法"+i+"次");
        }
    }
}