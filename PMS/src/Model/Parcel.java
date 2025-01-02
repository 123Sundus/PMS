package Model;

import java.util.*;

// The Parcel class is to store  the details about each parcel.
public class Parcel {
    private String id;
    private int daysInDepot;
    private double weight;
    private double[] dimensions; // This includes the Length, Width and Height.
    private boolean isCollected;

    public Parcel(String id, int daysInDepot, double weight, double[] dimensions) {
        this.id = id;
        this.daysInDepot = daysInDepot;
        this.weight = weight;
        this.dimensions = dimensions;
        this.isCollected = false;
    }

    public String getId() {
        return id;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public double getWeight() {
        return weight;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void collect() {
        this.isCollected = true;
    }

    public double calculateFee() {
        double volume = dimensions[0] * dimensions[1] * dimensions[2];
        return (weight * 0.5) + (volume * 0.2) + (daysInDepot * 0.1);
    }
}