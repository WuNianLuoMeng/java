public class singleclass2 {
    public static void main(String[] srgs) {
        T x = T.getT();
    }
}

class T {
    private static T singleT;

    public T() {
    }

    public static T getT() {
        if (singleT == null)
            singleT = new T();
        return singleT;
    }

}