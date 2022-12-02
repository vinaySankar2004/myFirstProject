package ui;

import model.SandwichComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//represents the frame to select the drink
public class AddDrinkGUI extends JFrame implements ActionListener {

    ImageIcon drinkImage;
    JLabel drinkHeading = new JLabel();
    JPanel drinkHeadingPanel = new JPanel();
    Font myHeadingFont = new Font("Lucida Grande", Font.PLAIN, 18);
    Font myOtherFont = new Font("Lucida Grande", Font.PLAIN, 15);
    JButton backButton8 = new JButton("Back");
    JButton clearButton = new JButton("Clear");
    JButton orderButton = new JButton("Order");
    JPanel nextBackPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JRadioButton waterButton1 = new JRadioButton();
    JRadioButton waterButton2 = new JRadioButton();
    JRadioButton cokeButton1 = new JRadioButton();
    JRadioButton cokeButton2 = new JRadioButton();
    JRadioButton dewButton1 = new JRadioButton();
    JRadioButton dewButton2 = new JRadioButton();
    JRadioButton rootButton1 = new JRadioButton();
    JRadioButton rootButton2 = new JRadioButton();
    JRadioButton fantaButton1 = new JRadioButton();
    JRadioButton fantaButton2 = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
    AddDisplayPricesGUI displayPrices;

