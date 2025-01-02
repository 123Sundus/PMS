package Main;

import Model.*;
import Controller.*;
import View.*;

import javax.swing.*;
import java.io.*;
import java.util.*;

// This Manager class is to drive the program throughout.
public class Manager {
    public static void main(String[] args) {
        // This Initializes the components
        ParcelMap parcelMap = new ParcelMap();
        QueueofCustomers queueOfCustomers = new QueueofCustomers();
        Log log = Log.getInstance();

        // This Loads the parcels from CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("Parcels.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                int daysInDepot = Integer.parseInt(data[1]);
                double weight = Double.parseDouble(data[2]);
                double[] dimensions = { Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]) };
                parcelMap.addParcel(new Parcel(id, daysInDepot, weight, dimensions));
            }
        } catch (IOException e) {
            System.err.println("Error loading parcels: " + e.getMessage());
        }

        // This Loads customers from the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("Custs.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String parcelId = data[1];
                queueOfCustomers.addCustomer(new Customer(name, parcelId));
            }
        } catch (IOException e) {
            System.err.println("Error loading customers: " + e.getMessage());
        }

        Worker worker = new Worker();

        // This is the GUI setup
        SwingUtilities.invokeLater(() -> {
            DepotGUI gui = new DepotGUI(parcelMap, log);
            gui.setVisible(true);

            while (!queueOfCustomers.isEmpty()) {
                Customer customer = queueOfCustomers.getNextCustomer();
                worker.processCustomer(customer, parcelMap, log);

                // This Updates the GUI
                gui.updateParcels(parcelMap.getAllParcels().toString());
                gui.updateCustomers(queueOfCustomers.getQueue().toString());
                gui.updateLog(log.getLog());
            }
        });
    }
}