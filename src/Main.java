public class Main {
    public static void main(String[] args) {
        Singleton lol = Singleton.INSTANCE;
        Singleton hi = Singleton.INSTANCE;


        System.out.println(lol.getMessage());
        System.out.println(hi.getMessage());

        lol.print("Hello");

        System.out.println(lol.getMessage());
        System.out.println(hi.getMessage());
    }
}
