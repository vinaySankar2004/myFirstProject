package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents frame to select the proteins
public class AddProteinGUI extends JFrame implements ActionListener {

    JPanel proteinHeadingPanel = new JPanel();
    ImageIcon proteinImage;
    JLabel proteinHeading = new JLabel();
    JPanel nextBackPanel = new JPanel();
    JButton nextButton2 = new JButton("Next");
    JButton backButton = new JButton("Back");
    JButton clearButton = new JButton("Clear");
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JPanel mainPanel = new JPanel();
    JRadioButton baconButton1 = new JRadioButton();
    JRadioButton baconButton2 = new JRadioButton();
    JRadioButton grilledButton1 = new JRadioButton();
    JRadioButton grilledButton2 = new JRadioButton();
    JRadioButton crispyButton1 = new JRadioButton();
    JRadioButton crispyButton2 = new JRadioButton();
    JRadioButton hamButton1 = new JRadioButton();
    JRadioButton hamButton2 = new JRadioButton();
    JRadioButton bmtButton1 = new JRadioButton();
    JRadioButton bmtButton2 = new JRadioButton();
    JRadioButton marinaraButton1 = new JRadioButton();
    JRadioButton marinaraButton2 = new JRadioButton();
    JRadioButton pepperoniButton1 = new JRadioButton();
    JRadioButton pepperoniButton2 = new JRadioButton();
    JRadioButton beefButton1 = new JRadioButton();
    JRadioButton beefButton2 = new JRadioButton();
    JRadioButton tunaButton1 = new JRadioButton();
    JRadioButton tunaButton2 = new JRadioButton();
    JRadioButton veggieButton1 = new JRadioButton();
    JRadioButton veggieButton2 = new JRadioButton();
    ButtonGroup proteinButtonGroup1 = new ButtonGroup();
    ButtonGroup proteinButtonGroup2 = new ButtonGroup();

