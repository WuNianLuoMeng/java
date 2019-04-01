public class singleclass1 {
    public static void main(String[] args) {
        T x = T.getT();
    }
}

class T {
    private static T singleT = new T();
    public T(){}
    public static T getT() {
        return singleT;
    }
}