import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    private static AtomicReference<User> R = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("Tom", 16);
        R.set(user); // 将User对象传入R中,相当于将user赋值给了R
        User updata = new User("Jim", 17);
        System.out.println(R.compareAndSet(user, updata)); // R与第一个参数进行比较，如果一样，则将第二个参数的值赋给R
        System.out.println(R.get().getName());
        System.out.println(R.get().getOld());
        System.out.println(user.getName() + "/" + user.getOld());  //并不会修改原来的值
    }
}

class User {
    private String name;
    private int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;

    }

    public int getOld() {
        return old;
    }
}