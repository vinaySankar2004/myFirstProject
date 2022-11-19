package ui;

import model.SandwichComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//represents the frame to view the price of the order
public class AddDisplayPricesGUI extends JFrame implements ActionListener {

    JLabel heading = new JLabel("Total Price Breakdown:");
    JPanel headingPanel = new JPanel();
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    JButton doneButton = new JButton("Done");
    JPanel lowerPanel = new JPanel();
    JLabel mainLabel = new JLabel();
    JPanel mainPanel = new JPanel();
    private List<String> priceBreakDownList = new ArrayList<>();

    //sets the frame up
    AddDisplayPricesGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doneButton.addActionListener(this);
        setHeadingPanel();
        setMainPanel();
        setLowerPanel();
        this.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel for the frame
    private void setHeadingPanel() {
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        heading.setFont(myHeadingFont);
        headingPanel.add(heading, BorderLayout.CENTER);
        this.add(headingPanel, BorderLayout.NORTH);
    }

    //MODIFIES: this
    //EFFECTS: sets up the main panel for the frame
    private void setMainPanel() {
        joinPricesBreakdown();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JScrollPane myScroller = new JScrollPane(new JList<>(priceBreakDownList.toArray()));
        myScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(myScroller);
        mainPanel.add(mainLabel);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel for the frame
    private void setLowerPanel() {
        lowerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lowerPanel.add(doneButton);
        this.add(lowerPanel, BorderLayout.SOUTH);
    }

    //EFFECTS: returns a list of the name of component + price
    private List<String> joinPricesBreakdown() {
        for (SandwichComponent sc : Main.myApp.order.getFillings()) {
            priceBreakDownList.add("\n" + sc.getName() + " - $" + sc.getPrice());
        }
        String tax = findTax();
        priceBreakDownList.add(tax);
        String finalStatement = Main.myApp.order.toString();
        priceBreakDownList.add(finalStatement);
        return priceBreakDownList;
    }

    //EFFECTS: finds tax of the purchase
    private String findTax() {
        double price = Main.myApp.order.returnPriceWithoutTax();
        String tax = String.format("%.2f", (price * 0.07));
        return "\nTax - $" + tax;
    }


    //MODIFIES: this
    //EFFECTS: successful termination of the program// indicating the end
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doneButton) {
            System.exit(0);
        }
    }
}
