package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents a frame to select the vegetables
public class AddVegetableGUI extends JFrame implements ActionListener {

    JPanel vegetableHeadingPanel = new JPanel();
    ImageIcon vegetableImage;
    JLabel vegetableHeading = new JLabel();
    JPanel nextBackPanel = new JPanel();
    JButton nextButton4 = new JButton("Next");
    JButton backButton4 = new JButton("Back");
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JPanel mainPanel = new JPanel();
    JRadioButton tomatoButton1 = new JRadioButton();
    JRadioButton tomatoButton2 = new JRadioButton();
    JRadioButton onionButton1 = new JRadioButton();
    JRadioButton onionButton2 = new JRadioButton();
    JRadioButton lettuceButton1 = new JRadioButton();
    JRadioButton lettuceButton2 = new JRadioButton();
    JRadioButton spinachButton1 = new JRadioButton();
    JRadioButton spinachButton2 = new JRadioButton();
    JRadioButton cucumberButton1 = new JRadioButton();
    JRadioButton cucumberButton2 = new JRadioButton();
    JRadioButton oliveButton1 = new JRadioButton();
    JRadioButton oliveButton2 = new JRadioButton();
    JRadioButton guacButton1 = new JRadioButton();
    JRadioButton guacButton2 = new JRadioButton();
    JRadioButton pickleButton1 = new JRadioButton();
    JRadioButton pickleButton2 = new JRadioButton();
    JRadioButton pepperButton1 = new JRadioButton();
    JRadioButton pepperButton2 = new JRadioButton();
    JRadioButton jalapenoButton1 = new JRadioButton();
    JRadioButton jalapenoButton2 = new JRadioButton();

