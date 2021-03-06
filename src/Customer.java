public class Customer {
    private final String name;
    private final Address address;
    private final int socialSecurityNumber;

    public Customer(){
        this.name = "";
        this.address = new Address();
        this.socialSecurityNumber = -1;
    }

    private Customer(String name, Address address, int socialSecurityNumber) {
        this.name = name;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Customer generateName(String name){
        return new Customer(name, this.address, this.socialSecurityNumber);
    }

    public Customer generateAddress(Address address){
        if (!address.validAddress()) return new Customer(this.name, this.address, this.socialSecurityNumber);
        return new Customer(this.name, address, this.socialSecurityNumber);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
