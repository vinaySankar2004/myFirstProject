package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the frame to ask additional questions about the sandwich
public class AddSaltPepperGUI extends JFrame implements ActionListener {

    JPanel infoHeadingPanel = new JPanel();
    JLabel infoHeading = new JLabel();
    ImageIcon questionMark;
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    //Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JButton nextButton6 = new JButton("Next");
    JButton backButton6 = new JButton("Back");
    JPanel nextBackPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JCheckBox saltBox = new JCheckBox();
    JCheckBox pepperBox = new JCheckBox();
    JCheckBox toastedBox = new JCheckBox();
    JRadioButton sixInchButton = new JRadioButton();
    JRadioButton twelveInchButton = new JRadioButton();

    //sets up the frame
    AddSaltPepperGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpInfoPanel1();
        setUpLastInfoPanel();
        setUpCenterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the header panel
    private void setUpInfoPanel1() {
        questionMark = new ImageIcon(new ImageIcon("questionMark.png").getImage()
                .getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        infoHeading.setIcon(questionMark);
        infoHeading.setText("More about your sandwich...");
        this.add(infoHeadingPanel, BorderLayout.NORTH);
        infoHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        infoHeadingPanel.add(infoHeading);
        infoHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel
    private void setUpLastInfoPanel() {
        nextButton6.addActionListener(this);
        backButton6.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(nextButton6, BorderLayout.EAST);
        nextBackPanel.add(backButton6, BorderLayout.WEST);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: sets up the central main panel
    private void setUpCenterPanel() {
        mainPanel.setLayout(new GridLayout(5, 2));
        this.add(mainPanel, BorderLayout.CENTER);
        setUpRow1();
        setUpRow2();
        setUpRow3();
        setUpRow4();
        setUpRow5();
        addActionListenerToButtons();
    }

    //MODIFIES: this
    //EFFECTS: adds actionListeners to each button
    private void addActionListenerToButtons() {
        saltBox.addActionListener(this);
        pepperBox.addActionListener(this);
        toastedBox.addActionListener(this);
        sixInchButton.addActionListener(this);
        twelveInchButton.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: sets up the first row
    private void setUpRow1() {
        JLabel label = new JLabel("Add Salt?");
        mainPanel.add(label);
        mainPanel.add(saltBox);
    }

    //MODIFIES: this
    //EFFECTS: sets up the second row
    private void setUpRow2() {
        JLabel label = new JLabel("Add Pepper?");
        mainPanel.add(label);
        mainPanel.add(pepperBox);
    }

    //MODIFIES: this
    //EFFECTS: sets up the third row
    private void setUpRow3() {
        JLabel label = new JLabel("Toast your sandwich?");
        mainPanel.add(label);
        mainPanel.add(toastedBox);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fourth row
    private void setUpRow4() {
        JLabel label = new JLabel("6 inch?");
        mainPanel.add(label);
        mainPanel.add(sixInchButton);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fifth row
    private void setUpRow5() {
        JLabel label = new JLabel("12 inch?");
        mainPanel.add(label);
        mainPanel.add(twelveInchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sixInchButton.isSelected()) {
            setFalseToButton(twelveInchButton);
        } else {
            twelveInchButton.setEnabled(true);
        }
        if (twelveInchButton.isSelected()) {
            setFalseToButton(sixInchButton);
        } else {
            sixInchButton.setEnabled(true);
        }
        if (e.getSource() == nextButton6) {
            if (!sixInchButton.isSelected() && !twelveInchButton.isSelected()) {
                JOptionPane.showMessageDialog(null, "You have to select a size for your sandwich!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                this.setVisible(false);
                Main.myApp.myGuiDessert.setVisible(true);
            }
        }
        if (e.getSource() == backButton6) {
            this.setVisible(false);
            Main.myApp.myGuiSauce.setVisible(true);
        }
    }

    private void setFalseToButton(JRadioButton button) {
        button.setSelected(false);
        button.setEnabled(false);
    }
}
