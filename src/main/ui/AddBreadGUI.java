package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the frame to select the bread
public class AddBreadGUI extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    JPanel panel9 = new JPanel();
    JLabel heading = new JLabel();
    JLabel englishLabel = new JLabel();
    JLabel flatLabel = new JLabel();
    JLabel glutenLabel = new JLabel();
    JLabel harvestLabel = new JLabel();
    JLabel italianLabel = new JLabel();
    JLabel ihacLabel = new JLabel();
    JLabel multiLabel = new JLabel();
    ImageIcon breadImage;
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JRadioButton englishRadio = new JRadioButton();
    JRadioButton flatRadio = new JRadioButton();
    JRadioButton glutenRadio = new JRadioButton();
    JRadioButton harvestRadio = new JRadioButton();
    JRadioButton italianRadio = new JRadioButton();
    JRadioButton ihacRadio = new JRadioButton();
    JRadioButton multiRadio = new JRadioButton();
    JButton nextButton = new JButton("Next");
    ButtonGroup group = new ButtonGroup();

    //sets the frame up
    AddBreadGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new GridLayout(9, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpPanel1();
        setUpPanel2();
        setUpPanel3();
        setUpPanel4();
        setUpPanel5();
        setUpPanel6();
        setUpPanel7();
        setUpPanel8();
        setUpPlane9();
        group.add(englishRadio);
        group.add(flatRadio);
        group.add(glutenRadio);
        group.add(harvestRadio);
        group.add(italianRadio);
        group.add(ihacRadio);
        group.add(multiRadio);
        this.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up the heading panel of the frame
    private void setUpPanel1() {
        breadImage = new ImageIcon(new ImageIcon("whitebread.jpeg").getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        heading.setIcon(breadImage);
        this.add(panel1);
        panel1.setLayout(null);
        panel1.add(heading);
        heading.setBounds(135, 6, 500, 50);
        heading.setText("Choose your bread...");
        heading.setFont(myHeadingFont);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: sets up the second panel in the frame
    private void setUpPanel2() {
        panel2.setLayout(new FlowLayout());
        englishLabel.setText(WelcomeGUI.ENGLISH.getName());
        englishLabel.setFont(myOtherFont);
        panel2.add(englishLabel);
        panel2.add(englishRadio);
        englishRadio.addActionListener(this);
        this.add(panel2);
    }

    //MODIFIES: this
    //EFFECTS: sets up the third panel in the frame
    private void setUpPanel3() {
        panel3.setLayout(new FlowLayout());
        flatLabel.setText(WelcomeGUI.FLAT.getName());
        flatLabel.setFont(myOtherFont);
        panel3.add(flatLabel);
        panel3.add(flatRadio);
        flatRadio.addActionListener(this);
        this.add(panel3);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fourth panel in the frame
    private void setUpPanel4() {
        panel4.setLayout(new FlowLayout());
        glutenLabel.setText(WelcomeGUI.GLUTEN_FREE.getName());
        glutenLabel.setFont(myOtherFont);
        panel4.add(glutenLabel);
        panel4.add(glutenRadio);
        glutenRadio.addActionListener(this);
        this.add(panel4);
    }

    //MODIFIES: this
    //EFFECTS: sets up the fifth panel in the frame
    private void setUpPanel5() {
        panel5.setLayout(new FlowLayout());
        harvestLabel.setText(WelcomeGUI.HARVEST_GRAIN.getName());
        harvestLabel.setFont(myOtherFont);
        panel5.add(harvestLabel);
        panel5.add(harvestRadio);
        harvestRadio.addActionListener(this);
        this.add(panel5);
    }

    //MODIFIES: this
    //EFFECTS: sets up the sixth panel in the frame
    private void setUpPanel6() {
        panel6.setLayout(new FlowLayout());
        italianLabel.setText(WelcomeGUI.ITALIAN.getName());
        italianLabel.setFont(myOtherFont);
        panel6.add(italianLabel);
        panel6.add(italianRadio);
        italianRadio.addActionListener(this);
        this.add(panel6);
    }

    //MODIFIES: this
    //EFFECTS: sets up the seventh panel in the frame
    private void setUpPanel7() {
        panel7.setLayout(new FlowLayout());
        ihacLabel.setText(WelcomeGUI.ITALIAN_HERBS_AND_CHEESE.getName());
        ihacLabel.setFont(myOtherFont);
        panel7.add(ihacLabel);
        panel7.add(ihacRadio);
        ihacRadio.addActionListener(this);
        this.add(panel7);
    }

    //MODIFIES: this
    //EFFECTS: sets up the eighth panel in the frame
    private void setUpPanel8() {
        panel8.setLayout(new FlowLayout());
        multiLabel.setText(WelcomeGUI.MULTIGRAIN.getName());
        multiLabel.setFont(myOtherFont);
        panel8.add(multiLabel);
        panel8.add(multiRadio);
        multiRadio.addActionListener(this);
        this.add(panel8);
    }

    //MODIFIES: this
    //EFFECTS: sets up the ninth panel in the frame
    private void setUpPlane9() {
        panel9.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel9.add(nextButton);
        nextButton.addActionListener(this);
        this.add(panel9);
    }


    //EFFECTS: moves to next tab if next button is hit,
    // moves to back tab if back button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (!englishRadio.isSelected() && !flatRadio.isSelected() && !glutenRadio.isSelected()
                    && !harvestRadio.isSelected() && !italianRadio.isSelected() && !ihacRadio.isSelected()
                    && !multiRadio.isSelected()) {
                JOptionPane.showMessageDialog(null, "You have to select a bread!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                this.setVisible(false);
                Main.myApp.myGuiProtein.setVisible(true);
            }
        }
    }
}

