package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The GUI class is for the depot system.
public class DepotGUI extends JFrame {
    private JTextArea parcelArea;
    private JTextArea customerArea;
    private JTextArea logArea;
    private JTextField searchField;
    private JButton searchButton;
    private JButton saveLogButton;
    private ParcelMap parcelMap;
    private Log log;

    public DepotGUI(ParcelMap parcelMap, Log log) {
        this.parcelMap = parcelMap;
        this.log = log;

        setTitle("Depot System");
        setSize(800, 600);
        setLayout(new BorderLayout());

        parcelArea = new JTextArea();
        customerArea = new JTextArea();
        logArea = new JTextArea();

        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        centerPanel.add(new JScrollPane(parcelArea));
        centerPanel.add(new JScrollPane(customerArea));
        centerPanel.add(new JScrollPane(logArea));

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Search Parcel");
        saveLogButton = new JButton("Save Log");

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(saveLogButton);

        add(centerPanel, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parcelId = searchField.getText();
                Parcel parcel = parcelMap.getParcel(parcelId);
                if (parcel != null) {
                    JOptionPane.showMessageDialog(null, "Parcel Found:\n" +
                            "ID: " + parcel.getId() + "\n" +
                            "Days in Depot: " + parcel.getDaysInDepot() + "\n" +
                            "Weight: " + parcel.getWeight() + "\n" +
                            "Dimensions: " + parcel.getDimensions()[0] + " x " + parcel.getDimensions()[1] + " x " + parcel.getDimensions()[2] + "\n" +
                            "Fee: " + parcel.calculateFee());
                } else {
                    JOptionPane.showMessageDialog(null, "Parcel not found.");
                }
            }
        });

        saveLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.saveLogToFile("C:\\Users\\Spin 3\\log.txt");
                JOptionPane.showMessageDialog(null, "Log saved to log.txt");
            }
        });
    }

    public void updateParcels(String parcels) {
        parcelArea.setText(parcels);
    }

    public void updateCustomers(String customers) {
        customerArea.setText(customers);
    }

    public void updateLog(String logText) {
        logArea.setText(logText);
    }
}