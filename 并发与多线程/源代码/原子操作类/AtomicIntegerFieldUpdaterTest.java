import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<Student> R=AtomicIntegerFieldUpdater.newUpdater(Student.class, "old");

    public static void main(String[] args) {
        Student a = new Student("Tom", 15);
        System.out.println(R.getAndIncrement(a));
        System.out.println(R.get(a));
    }
}

class Student {
    private String name;
    public volatile int old;

    public Student(String name, int old) {
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