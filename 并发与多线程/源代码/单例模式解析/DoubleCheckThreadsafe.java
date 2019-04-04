import com.sun.xml.internal.txw2.output.StaxSerializer;

public class DoubleCheckThreadsafe {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            new Thread(){
                @Override
                public void run() {                    
                    System.out.println(Test.getTest());
                }
            }.start();
        }
    }
}

// 饿汉模式
class Test {

    public static volatile Test test = null;
    public static Test getTest() {
        if (test == null) {               //第一次检查
            synchronized (Test.class) {
                if (test == null)         //第二次检查
                    test = new Test();
                return test;
            }
        }
        return test;
    }

}