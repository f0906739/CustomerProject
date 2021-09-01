public class Main {
    public static void main(String[] args) {
        Singleton lol = Singleton.INSTANCE;

        Customer john = new Customer();
        john = john.generateAddress(new Address("3465432 Hello World"));

        System.out.println(john.getAddress().getAddress());
        System.out.println("hellow");
    }
}
