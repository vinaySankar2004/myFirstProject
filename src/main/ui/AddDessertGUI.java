package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the frame to select the dessert
public class AddDessertGUI extends JFrame implements ActionListener {

    ImageIcon dessertImage;
    JLabel dessertHeading = new JLabel();
    JPanel dessertHeadingPanel = new JPanel();
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JButton backButton7 = new JButton("Back");
    JButton clearButton7 = new JButton("Clear");
    JButton nextButton7 = new JButton("Next");
    JPanel nextBackPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JRadioButton chocoChipButton1 = new JRadioButton();
    JRadioButton chocoChipButton2 = new JRadioButton();
    JRadioButton brownieButton1 = new JRadioButton();
    JRadioButton brownieButton2 = new JRadioButton();
    JRadioButton plainButton1 = new JRadioButton();
    JRadioButton plainButton2 = new JRadioButton();
    JRadioButton chocoSoftyButton1 = new JRadioButton();
    JRadioButton chocoSoftyButton2 = new JRadioButton();
    JRadioButton vanillaSoftyButton1 = new JRadioButton();
    JRadioButton vanillaSoftyButton2 = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();


    //sets the frame up
    AddDessertGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpDessertPanel1();
        setUpLastDessertPanel();
        setUpCenterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel for the frame
    private void setUpDessertPanel1() {
        dessertImage = new ImageIcon(new ImageIcon("dessert.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        dessertHeading.setIcon(dessertImage);
        dessertHeading.setText("Choose your dessert...");
        this.add(dessertHeadingPanel, BorderLayout.NORTH);
        dessertHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dessertHeadingPanel.add(dessertHeading);
        dessertHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel for the frame
    private void setUpLastDessertPanel() {
        nextButton7.addActionListener(this);
        backButton7.addActionListener(this);
        clearButton7.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(nextButton7, BorderLayout.EAST);
        nextBackPanel.add(backButton7, BorderLayout.WEST);
        nextBackPanel.add(clearButton7, BorderLayout.CENTER);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: sets up the main panel in the center
    private void setUpCenterPanel() {
        mainPanel.setLayout(new GridLayout(6, 3));
        this.add(mainPanel, BorderLayout.CENTER);
        fillRow1();
        fillRow2();
        fillRow3();
        fillRow4();
        fillRow5();
        fillRow6();
        addButtonsToGroups();
        addActionListenerToButtons();
    }

    //MODIFIES: this
    //EFFECTS: adds each button to its respective button group
    private void addButtonsToGroups() {
        buttonGroup1.add(chocoChipButton1);
        buttonGroup1.add(brownieButton1);
        buttonGroup1.add(plainButton1);
        buttonGroup1.add(chocoSoftyButton1);
        buttonGroup1.add(vanillaSoftyButton1);
        buttonGroup2.add(chocoChipButton2);
        buttonGroup2.add(brownieButton2);
        buttonGroup2.add(plainButton2);
        buttonGroup2.add(chocoSoftyButton2);
        buttonGroup2.add(vanillaSoftyButton2);

    }

    //MODIFIES: this
    //EFFECTS: adds the actionListener to each button
    private void addActionListenerToButtons() {
        chocoChipButton1.addActionListener(this);
        brownieButton1.addActionListener(this);
        plainButton1.addActionListener(this);
        chocoSoftyButton1.addActionListener(this);
        vanillaSoftyButton1.addActionListener(this);
        chocoChipButton2.addActionListener(this);
        brownieButton2.addActionListener(this);
        plainButton2.addActionListener(this);
        chocoSoftyButton2.addActionListener(this);
        vanillaSoftyButton2.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates and a label and adds it to the main panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: fills first row
    private void fillRow1() {
        createAndAdd("Choice:");
        createAndAdd("Desserts:");
        createAndAdd("One more?");
    }

    //MODIFIES: this
    //EFFECTS: fills second row
    private void fillRow2() {
        JLabel label = new JLabel(WelcomeGUI.CHOCO_CHIP_COOKIE.getName());
        mainPanel.add(label);
        mainPanel.add(chocoChipButton1);
        mainPanel.add(chocoChipButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills third row
    private void fillRow3() {
        JLabel label = new JLabel(WelcomeGUI.BROWNIE.getName());
        mainPanel.add(label);
        mainPanel.add(brownieButton1);
        mainPanel.add(brownieButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills fourth row
    private void fillRow4() {
        JLabel label = new JLabel(WelcomeGUI.PLAIN_COOKIE.getName());
        mainPanel.add(label);
        mainPanel.add(plainButton1);
        mainPanel.add(plainButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills fifth row
    private void fillRow5() {
        JLabel label = new JLabel(WelcomeGUI.CHOCOLATE_SOFTY.getName());
        mainPanel.add(label);
        mainPanel.add(chocoSoftyButton1);
        mainPanel.add(chocoSoftyButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills sixth row
    private void fillRow6() {
        JLabel label = new JLabel(WelcomeGUI.VANILLA_SOFTY.getName());
        mainPanel.add(label);
        mainPanel.add(vanillaSoftyButton1);
        mainPanel.add(vanillaSoftyButton2);
    }


    //MODIFIES: this
    //EFFECTS: moves to next tab if the next button is hit,
    // moves to previous tab if back button is hit
    // clears choices if clear button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton7) {
            this.setVisible(false);
            Main.myApp.myGuiMoreInfo.setVisible(true);
        }
        if (e.getSource() == nextButton7) {
            this.setVisible(false);
            Main.myApp.myGuiDrink.setVisible(true);
        }
        if (e.getSource() == clearButton7) {
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
        }
    }

}
