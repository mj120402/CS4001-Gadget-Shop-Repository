import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop extends JFrame {

    private ArrayList<Gadget> gadgets = new ArrayList<>();
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField,
            phoneNumberField, durationField, downloadSizeField, displayNumberField;

    public GadgetShop() {
        createGUI();
    }

    private void createGUI() {
        setTitle("Gadget Shop");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 2));

        // Model
        mainPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        mainPanel.add(modelField);

        // Price
        mainPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        mainPanel.add(priceField);

        // Weight
        mainPanel.add(new JLabel("Weight (grams): "));
        weightField = new JTextField();
        mainPanel.add(weightField);

        // Size
        mainPanel.add(new JLabel("Size: "));
        sizeField = new JTextField();
        mainPanel.add(sizeField);

        // Credit
        mainPanel.add(new JLabel("Initial Credit: "));
        creditField = new JTextField();
        mainPanel.add(creditField);

        // Memory
        mainPanel.add(new JLabel("Initial Memory (MB): "));
        memoryField = new JTextField();
        mainPanel.add(memoryField);

        // Phone Number
        mainPanel.add(new JLabel("Phone Number: "));
        phoneNumberField = new JTextField();
        mainPanel.add(phoneNumberField);        

        // Duration
        mainPanel.add(new JLabel("Duration (minutes): "));
        durationField = new JTextField();
        mainPanel.add(durationField);

        // Download Size
        mainPanel.add(new JLabel("Download Size (MB): "));
        downloadSizeField = new JTextField();
        mainPanel.add(downloadSizeField);

        // Display Number
        mainPanel.add(new JLabel("Display Number: "));
        displayNumberField = new JTextField();
        mainPanel.add(displayNumberField);

        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });
        mainPanel.add(addMobileButton);

        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });
        mainPanel.add(addMP3Button);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        mainPanel.add(clearButton);

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
        mainPanel.add(displayAllButton);

        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });
        mainPanel.add(makeCallButton);

        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });
        mainPanel.add(downloadMusicButton);

        add(mainPanel);
        setVisible(true);
    }

    private void addMobile() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);
            clearFields();
        } catch (NumberFormatException e) {
            showError("Please enter valid numerical values.");
        }
    }

    private void addMP3() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);
            clearFields();
        } catch (NumberFormatException e) {
            showError("Please enter valid numerical values.");
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    private void displayAll() {
        for (int i = 0; i < gadgets.size(); i++) {
            System.out.println("Display Number: " + i);
            gadgets.get(i).display();
            System.out.println();
        }
    }

    private void makeCall() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            String phoneNumber = phoneNumberField.getText();
            int duration = Integer.parseInt(durationField.getText());

            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Gadget gadget = gadgets.get(displayNumber);
                if (gadget instanceof Mobile) {
                    Mobile mobile = (Mobile) gadget;
                    mobile.makeCall(phoneNumber, duration);
                } else {
                    showError("Selected gadget is not a Mobile.");
                }
            } else {
                showError("Invalid display number.");
            }
        } catch (NumberFormatException e) {
            showError("Please enter valid numerical values.");
        }
    }

    private void downloadMusic() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            int downloadSize = Integer.parseInt(downloadSizeField.getText());

            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Gadget gadget = gadgets.get(displayNumber);
                if (gadget instanceof MP3) {
                    MP3 mp3 = (MP3) gadget;
                    mp3.downloadMusic(downloadSize);
                } else {
                    showError("Selected gadget is not an MP3 player.");
                }
            } else {
                showError("Invalid display number.");
            }
        } catch (NumberFormatException e) {
            showError("Please enter valid numerical values.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    
}
