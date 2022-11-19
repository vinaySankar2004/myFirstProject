package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents a frame to select sauces
public class AddSauceGUI extends JFrame implements ActionListener {

    JPanel sauceHeadingPanel = new JPanel();
    ImageIcon sauceImage;
    JLabel sauceHeading = new JLabel();
    JPanel nextBackPanel = new JPanel();
    JButton nextButton5 = new JButton("Next");
    JButton backButton5 = new JButton("Back");
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JPanel mainPanel = new JPanel();
    JRadioButton bbqButton1 = new JRadioButton();
    JRadioButton bbqButton2 = new JRadioButton();
    JRadioButton caesarButton1 = new JRadioButton();
    JRadioButton caesarButton2 = new JRadioButton();
    JRadioButton chipotleButton1 = new JRadioButton();
    JRadioButton chipotleButton2 = new JRadioButton();
    JRadioButton srirachaButton1 = new JRadioButton();
    JRadioButton srirachaButton2 = new JRadioButton();
    JRadioButton aioliButton1 = new JRadioButton();
    JRadioButton aioliButton2 = new JRadioButton();
    JRadioButton mayoButton1 = new JRadioButton();
    JRadioButton mayoButton2 = new JRadioButton();
    JRadioButton mustardButton1 = new JRadioButton();
    JRadioButton mustardButton2 = new JRadioButton();
    JRadioButton hotButton1 = new JRadioButton();
    JRadioButton hotButton2 = new JRadioButton();
    JRadioButton goddessButton1 = new JRadioButton();
    JRadioButton goddessButton2 = new JRadioButton();
    JRadioButton sweetOnionButton1 = new JRadioButton();
    JRadioButton sweetOnionButton2 = new JRadioButton();

