public class Customer {
    private final String name;
    private final String address;
    private final int socialSecurityNumber;

    public Customer(){
        this.name = "";
        this.address = "";
        this.socialSecurityNumber = -1;
    }

    private Customer(String name, String address, int socialSecurityNumber) {
        this.name = name;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Customer generateName(String name){
        return new Customer(name, this.address, this.socialSecurityNumber);
    }

    public Customer generateAddress(String address){
        if (!validAddress(address)) return new Customer(this.name, this.address, this.socialSecurityNumber);
        return new Customer(name, address, this.socialSecurityNumber);
    }

    private boolean validAddress(String address){
        return new ValidAdressCalculator(this, address).compute();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
