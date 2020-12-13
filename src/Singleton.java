class SingletonClass {
    private static SingletonClass singleton = null;

    private SingletonClass() {
        System.out.println(this);
        System.out.println(SingletonClass.this);
        System.out.println(this == SingletonClass.this);

    }

    public static SingletonClass getInstance() {

        if (singleton == null) {
            singleton = new SingletonClass();
        }
        return singleton;
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();

        System.out.println(obj1.equals(obj2));
    }
}
