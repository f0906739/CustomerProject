public class Address {
    private String address;

    public String getAddress(){
        return address;
    }
    public Address() {
        this.address = "";
    }

    public Address(String address){
        this.address = address;
    }

    public boolean validAddress(){
        return new ValidAdressCalculator(this).compute();
    }
}