    //sets up the frame
    AddSauceGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpSaucePanel1();
        setUpLastSaucePanel();
        setUpCenterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel of the frame
    private void setUpSaucePanel1() {
        sauceImage = new ImageIcon(new ImageIcon("sauces.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        sauceHeading.setIcon(sauceImage);
        sauceHeading.setText("Choose your sauces...");
        this.add(sauceHeadingPanel, BorderLayout.NORTH);
        sauceHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sauceHeadingPanel.add(sauceHeading);
        sauceHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the main central panel of the frame
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
    //EFFECTS: disables all button 2s
    private void setAllButton2ToDisabled() {
        bbqButton2.setEnabled(false);
        caesarButton2.setEnabled(false);
        chipotleButton2.setEnabled(false);
        srirachaButton2.setEnabled(false);
        aioliButton2.setEnabled(false);
        mayoButton2.setEnabled(false);
        mustardButton2.setEnabled(false);
        hotButton2.setEnabled(false);
        goddessButton2.setEnabled(false);
        sweetOnionButton2.setEnabled(false);
    }

    //MODIFIES: this
    //EFFECTS: creates a new label and adds it to main panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: adds actionListeners to all buttons
    private void addActionListenerToButtons() {
        bbqButton1.addActionListener(this);
        caesarButton1.addActionListener(this);
        chipotleButton1.addActionListener(this);
        srirachaButton1.addActionListener(this);
        aioliButton1.addActionListener(this);
        mayoButton1.addActionListener(this);
        mustardButton1.addActionListener(this);
        hotButton1.addActionListener(this);
        goddessButton1.addActionListener(this);
        sweetOnionButton1.addActionListener(this);
        bbqButton2.addActionListener(this);
        caesarButton2.addActionListener(this);
        chipotleButton2.addActionListener(this);
        srirachaButton2.addActionListener(this);
        aioliButton2.addActionListener(this);
        mayoButton2.addActionListener(this);
        mustardButton2.addActionListener(this);
        hotButton2.addActionListener(this);
        goddessButton2.addActionListener(this);
        sweetOnionButton2.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: fills the first row of the main panel
    private void fillRow1() {
        createAndAdd("Choice:");
        createAndAdd("Sauces:");
        createAndAdd("Extra?");
    }

    //MODIFIES: this
    //EFFECTS: fills the second row of the main panel
    private void fillRow2() {
        createAndAdd(WelcomeGUI.BBQ.getName());
        mainPanel.add(bbqButton1);
        mainPanel.add(bbqButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the third row of the main panel
    private void fillRow3() {
        createAndAdd(WelcomeGUI.CAESAR.getName());
        mainPanel.add(caesarButton1);
        mainPanel.add(caesarButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fourth row of the main panel
    private void fillRow4() {
        createAndAdd(WelcomeGUI.CHIPOTLE_SOUTHWEST.getName());
        mainPanel.add(chipotleButton1);
        mainPanel.add(chipotleButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fifth row of the main panel
    private void fillRow5() {
        createAndAdd(WelcomeGUI.CREAMY_SRIRACHA.getName());
        mainPanel.add(srirachaButton1);
        mainPanel.add(srirachaButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the sixth row of the main panel
    private void fillRow6() {
        createAndAdd(WelcomeGUI.GARLIC_AIOLI.getName());
        mainPanel.add(aioliButton1);
        mainPanel.add(aioliButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the seventh row of the main panel
    private void fillRow7() {
        createAndAdd(WelcomeGUI.MAYONNAISE.getName());
        mainPanel.add(mayoButton1);
        mainPanel.add(mayoButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the eighth row of the main panel
    private void fillRow8() {
        createAndAdd(WelcomeGUI.MUSTARD.getName());
        mainPanel.add(mustardButton1);
        mainPanel.add(mustardButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the ninth row of the main panel
    private void fillRow9() {
        createAndAdd(WelcomeGUI.HOT.getName());
        mainPanel.add(hotButton1);
        mainPanel.add(hotButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the tenth row of the main panel
    private void fillRow10() {
        createAndAdd(WelcomeGUI.GREEN_GODDESS.getName());
        mainPanel.add(goddessButton1);
        mainPanel.add(goddessButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the eleventh row of the main panel
    private void fillRow11() {
        createAndAdd(WelcomeGUI.SWEET_ONION_SAUCE.getName());
        mainPanel.add(sweetOnionButton1);
        mainPanel.add(sweetOnionButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel of the frame
    private void setUpLastSaucePanel() {
        nextButton5.addActionListener(this);
        backButton5.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(nextButton5, BorderLayout.EAST);
        nextBackPanel.add(backButton5, BorderLayout.WEST);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS:saves and orders sandwich order if the order button is hit,
    // moves to previous tab if back button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        setBbqFunctionality();
        setCaesarFunctionality();
        setChipotleFunctionality();
        setSrirachaFunctionality();
        setAioliFunctionality();
        setMayoFunctionality();
        setMustardFunctionality();
        setHotFunctionality();
        setGoddessFunctionality();
        setSweetOnionFunctionality();
        if (e.getSource() == nextButton5) {
            this.setVisible(false);
            Main.myApp.myGuiMoreInfo.setVisible(true);
        } else if (e.getSource() == backButton5) {
            this.setVisible(false);
            Main.myApp.myGuiVegetable.setVisible(true);
        }
    }

    //MODIFIES: this
    //CONDITIONAL CHOICES TO DECIDE WHICH BUTTON TO BE ENABLED AND WHICH TO BE DISABLED
    public void setBbqFunctionality() {
        if (bbqButton1.isSelected()) {
            bbqButton2.setEnabled(true);
        } else {
            bbqButton2.setSelected(false);
            bbqButton2.setEnabled(false);
        }
    }

    public void setCaesarFunctionality() {
        if (caesarButton1.isSelected()) {
            caesarButton2.setEnabled(true);
        } else {
            caesarButton2.setSelected(false);
            caesarButton2.setEnabled(false);
        }
    }

    public void setChipotleFunctionality() {
        if (chipotleButton1.isSelected()) {
            chipotleButton2.setEnabled(true);
        } else {
            chipotleButton2.setSelected(false);
            chipotleButton2.setEnabled(false);
        }
    }

    public void setSrirachaFunctionality() {
        if (srirachaButton1.isSelected()) {
            srirachaButton2.setEnabled(true);
        } else {
            srirachaButton2.setSelected(false);
            srirachaButton2.setEnabled(false);
        }
    }

    public void setAioliFunctionality() {
        if (aioliButton1.isSelected()) {
            aioliButton2.setEnabled(true);
        } else {
            aioliButton2.setSelected(false);
            aioliButton2.setEnabled(false);
        }
    }

    public void setMayoFunctionality() {
        if (mayoButton1.isSelected()) {
            mayoButton2.setEnabled(true);
        } else {
            mayoButton2.setSelected(false);
            mayoButton2.setEnabled(false);
        }
    }

    public void setMustardFunctionality() {
        if (mustardButton1.isSelected()) {
            mustardButton2.setEnabled(true);
        } else {
            mustardButton2.setSelected(false);
            mustardButton2.setEnabled(false);
        }
    }

    public void setHotFunctionality() {
        if (hotButton1.isSelected()) {
            hotButton2.setEnabled(true);
        } else {
            hotButton2.setSelected(false);
            hotButton2.setEnabled(false);
        }
    }

    public void setGoddessFunctionality() {
        if (goddessButton1.isSelected()) {
            goddessButton2.setEnabled(true);
        } else {
            goddessButton2.setSelected(false);
            goddessButton2.setEnabled(false);
        }
    }

    public void setSweetOnionFunctionality() {
        if (sweetOnionButton1.isSelected()) {
            sweetOnionButton2.setEnabled(true);
        } else {
            sweetOnionButton2.setSelected(false);
            sweetOnionButton2.setEnabled(false);
        }
    }
    //------------till here------------------------------
}
