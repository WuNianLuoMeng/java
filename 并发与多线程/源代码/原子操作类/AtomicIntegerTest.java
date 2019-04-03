import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(a.getAndIncrement()); // 自增+1然后返回加1之前的结果
        System.out.println(a.get()); // 获取到加1之后的结果
        System.out.println(a.addAndGet(2)); // 2+2=4
        System.out.println(a.compareAndSet(4, 3)); // 第一个参数是与a一样大小的，所以a的值被修改为3
        System.out.println(a.get()); // 获取到修改之后的结果。

    }
}