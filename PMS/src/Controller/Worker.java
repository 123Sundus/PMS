package Controller;

import Model.*;

// The Worker class is to process customer requests into it. 
public class Worker {
    public void processCustomer(Customer customer, ParcelMap parcelMap, Log log) {
        Parcel parcel = parcelMap.getParcel(customer.getParcelId());
        if (parcel != null && !parcel.isCollected()) {
            parcel.collect();
            log.addEntry("Customer " + customer.getName() + " collected parcel " + parcel.getId() + ". Fee: " + parcel.calculateFee());
        } else {
            log.addEntry("Parcel not found or already collected for customer " + customer.getName());
        }
    }
}