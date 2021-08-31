public class Main {
    public static void main(String[] args) {
        Singleton lol = Singleton.INSTANCE;
        Customer john = new Customer();
        john = john.generateAddress("3465432 Hello World");
        System.out.println(john.getAddress());
    }
}
