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
            System.out.println(Thread.currentThread().getName()+"������T1����"+i+"��");
        }       
    }
    public synchronized static void T2(){
        for(int i=1;i<=2;i++){
            System.out.println(Thread.currentThread().getName()+"������T2����"+i+"��");
        }
    }
    public void t(){
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"������t����"+i+"��");
        }
    }
}