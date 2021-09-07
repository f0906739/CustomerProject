/*
* @deprecated
* Use regular constructors instead dumbnut
 */
@Deprecated
public class CustomerFactory {
    public static Customer createCustomer(){
        return new Customer();
    }

    public static Address createAddress(){
        return new Address();
    }
}
