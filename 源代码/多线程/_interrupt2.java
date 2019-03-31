public class _interrupt2{
    public static void main(String[] args){
        MyThread x=new MyThread();
        x.start();
        try{
            Thread.currentThread().sleep(10);
        } catch(Exception e){            
        }
        x.StopThread();
    }
}
class MyThread extends Thread{
    public volatile boolean flog=false;
    @Override
    public void run() {
        int i=0;
        while(!flog){
            System.out.print(i+"->");
            i++;
        }
    }
    public void StopThread(){
        flog=true;
    }
}