package Model;

//  This Customer class  is to store customer details.
public class Customer {
    private String name;
    private String parcelId;

    public Customer(String name, String parcelId) {
        this.name = name;
        this.parcelId = parcelId;
    }

    public String getName() {
        return name;
    }

    public String getParcelId() {
        return parcelId;
    }
}