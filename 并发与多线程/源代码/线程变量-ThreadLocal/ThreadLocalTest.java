import java.lang.*;

import com.sun.corba.se.impl.orbutil.StackImpl;
public class ThreadLocalTest{
    private static ThreadLocal<String> name=new ThreadLocal<>();
    private static ThreadLocal<Long> id=new ThreadLocal<>();
    public static String getName(){
        return name.get();
    }
    public static Long getId(){
        return id.get();
    }
    public static void main(String[] args){
        Thread[] arr=new Thread[5];
        for(int i=0;i<5;i++){
            arr[i]=new Thread(()->{
                name.set(Thread.currentThread().getName());
                id.set(Thread.currentThread().getId());
                System.out.println("name:"+ThreadLocalTest.getName()+"  id:"+ThreadLocalTest.getId());
                //System.out.println(name);
                //System.out.println(id);
            });
            arr[i].start();
        }

    }
}