    //EFFECTS: sets the frame up
    AddVegetableGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpVegetablePanel1();
        setUpLastVegetablePanel();
        setUpCenterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets the header panel for the frame
    private void setUpVegetablePanel1() {
        vegetableImage = new ImageIcon(new ImageIcon("vegetables.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        vegetableHeading.setIcon(vegetableImage);
        vegetableHeading.setText("Choose your vegetables...");
        this.add(vegetableHeadingPanel, BorderLayout.NORTH);
        vegetableHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vegetableHeadingPanel.add(vegetableHeading);
        vegetableHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets the main central panel up
    private void setUpCenterPanel() {
        mainPanel.setLayout(new GridLayout(11, 3));

        this.add(mainPanel, BorderLayout.CENTER);
        fillRow1();
        fillRow2();
        fillRow3();
        fillRow4();
        fillRow5();
        fillRow6();
        fillRow7();
        fillRow8();
        fillRow9();
        fillRow10();
        fillRow11();
        setAllButton2ToDisabled();
        addActionListenerToButtons();
    }

    //MODIFIES: this
    //EFFECTS: disables all the button 2s
    private void setAllButton2ToDisabled() {
        tomatoButton2.setEnabled(false);
        onionButton2.setEnabled(false);
        lettuceButton2.setEnabled(false);
        spinachButton2.setEnabled(false);
        cucumberButton2.setEnabled(false);
        oliveButton2.setEnabled(false);
        guacButton2.setEnabled(false);
        pickleButton2.setEnabled(false);
        pepperButton2.setEnabled(false);
        jalapenoButton2.setEnabled(false);
    }

    //MODIFIES: this
    //EFFECTS: creates a new label and adds it to the main panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: adds actionListeners to all the buttons
    private void addActionListenerToButtons() {
        tomatoButton1.addActionListener(this);
        onionButton1.addActionListener(this);
        lettuceButton1.addActionListener(this);
        spinachButton1.addActionListener(this);
        cucumberButton1.addActionListener(this);
        oliveButton1.addActionListener(this);
        guacButton1.addActionListener(this);
        pickleButton1.addActionListener(this);
        pepperButton1.addActionListener(this);
        jalapenoButton1.addActionListener(this);
        tomatoButton2.addActionListener(this);
        onionButton2.addActionListener(this);
        lettuceButton2.addActionListener(this);
        spinachButton2.addActionListener(this);
        cucumberButton2.addActionListener(this);
        oliveButton2.addActionListener(this);
        guacButton2.addActionListener(this);
        pickleButton2.addActionListener(this);
        pepperButton2.addActionListener(this);
        jalapenoButton2.addActionListener(this);
    }


    //MODIFIES: this
    //EFFECTS: fills the first row of the main panel
    private void fillRow1() {
        createAndAdd("Choice:");
        createAndAdd("Vegetables:");
        createAndAdd("Extra?");
    }

    //MODIFIES: this
    //EFFECTS: fills the second row of the main panel
    private void fillRow2() {
        createAndAdd(WelcomeGUI.TOMATO.getName());
        mainPanel.add(tomatoButton1);
        mainPanel.add(tomatoButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the third row of the main panel
    private void fillRow3() {
        createAndAdd(WelcomeGUI.ONION.getName());
        mainPanel.add(onionButton1);
        mainPanel.add(onionButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fourth row of the main panel
    private void fillRow4() {
        createAndAdd(WelcomeGUI.LETTUCE.getName());
        mainPanel.add(lettuceButton1);
        mainPanel.add(lettuceButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fifth row of the main panel
    private void fillRow5() {
        createAndAdd(WelcomeGUI.SPINACH.getName());
        mainPanel.add(spinachButton1);
        mainPanel.add(spinachButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the sixth row of the main panel
    private void fillRow6() {
        createAndAdd(WelcomeGUI.CUCUMBER.getName());
        mainPanel.add(cucumberButton1);
        mainPanel.add(cucumberButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the seventh row of the main panel
    private void fillRow7() {
        createAndAdd(WelcomeGUI.OLIVE.getName());
        mainPanel.add(oliveButton1);
        mainPanel.add(oliveButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the eighth row of the main panel
    private void fillRow8() {
        createAndAdd(WelcomeGUI.GUACAMOLE.getName());
        mainPanel.add(guacButton1);
        mainPanel.add(guacButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the ninth row of the main panel
    private void fillRow9() {
        createAndAdd(WelcomeGUI.PICKLE.getName());
        mainPanel.add(pickleButton1);
        mainPanel.add(pickleButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the tenth row of the main panel
    private void fillRow10() {
        createAndAdd(WelcomeGUI.BANANA_PEPPER.getName());
        mainPanel.add(pepperButton1);
        mainPanel.add(pepperButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the eleventh row of the main panel
    private void fillRow11() {
        createAndAdd(WelcomeGUI.JALAPENO.getName());
        mainPanel.add(jalapenoButton1);
        mainPanel.add(jalapenoButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel for the frame
    private void setUpLastVegetablePanel() {
        nextButton4.addActionListener(this);
        backButton4.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(nextButton4, BorderLayout.EAST);
        nextBackPanel.add(backButton4, BorderLayout.WEST);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS:moves to next tab if the next button is hit,
    // moves to previous tab if back button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        setTomatoFunctionality();
        setOnionFunctionality();
        setLettuceFunctionality();
        setSpinachFunctionality();
        setCucumberFunctionality();
        setOliveFunctionality();
        setGuacamoleFunctionality();
        setPickleFunctionality();
        setPepperFunctionality();
        setJalapenoFunctionality();
        if (e.getSource() == nextButton4) {
            this.setVisible(false);
            Main.myApp.myGuiSauce.setVisible(true);
        } else if (e.getSource() == backButton4) {
            this.setVisible(false);
            Main.myApp.myGuiCheese.setVisible(true);
        }
    }

    //MODIFIES: this
    //CONDITIONAL CHOICES TO DECIDE WHICH BUTTON TO BE ENABLED AND WHICH TO BE DISABLED
    public void setTomatoFunctionality() {
        if (tomatoButton1.isSelected()) {
            tomatoButton2.setEnabled(true);
        } else {
            tomatoButton2.setSelected(false);
            tomatoButton2.setEnabled(false);
        }
    }

    public void setOnionFunctionality() {
        if (onionButton1.isSelected()) {
            onionButton2.setEnabled(true);
        } else {
            onionButton2.setSelected(false);
            onionButton2.setEnabled(false);
        }
    }

    public void setLettuceFunctionality() {
        if (lettuceButton1.isSelected()) {
            lettuceButton2.setEnabled(true);
        } else {
            lettuceButton2.setSelected(false);
            lettuceButton2.setEnabled(false);
        }
    }

    public void setSpinachFunctionality() {
        if (spinachButton1.isSelected()) {
            spinachButton2.setEnabled(true);
        } else {
            spinachButton2.setSelected(false);
            spinachButton2.setEnabled(false);
        }
    }

    public void setCucumberFunctionality() {
        if (cucumberButton1.isSelected()) {
            cucumberButton2.setEnabled(true);
        } else {
            cucumberButton2.setSelected(false);
            cucumberButton2.setEnabled(false);
        }
    }

    public void setOliveFunctionality() {
        if (oliveButton1.isSelected()) {
            oliveButton2.setEnabled(true);
        } else {
            oliveButton2.setSelected(false);
            oliveButton2.setEnabled(false);
        }
    }

    public void setGuacamoleFunctionality() {
        if (guacButton1.isSelected()) {
            guacButton2.setEnabled(true);
        } else {
            guacButton2.setSelected(false);
            guacButton2.setEnabled(false);
        }
    }

    public void setPickleFunctionality() {
        if (pickleButton1.isSelected()) {
            pickleButton2.setEnabled(true);
        } else {
            pickleButton2.setSelected(false);
            pickleButton2.setEnabled(false);
        }
    }

    public void setPepperFunctionality() {
        if (pepperButton1.isSelected()) {
            pepperButton2.setEnabled(true);
        } else {
            pepperButton2.setSelected(false);
            pepperButton2.setEnabled(false);
        }
    }

    public void setJalapenoFunctionality() {
        if (jalapenoButton1.isSelected()) {
            jalapenoButton2.setEnabled(true);
        } else {
            jalapenoButton2.setSelected(false);
            jalapenoButton2.setEnabled(false);
        }
    }
    //----- till here -------------------------------
}