    //sets up the frame
    AddProteinGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpProteinPanel1();
        setUpLastProteinPanel();
        setUpCenterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel
    private void setUpProteinPanel1() {
        proteinImage = new ImageIcon(new ImageIcon("protein.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        proteinHeading.setIcon(proteinImage);
        proteinHeading.setText("Choose your protein...");
        this.add(proteinHeadingPanel, BorderLayout.NORTH);
        proteinHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        proteinHeadingPanel.add(proteinHeading);
        proteinHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the central main panel of the frame
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
        addButtonGroups();
        addActionListenerToButtons();
    }

    //MODIFIES: this
    //EFFECTS: creates new label and adds it to the main panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: adds each button to its respective button group
    private void addButtonGroups() {
        proteinButtonGroup1.add(baconButton1);
        proteinButtonGroup1.add(grilledButton1);
        proteinButtonGroup1.add(crispyButton1);
        proteinButtonGroup1.add(hamButton1);
        proteinButtonGroup1.add(bmtButton1);
        proteinButtonGroup1.add(marinaraButton1);
        proteinButtonGroup1.add(pepperoniButton1);
        proteinButtonGroup1.add(beefButton1);
        proteinButtonGroup1.add(tunaButton1);
        proteinButtonGroup1.add(veggieButton1);
        proteinButtonGroup2.add(baconButton2);
        proteinButtonGroup2.add(grilledButton2);
        proteinButtonGroup2.add(crispyButton2);
        proteinButtonGroup2.add(hamButton2);
        proteinButtonGroup2.add(bmtButton2);
        proteinButtonGroup2.add(marinaraButton2);
        proteinButtonGroup2.add(pepperoniButton2);
        proteinButtonGroup2.add(beefButton2);
        proteinButtonGroup2.add(tunaButton2);
        proteinButtonGroup2.add(veggieButton2);
    }

    //MODIFIES: this
    //EFFECTS: adds actionListeners to each button
    private void addActionListenerToButtons() {
        baconButton1.addActionListener(this);
        grilledButton1.addActionListener(this);
        crispyButton1.addActionListener(this);
        hamButton1.addActionListener(this);
        bmtButton1.addActionListener(this);
        marinaraButton1.addActionListener(this);
        pepperoniButton1.addActionListener(this);
        beefButton1.addActionListener(this);
        tunaButton1.addActionListener(this);
        veggieButton1.addActionListener(this);
        baconButton2.addActionListener(this);
        grilledButton2.addActionListener(this);
        crispyButton2.addActionListener(this);
        hamButton2.addActionListener(this);
        bmtButton2.addActionListener(this);
        marinaraButton2.addActionListener(this);
        pepperoniButton2.addActionListener(this);
        beefButton2.addActionListener(this);
        tunaButton2.addActionListener(this);
        veggieButton2.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: sets up the first row
    private void fillRow1() {
        createAndAdd("Choice:");
        createAndAdd("Protein 1:");
        createAndAdd("Protein 2 (Optional):");
    }

    //MODIFIES: this
    //EFFECTS: sets up the second row
    private void fillRow2() {
        createAndAdd(WelcomeGUI.BACON_STRIPS.getName());
        mainPanel.add(baconButton1);
        mainPanel.add(baconButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the third row
    private void fillRow3() {
        createAndAdd(WelcomeGUI.GRILLED_CHICKEN.getName());
        mainPanel.add(grilledButton1);
        mainPanel.add(grilledButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fourth row
    private void fillRow4() {
        createAndAdd(WelcomeGUI.CRISPY_CHICKEN.getName());
        mainPanel.add(crispyButton1);
        mainPanel.add(crispyButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fifth row
    private void fillRow5() {
        createAndAdd(WelcomeGUI.HAM.getName());
        mainPanel.add(hamButton1);
        mainPanel.add(hamButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the sixth row
    private void fillRow6() {
        createAndAdd(WelcomeGUI.ITALIAN_BMT.getName());
        mainPanel.add(bmtButton1);
        mainPanel.add(bmtButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the seventh row
    private void fillRow7() {
        createAndAdd(WelcomeGUI.MARINARA_MEATBALLS.getName());
        mainPanel.add(marinaraButton1);
        mainPanel.add(marinaraButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the eighth row
    private void fillRow8() {
        createAndAdd(WelcomeGUI.PEPPERONI.getName());
        mainPanel.add(pepperoniButton1);
        mainPanel.add(pepperoniButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the ninth row
    private void fillRow9() {
        createAndAdd(WelcomeGUI.ROAST_BEEF.getName());
        mainPanel.add(beefButton1);
        mainPanel.add(beefButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the tenth row
    private void fillRow10() {
        createAndAdd(WelcomeGUI.TUNA.getName());
        mainPanel.add(tunaButton1);
        mainPanel.add(tunaButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the eleventh row
    private void fillRow11() {
        createAndAdd(WelcomeGUI.VEGGIE_PATTY.getName());
        mainPanel.add(veggieButton1);
        mainPanel.add(veggieButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel of the frame
    private void setUpLastProteinPanel() {
        nextButton2.addActionListener(this);
        backButton.addActionListener(this);
        clearButton.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(nextButton2, BorderLayout.EAST);
        nextBackPanel.add(backButton, BorderLayout.WEST);
        nextBackPanel.add(clearButton, BorderLayout.CENTER);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }


    //MODIFIES: this
    //EFFECTS:saves and orders sandwich order if the order button is hit,
    // moves to previous tab if back button is hit
    // clears choices if clear button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            proteinButtonGroup1.clearSelection();
            proteinButtonGroup2.clearSelection();
        }
        if (e.getSource() == nextButton2) {
            if (!baconButton1.isSelected() && !grilledButton1.isSelected() && !crispyButton1.isSelected()
                    && !hamButton1.isSelected() && !bmtButton1.isSelected() && !marinaraButton1.isSelected()
                    && !pepperoniButton1.isSelected() && !beefButton1.isSelected() && !tunaButton1.isSelected()
                    && !veggieButton1.isSelected()) {
                JOptionPane.showMessageDialog(null, "You have to select one from Protein 1!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                this.setVisible(false);
                Main.myApp.myGuiCheese.setVisible(true);
            }
        } else if (e.getSource() == backButton) {
            this.setVisible(false);
            Main.myApp.myGuiBread.setVisible(true);
        }
    }
}