    //sets up the frame
    AddDrinkGUI() {
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
        drinkImage = new ImageIcon(new ImageIcon("drink.jpeg").getImage()
                .getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        drinkHeading.setIcon(drinkImage);
        drinkHeading.setText("Choose your drink...");
        this.add(drinkHeadingPanel, BorderLayout.NORTH);
        drinkHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        drinkHeadingPanel.add(drinkHeading);
        drinkHeading.setFont(myHeadingFont);
    }

    //MODIFIES: this
    //EFFECTS: sets up the footer panel for the frame
    private void setUpLastDessertPanel() {
        orderButton.addActionListener(this);
        backButton8.addActionListener(this);
        clearButton.addActionListener(this);
        nextBackPanel.setLayout(new BorderLayout());
        nextBackPanel.add(orderButton, BorderLayout.EAST);
        nextBackPanel.add(backButton8, BorderLayout.WEST);
        nextBackPanel.add(clearButton, BorderLayout.CENTER);
        this.add(nextBackPanel, BorderLayout.SOUTH);
    }

    //MODIFIES: this
    //EFFECTS: sets up the main central panel
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
    //EFFECTS: adds each button to their respective button groups
    private void addButtonsToGroups() {
        buttonGroup1.add(waterButton1);
        buttonGroup1.add(cokeButton1);
        buttonGroup1.add(dewButton1);
        buttonGroup1.add(rootButton1);
        buttonGroup1.add(fantaButton1);
        buttonGroup2.add(waterButton2);
        buttonGroup2.add(cokeButton2);
        buttonGroup2.add(dewButton2);
        buttonGroup2.add(rootButton2);
        buttonGroup2.add(fantaButton2);

    }

    //MODIFIES: this
    //EFFECTS: adds actionListeners to each button
    private void addActionListenerToButtons() {
        waterButton1.addActionListener(this);
        cokeButton1.addActionListener(this);
        dewButton1.addActionListener(this);
        rootButton1.addActionListener(this);
        fantaButton1.addActionListener(this);
        waterButton2.addActionListener(this);
        cokeButton2.addActionListener(this);
        dewButton2.addActionListener(this);
        rootButton2.addActionListener(this);
        fantaButton2.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates a new label and adds it to the central panel
    private void createAndAdd(String s) {
        JLabel label = new JLabel(s);
        label.setFont(myOtherFont);
        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //MODIFIES: this
    //EFFECTS: fills the first row in the main panel
    private void fillRow1() {
        createAndAdd("Choice:");
        createAndAdd("Drinks:");
        createAndAdd("One more?");
    }

    //MODIFIES: this
    //EFFECTS: fills the second row in the main panel
    private void fillRow2() {
        JLabel label = new JLabel(WelcomeGUI.WATER.getName());
        mainPanel.add(label);
        mainPanel.add(waterButton1);
        mainPanel.add(waterButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the third row in the main panel
    private void fillRow3() {
        JLabel label = new JLabel(WelcomeGUI.COCA_COLA.getName());
        mainPanel.add(label);
        mainPanel.add(cokeButton1);
        mainPanel.add(cokeButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fourth row in the main panel
    private void fillRow4() {
        JLabel label = new JLabel(WelcomeGUI.MOUNTAIN_DEW.getName());
        mainPanel.add(label);
        mainPanel.add(dewButton1);
        mainPanel.add(dewButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the fifth row in the main panel
    private void fillRow5() {
        JLabel label = new JLabel(WelcomeGUI.ROOT_BEER.getName());
        mainPanel.add(label);
        mainPanel.add(rootButton1);
        mainPanel.add(rootButton2);
    }

    //MODIFIES: this
    //EFFECTS: fills the sixth row in the main panel
    private void fillRow6() {
        JLabel label = new JLabel(WelcomeGUI.FANTA.getName());
        mainPanel.add(label);
        mainPanel.add(fantaButton1);
        mainPanel.add(fantaButton2);
    }

    //MODIFIES: this
    //EFFECTS:saves and orders sandwich order if the order button is hit,
    // moves to previous tab if back button is hit
    // clears choices if clear button is hit
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
        }
        if (e.getSource() == backButton8) {
            this.setVisible(false);
            Main.myApp.myGuiDessert.setVisible(true);
        }
        if (e.getSource() == orderButton) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to save and submit your order?",
                    "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                addEverythingToSystem();
                Main.myApp.myGuiPrevOrders.mySandwiches.add(Main.myApp.order);
                saveMySandwiches();
                displayPrices = new AddDisplayPricesGUI();
            }
        }
    }

    //EFFECTS: adds everything to a list of ordered components
    public void addEverythingToSystem() {
        addBreadToOrder();
        addProteinsToOrder();
        addCheeseToOrder();
        addVegetablesToOrder();
        addSauceToOrder();
        addInfoToOrder();
        addDessertToOrder();
        addDrinkToOrder();
    }

    //EFFECTS: adds bread to order list
    private void addBreadToOrder() {
        if (Main.myApp.myGuiBread.englishRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ENGLISH);
        } else if (Main.myApp.myGuiBread.flatRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.FLAT);
        } else if (Main.myApp.myGuiBread.glutenRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.GLUTEN_FREE);
        } else if (Main.myApp.myGuiBread.harvestRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.HARVEST_GRAIN);
        } else if (Main.myApp.myGuiBread.italianRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ITALIAN);
        } else if (Main.myApp.myGuiBread.ihacRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ITALIAN_HERBS_AND_CHEESE);
        } else if (Main.myApp.myGuiBread.multiRadio.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MULTIGRAIN);
        }
    }

    //EFFECTS: adds proteins to order list
    private void addProteinsToOrder() {
        addProtein1ToOrder();
        addProtein2ToOrder();
    }

    //EFFECTS: adds protein 1 to order list
    private void addProtein1ToOrder() {
        if (Main.myApp.myGuiProtein.baconButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.BACON_STRIPS);
        } else if (Main.myApp.myGuiProtein.grilledButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.GRILLED_CHICKEN);
        } else if (Main.myApp.myGuiProtein.crispyButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CRISPY_CHICKEN);
        } else if (Main.myApp.myGuiProtein.hamButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.HAM);
        } else if (Main.myApp.myGuiProtein.bmtButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ITALIAN_BMT);
        } else if (Main.myApp.myGuiProtein.marinaraButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MARINARA_MEATBALLS);
        } else if (Main.myApp.myGuiProtein.pepperoniButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PEPPERONI);
        } else if (Main.myApp.myGuiProtein.beefButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ROAST_BEEF);
        } else if (Main.myApp.myGuiProtein.tunaButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.TUNA);
        } else if (Main.myApp.myGuiProtein.veggieButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.VEGGIE_PATTY);
        }
    }

    //EFFECTS: adds protein 2 to order list
    private void addProtein2ToOrder() {
        if (Main.myApp.myGuiProtein.baconButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.BACON_STRIPS);
        } else if (Main.myApp.myGuiProtein.grilledButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.GRILLED_CHICKEN);
        } else if (Main.myApp.myGuiProtein.crispyButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CRISPY_CHICKEN);
        } else if (Main.myApp.myGuiProtein.hamButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.HAM);
        } else if (Main.myApp.myGuiProtein.bmtButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ITALIAN_BMT);
        } else if (Main.myApp.myGuiProtein.marinaraButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MARINARA_MEATBALLS);
        } else if (Main.myApp.myGuiProtein.pepperoniButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PEPPERONI);
        } else if (Main.myApp.myGuiProtein.beefButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ROAST_BEEF);
        } else if (Main.myApp.myGuiProtein.tunaButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.TUNA);
        } else if (Main.myApp.myGuiProtein.veggieButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.VEGGIE_PATTY);
        }
    }

    //EFFECTS: adds cheese to order list
    private void addCheeseToOrder() {
        addCheese1ToOrder();
        addCheese2ToOrder();
    }

    //EFFECTS: adds cheese 1 to order list
    private void addCheese1ToOrder() {
        if (Main.myApp.myGuiCheese.cheddarButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHEDDAR);
        } else if (Main.myApp.myGuiCheese.parmesanButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PARMESAN);
        } else if (Main.myApp.myGuiCheese.fetaButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.FETA);
        } else if (Main.myApp.myGuiCheese.jackButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MONTEREY_JACK);
        } else if (Main.myApp.myGuiCheese.swissButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.SWISS);
        }
    }

    //EFFECTS: adds cheese 2 to order list
    private void addCheese2ToOrder() {
        if (Main.myApp.myGuiCheese.cheddarButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHEDDAR);
        } else if (Main.myApp.myGuiCheese.parmesanButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PARMESAN);
        } else if (Main.myApp.myGuiCheese.fetaButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.FETA);
        } else if (Main.myApp.myGuiCheese.jackButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MONTEREY_JACK);
        } else if (Main.myApp.myGuiCheese.swissButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.SWISS);
        }
    }

    //EFFECTS: adds vegetables to order list
    private void addVegetablesToOrder() {
        addToOrderHelper(Main.myApp.myGuiVegetable.tomatoButton1, WelcomeGUI.TOMATO);
        addToOrderHelper(Main.myApp.myGuiVegetable.tomatoButton2, WelcomeGUI.TOMATO);
        addToOrderHelper(Main.myApp.myGuiVegetable.onionButton1, WelcomeGUI.ONION);
        addToOrderHelper(Main.myApp.myGuiVegetable.onionButton2, WelcomeGUI.ONION);
        addToOrderHelper(Main.myApp.myGuiVegetable.lettuceButton1, WelcomeGUI.LETTUCE);
        addToOrderHelper(Main.myApp.myGuiVegetable.lettuceButton2, WelcomeGUI.LETTUCE);
        addToOrderHelper(Main.myApp.myGuiVegetable.spinachButton1, WelcomeGUI.SPINACH);
        addToOrderHelper(Main.myApp.myGuiVegetable.spinachButton2, WelcomeGUI.SPINACH);
        addToOrderHelper(Main.myApp.myGuiVegetable.cucumberButton1, WelcomeGUI.CUCUMBER);
        addToOrderHelper(Main.myApp.myGuiVegetable.cucumberButton2, WelcomeGUI.CUCUMBER);
        addToOrderHelper(Main.myApp.myGuiVegetable.oliveButton1, WelcomeGUI.OLIVE);
        addToOrderHelper(Main.myApp.myGuiVegetable.oliveButton2, WelcomeGUI.OLIVE);
        addToOrderHelper(Main.myApp.myGuiVegetable.guacButton1, WelcomeGUI.GUACAMOLE);
        addToOrderHelper(Main.myApp.myGuiVegetable.guacButton2, WelcomeGUI.GUACAMOLE);
        addToOrderHelper(Main.myApp.myGuiVegetable.pickleButton1, WelcomeGUI.PICKLE);
        addToOrderHelper(Main.myApp.myGuiVegetable.pickleButton2, WelcomeGUI.PICKLE);
        addToOrderHelper(Main.myApp.myGuiVegetable.pepperButton1, WelcomeGUI.BANANA_PEPPER);
        addToOrderHelper(Main.myApp.myGuiVegetable.pepperButton2, WelcomeGUI.BANANA_PEPPER);
        addToOrderHelper(Main.myApp.myGuiVegetable.jalapenoButton1, WelcomeGUI.JALAPENO);
        addToOrderHelper(Main.myApp.myGuiVegetable.jalapenoButton2, WelcomeGUI.JALAPENO);
    }

    //EFFECTS: adds component to order list
    private void addToOrderHelper(JRadioButton button, SandwichComponent sc) {
        if (button.isSelected()) {
            Main.myApp.order.addComponent(sc);
        }
    }

    //EFFECTS: adds sauces to order list
    private void addSauceToOrder() {
        addToOrderHelper(Main.myApp.myGuiSauce.bbqButton1, WelcomeGUI.BBQ);
        addToOrderHelper(Main.myApp.myGuiSauce.bbqButton2, WelcomeGUI.BBQ);
        addToOrderHelper(Main.myApp.myGuiSauce.caesarButton1, WelcomeGUI.CAESAR);
        addToOrderHelper(Main.myApp.myGuiSauce.caesarButton1, WelcomeGUI.CAESAR);
        addToOrderHelper(Main.myApp.myGuiSauce.chipotleButton1, WelcomeGUI.CHIPOTLE_SOUTHWEST);
        addToOrderHelper(Main.myApp.myGuiSauce.chipotleButton2, WelcomeGUI.CHIPOTLE_SOUTHWEST);
        addToOrderHelper(Main.myApp.myGuiSauce.srirachaButton1, WelcomeGUI.CREAMY_SRIRACHA);
        addToOrderHelper(Main.myApp.myGuiSauce.srirachaButton2, WelcomeGUI.CREAMY_SRIRACHA);
        addToOrderHelper(Main.myApp.myGuiSauce.aioliButton1, WelcomeGUI.GARLIC_AIOLI);
        addToOrderHelper(Main.myApp.myGuiSauce.aioliButton2, WelcomeGUI.GARLIC_AIOLI);
        addToOrderHelper(Main.myApp.myGuiSauce.mayoButton1, WelcomeGUI.MAYONNAISE);
        addToOrderHelper(Main.myApp.myGuiSauce.mayoButton2, WelcomeGUI.MAYONNAISE);
        addToOrderHelper(Main.myApp.myGuiSauce.mustardButton1, WelcomeGUI.MUSTARD);
        addToOrderHelper(Main.myApp.myGuiSauce.mustardButton2, WelcomeGUI.MUSTARD);
        addToOrderHelper(Main.myApp.myGuiSauce.hotButton1, WelcomeGUI.HOT);
        addToOrderHelper(Main.myApp.myGuiSauce.hotButton2, WelcomeGUI.HOT);
        addToOrderHelper(Main.myApp.myGuiSauce.goddessButton1, WelcomeGUI.GREEN_GODDESS);
        addToOrderHelper(Main.myApp.myGuiSauce.goddessButton2, WelcomeGUI.GREEN_GODDESS);
        addToOrderHelper(Main.myApp.myGuiSauce.sweetOnionButton1, WelcomeGUI.SWEET_ONION_SAUCE);
        addToOrderHelper(Main.myApp.myGuiSauce.sweetOnionButton2, WelcomeGUI.SWEET_ONION_SAUCE);
    }

    //EFFECTS: adds responses to some additional questions
    private void addInfoToOrder() {
        if (Main.myApp.myGuiMoreInfo.saltBox.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.SALT);
        }
        if (Main.myApp.myGuiMoreInfo.pepperBox.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PEPPER);
        }
        if (Main.myApp.myGuiMoreInfo.sixInchButton.isSelected()) {
            Main.myApp.order.setIsSixInch(true);
        } else if (Main.myApp.myGuiMoreInfo.twelveInchButton.isSelected()) {
            Main.myApp.order.setIsSixInch(false);
        }
    }

    //EFFECTS: adds desserts to order list
    private void addDessertToOrder() {
        addDessert1ToOrder();
        addDessert2ToOrder();
    }

    //EFFECTS: adds dessert 1 to order list
    private void addDessert1ToOrder() {
        if (Main.myApp.myGuiDessert.chocoChipButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHOCO_CHIP_COOKIE);
        } else if (Main.myApp.myGuiDessert.brownieButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.BROWNIE);
        } else if (Main.myApp.myGuiDessert.plainButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PLAIN_COOKIE);
        } else if (Main.myApp.myGuiDessert.chocoSoftyButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHOCOLATE_SOFTY);
        } else if (Main.myApp.myGuiDessert.vanillaSoftyButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.VANILLA_SOFTY);
        }
    }

    //EFFECTS: adds dessert 2 to order list
    private void addDessert2ToOrder() {
        if (Main.myApp.myGuiDessert.chocoChipButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHOCO_CHIP_COOKIE);
        } else if (Main.myApp.myGuiDessert.brownieButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.BROWNIE);
        } else if (Main.myApp.myGuiDessert.plainButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.PLAIN_COOKIE);
        } else if (Main.myApp.myGuiDessert.chocoSoftyButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.CHOCOLATE_SOFTY);
        } else if (Main.myApp.myGuiDessert.vanillaSoftyButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.VANILLA_SOFTY);
        }
    }

    //EFFECTS: adds drinks to order list
    private void addDrinkToOrder() {
        addDrink1ToOrder();
        addDrink2ToOrder();
    }

    //EFFECTS: adds drink 1 to order list
    private void addDrink1ToOrder() {
        if (Main.myApp.myGuiDrink.waterButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.WATER);
        } else if (Main.myApp.myGuiDrink.cokeButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.COCA_COLA);
        } else if (Main.myApp.myGuiDrink.dewButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MOUNTAIN_DEW);
        } else if (Main.myApp.myGuiDrink.rootButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ROOT_BEER);
        } else if (Main.myApp.myGuiDrink.fantaButton1.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.FANTA);
        }
    }

    //EFFECTS: adds drink 2 to order list
    private void addDrink2ToOrder() {
        if (Main.myApp.myGuiDrink.waterButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.WATER);
        } else if (Main.myApp.myGuiDrink.cokeButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.COCA_COLA);
        } else if (Main.myApp.myGuiDrink.dewButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.MOUNTAIN_DEW);
        } else if (Main.myApp.myGuiDrink.rootButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.ROOT_BEER);
        } else if (Main.myApp.myGuiDrink.fantaButton2.isSelected()) {
            Main.myApp.order.addComponent(WelcomeGUI.FANTA);
        }
    }

    //EFFECTS: saves the list of loans to file
    private void saveMySandwiches() {
        try {
            Main.myApp.myGuiPrevOrders.jsonWriter.open();
            Main.myApp.myGuiPrevOrders.jsonWriter.write(Main.myApp.myGuiPrevOrders.mySandwiches);
            Main.myApp.myGuiPrevOrders.jsonWriter.close();
            //System.out.println("Saved to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            //System.out.println("Unable to write file: " + JSON_STORE);
        }
    }

}
