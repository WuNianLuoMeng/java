import java.util.concurrent.atomic.AtomicIntegerArray;;

public class AtomicIntegetArrayTest {
    private static int[] value = new int[] { 1, 2 };
    private static AtomicIntegerArray a = new AtomicIntegerArray(value);
    public static void main(String[] srgs){
        a.getAndSet(0, 3);          //将第一个元素的值替换成3
        System.out.println(a.get(0));  
        System.out.println(value[0]);   //原数组中的位置的值是不发生改变的
    }
}