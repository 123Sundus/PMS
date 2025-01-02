package Model;

import java.util.HashMap;

// This ParcelMap class  is to store parcels in the map.
public class ParcelMap {
    private HashMap<String, Parcel> parcelMap;

    public ParcelMap() {
        this.parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(String id) {
        return parcelMap.get(id);
    }

    public void removeParcel(String id) {
        parcelMap.remove(id);
    }

    public HashMap<String, Parcel> getAllParcels() {
        return parcelMap;
    }
}