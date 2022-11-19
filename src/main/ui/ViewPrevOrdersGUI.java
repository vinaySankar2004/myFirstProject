package ui;

import model.MySandwich;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// represents the view previous orders frame
public class ViewPrevOrdersGUI extends JFrame implements ActionListener {

    public static final String JSON_STORE = "./data/mySandwiches.json";
    List<MySandwich> mySandwiches = new ArrayList<>();
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);

    JPanel headingPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel lastPanel = new JPanel();
    JButton backButton9 = new JButton("Back");
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    JLabel heading = new JLabel("Previous Orders...");

    //sets the frame up
    ViewPrevOrdersGUI() {
        loadMySandwiches();
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backButton9.addActionListener(this);
        setUpHeadingPanel();
        setUpMainPanel();
        setUpLastPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the main panel
    private void setUpMainPanel() {
        mainPanel.setLayout(new GridLayout());
        for (int i = 0; i < mySandwiches.size(); i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < mySandwiches.get(i).getFillings().size(); j++) {
                tempList.add(mySandwiches.get(i).getFillings().get(j).getName() + " - $"
                        + mySandwiches.get(i).getFillings().get(j).getPrice());
            }
            String tempString = mySandwiches.get(i).toString();
            tempList.add(tempString);
            JScrollPane myScroller = new JScrollPane(new JList<>(tempList.toArray()));
            myScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            myScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            mainPanel.add(myScroller);
        }
        this.add(mainPanel, BorderLayout.CENTER);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel
    private void setUpHeadingPanel() {
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        heading.setFont(myHeadingFont);
        headingPanel.add(heading, BorderLayout.CENTER);
        headingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(headingPanel, BorderLayout.NORTH);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel
    private void setUpLastPanel() {
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.add(backButton9);
        this.add(lastPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: loads data from file
    private void loadMySandwiches() {
        try {
            mySandwiches = jsonReader.read();
            //System.out.println("Loaded from: " + JSON_STORE);
        } catch (IOException e) {
            //System.out.println("Unable to read file from: " + JSON_STORE);
        }
    }

    //EFFECTS: goes back to welcome page if back button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton9) {
            this.setVisible(false);
            Main.myApp.setVisible(true);
        }
    }
}
