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