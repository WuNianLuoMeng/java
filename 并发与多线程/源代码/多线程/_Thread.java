public class _Thread{
    public static void main(String args[]) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("ͨ��Thread�������̣߳�����");
            }
        }.start();
        Thread y=new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("ͨ��ʵ��Runnable�ӿ��������̣߳�����");
            }
        }); 
        y.start();
    }
}