package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the frame to select the bread
public class AddCheeseGUI extends JFrame implements ActionListener {

    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JPanel mainCheesePanel = new JPanel();
    JPanel cheeseFooterPanel = new JPanel();
    JPanel cheeseHeadingPanel = new JPanel();
    JLabel cheeseHeading = new JLabel();
    ImageIcon cheeseImage;
    JButton backButton3 = new JButton("Back");
    JButton nextButton3 = new JButton("Next");
    JButton clearButton3 = new JButton("Clear");
    JRadioButton cheddarButton1 = new JRadioButton();
    JRadioButton cheddarButton2 = new JRadioButton();
    JRadioButton parmesanButton1 = new JRadioButton();
    JRadioButton parmesanButton2 = new JRadioButton();
    JRadioButton fetaButton1 = new JRadioButton();
    JRadioButton fetaButton2 = new JRadioButton();
    JRadioButton jackButton1 = new JRadioButton();
    JRadioButton jackButton2 = new JRadioButton();
    JRadioButton swissButton1 = new JRadioButton();
    JRadioButton swissButton2 = new JRadioButton();
    ButtonGroup cheeseGroup1 = new ButtonGroup();
    ButtonGroup cheeseGroup2 = new ButtonGroup();

    //sets the frame up
    AddCheeseGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpCheeseHeadingPanel();
        setUpMainCheesePanel();
        setUpCheeseFooterPanel();
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: creates label and adds it to panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainCheesePanel.add(label);
        mainCheesePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    //MODIFIES: this
    //EFFECTS: sets up the middle panel
    private void setUpMainCheesePanel() {
        mainCheesePanel.setLayout(new GridLayout(6, 3));
        this.add(mainCheesePanel, BorderLayout.CENTER);
        setCheeseRow1();
        setCheeseRow2();
        setCheeseRow3();
        setCheeseRow4();
        setCheeseRow5();
        setCheeseRow6();
        addRadios1ToBG1();
        addRadios2ToBG2();
    }

    //MODIFIES: this
    //EFFECTS: adds the radio 1s to buttons group 1
    private void addRadios1ToBG1() {
        cheeseGroup1.add(cheddarButton1);
        cheeseGroup1.add(parmesanButton1);
        cheeseGroup1.add(fetaButton1);
        cheeseGroup1.add(jackButton1);
        cheeseGroup1.add(swissButton1);
    }

    //MODIFIES: this
    //EFFECTS: adds radio 2s to button group 2
    private void addRadios2ToBG2() {
        cheeseGroup2.add(cheddarButton2);
        cheeseGroup2.add(parmesanButton2);
        cheeseGroup2.add(fetaButton2);
        cheeseGroup2.add(jackButton2);
        cheeseGroup2.add(swissButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets the first row in the middle panel
    private void setCheeseRow1() {
        createAndAdd("Choice:");
        createAndAdd("Cheese 1 (Optional):");
        createAndAdd("Cheese 2 (Optional):");
    }

    //MODIFIES: this
    //EFFECTS: sets the second row in the middle panel
    private void setCheeseRow2() {
        createAndAdd(WelcomeGUI.CHEDDAR.getName());
        mainCheesePanel.add(cheddarButton1);
        mainCheesePanel.add(cheddarButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets the third row in the middle panel
    private void setCheeseRow3() {
        createAndAdd(WelcomeGUI.PARMESAN.getName());
        mainCheesePanel.add(parmesanButton1);
        mainCheesePanel.add(parmesanButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets the fourth row in the middle panel
    private void setCheeseRow4() {
        createAndAdd(WelcomeGUI.FETA.getName());
        mainCheesePanel.add(fetaButton1);
        mainCheesePanel.add(fetaButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets the fifth row in the middle panel
    private void setCheeseRow5() {
        createAndAdd(WelcomeGUI.MONTEREY_JACK.getName());
        mainCheesePanel.add(jackButton1);
        mainCheesePanel.add(jackButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets the sixth row in the middle panel
    private void setCheeseRow6() {
        createAndAdd(WelcomeGUI.SWISS.getName());
        mainCheesePanel.add(swissButton1);
        mainCheesePanel.add(swissButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the heading panel of the frame
    private void setUpCheeseHeadingPanel() {
        cheeseImage = new ImageIcon(new ImageIcon("cheese.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        cheeseHeading.setIcon(cheeseImage);
        cheeseHeading.setText("Choose your cheese...");
        this.add(cheeseHeadingPanel, BorderLayout.NORTH);
        cheeseHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cheeseHeadingPanel.add(cheeseHeading);
        cheeseHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel of the frame
    private void setUpCheeseFooterPanel() {
        nextButton3.addActionListener(this);
        backButton3.addActionListener(this);
        clearButton3.addActionListener(this);
        cheeseFooterPanel.setLayout(new BorderLayout());
        cheeseFooterPanel.add(nextButton3, BorderLayout.EAST);
        cheeseFooterPanel.add(backButton3, BorderLayout.WEST);
        cheeseFooterPanel.add(clearButton3, BorderLayout.CENTER);
        this.add(cheeseFooterPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: moves to next tab if the next button is hit,
    // moves to previous tab if back button is hit
    // clears choices if clear button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton3) {
            cheeseGroup1.clearSelection();
            cheeseGroup2.clearSelection();
        }
        if (e.getSource() == nextButton3) {
            Main.myApp.myGuiVegetable.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == backButton3) {
            this.setVisible(false);
            Main.myApp.myGuiProtein.setVisible(true);
        }
    }
}

