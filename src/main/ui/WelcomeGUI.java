package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// represents the welcome frame
public class WelcomeGUI extends JFrame implements ActionListener {

    // available breads with prices
    public static final SandwichComponent ENGLISH = new Bread("English Bread", 1.00);
    public static final SandwichComponent FLAT = new Bread("Flat Bread", 1.00);
    public static final SandwichComponent GLUTEN_FREE = new Bread("Gluten-Free Bread", 1.00);
    public static final SandwichComponent HARVEST_GRAIN = new Bread("Harvest-Grain Bread", 1.00);
    public static final SandwichComponent ITALIAN = new Bread("Italian Bread", 1.00);
    public static final SandwichComponent ITALIAN_HERBS_AND_CHEESE = new Bread("Italian, Herbs and Cheese", 1.00);
    public static final SandwichComponent MULTIGRAIN = new Bread("Multigrain Bread", 1.00);

    // available proteins with prices
    public static final SandwichComponent BACON_STRIPS = new Protein("Bacon Strips", 1.00);
    public static final SandwichComponent GRILLED_CHICKEN = new Protein("Grilled Chicken", 2.00);
    public static final SandwichComponent CRISPY_CHICKEN = new Protein("Crispy Chicken", 2.00);
    public static final SandwichComponent HAM = new Protein("Ham", 1.50);
    public static final SandwichComponent ITALIAN_BMT = new Protein("Italian BMT", 3.50);
    public static final SandwichComponent MARINARA_MEATBALLS = new Protein("Marinara Meatballs", 3.00);
    public static final SandwichComponent PEPPERONI = new Protein("Pepperoni", 2.50);
    public static final SandwichComponent ROAST_BEEF = new Protein("Roast Beef", 3.00);
    public static final SandwichComponent TUNA = new Protein("Tuna", 1.75);
    public static final SandwichComponent VEGGIE_PATTY = new Protein("Veggie Patty", 1.50);

    // available cheese
    public static final SandwichComponent CHEDDAR = new Cheese("Cheddar Cheese", 1.50);
    public static final SandwichComponent PARMESAN = new Cheese("Parmesan Cheese", 1.50);
    public static final SandwichComponent FETA = new Cheese("Feta Cheese", 2.00);
    public static final SandwichComponent MONTEREY_JACK = new Cheese("Monterey Jack Cheese", 2.00);
    public static final SandwichComponent SWISS = new Cheese("Swiss Cheese", 2.50);

    // available sauces
    public static final SandwichComponent BBQ = new Sauce("BBQ", 1.25);
    public static final SandwichComponent CAESAR = new Sauce("Caesar", 1.25);
    public static final SandwichComponent CHIPOTLE_SOUTHWEST = new Sauce("Chipotle Southwest", 1.25);
    public static final SandwichComponent CREAMY_SRIRACHA = new Sauce("Creamy Sriracha", 1.25);
    public static final SandwichComponent GARLIC_AIOLI = new Sauce("Garlic Aioli", 1.25);
    public static final SandwichComponent MAYONNAISE = new Sauce("Mayonnaise", 1.25);
    public static final SandwichComponent MUSTARD = new Sauce("Mustard", 1.25);
    public static final SandwichComponent HOT = new Sauce("Hot Sauce", 1.25);
    public static final SandwichComponent GREEN_GODDESS = new Sauce("Green Goddess Dressing", 2.00);
    public static final SandwichComponent SWEET_ONION_SAUCE = new Sauce("Sweet Onion", 1.25);

    // available vegetables
    public static final SandwichComponent TOMATO = new Vegetable("Tomato", 0.35);
    public static final SandwichComponent ONION = new Vegetable("Onion", 0.35);
    public static final SandwichComponent LETTUCE = new Vegetable("Lettuce", 0.35);
    public static final SandwichComponent SPINACH = new Vegetable("Spinach", 0.35);
    public static final SandwichComponent CUCUMBER = new Vegetable("Cucumber", 0.35);
    public static final SandwichComponent OLIVE = new Vegetable("Olive", 0.35);
    public static final SandwichComponent GUACAMOLE = new Vegetable("Guacamole", 0.35);
    public static final SandwichComponent PICKLE = new Vegetable("Pickle", 0.35);
    public static final SandwichComponent BANANA_PEPPER = new Vegetable("Banana Pepper", 0.35);
    public static final SandwichComponent JALAPENO = new Vegetable("Jalapeno", 0.35);

    // available seasoning
    public static final SandwichComponent SALT = new Seasoning("Salt", 0);
    public static final SandwichComponent PEPPER = new Seasoning("Pepper", 0);

    // available dessert
    public static final SandwichComponent CHOCO_CHIP_COOKIE = new Dessert("Choco-Chip Cookie", 4.50);
    public static final SandwichComponent BROWNIE = new Dessert("Brownie", 5.00);
    public static final SandwichComponent PLAIN_COOKIE = new Dessert("Plain Cookie", 3.50);
    public static final SandwichComponent CHOCOLATE_SOFTY = new Dessert("Chocolate Softy", 3.00);
    public static final SandwichComponent VANILLA_SOFTY = new Dessert("Vanilla Softy", 3.00);

    // available drinks
    public static final SandwichComponent WATER = new Drink("Bottled Water", 2.00);
    public static final SandwichComponent COCA_COLA = new Drink("Coca-Cola", 2.50);
    public static final SandwichComponent MOUNTAIN_DEW = new Drink("Mountain Dew", 2.50);
    public static final SandwichComponent ROOT_BEER = new Drink("Root Beer", 2.60);
    public static final SandwichComponent FANTA = new Drink("Fanta", 2.50);

    // variables
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JButton startNewOrder;
    JButton viewPreviousOrders;
    MySandwich order = new MySandwich();
    AddBreadGUI myGuiBread = new AddBreadGUI();
    AddProteinGUI myGuiProtein = new AddProteinGUI();
    AddCheeseGUI myGuiCheese = new AddCheeseGUI();
    AddVegetableGUI myGuiVegetable = new AddVegetableGUI();
    AddSauceGUI myGuiSauce = new AddSauceGUI();
    AddSaltPepperGUI myGuiMoreInfo = new AddSaltPepperGUI();
    AddDessertGUI myGuiDessert = new AddDessertGUI();
    AddDrinkGUI myGuiDrink = new AddDrinkGUI();
    ViewPrevOrdersGUI myGuiPrevOrders = new ViewPrevOrdersGUI();

    //set up
    WelcomeGUI() {
        this.setTitle("MySandwich");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runApp();
        this.pack();
        this.setVisible(true);
    }

    //runs the sandwich app
    public void runApp() {
        welcomePage();
    }

    //MODIFIES: this
    //EFFECTS: sets the welcome page up
    private void welcomePage() {
        addPanel(panel1);
        addPanel(panel2);
        addPanel(panel3);
        addPanel(panel4);
        addPanel(panel5);
        JLabel welcomeLabel = new JLabel("Welcome to MySandwich");
        welcomeLabel.setBounds(230, 250, 160, 25);
        panel5.add(welcomeLabel);
        welcomeLabel.revalidate();
        welcomeLabel.repaint();
        startNewOrder = new JButton("Start new order");
        startNewOrder.setBounds(230, 275, 160, 30);
        startNewOrder.addActionListener(this);
        panel5.add(startNewOrder);
        viewPreviousOrders = new JButton("View previous orders");
        viewPreviousOrders.setBounds(230, 295, 160, 30);
        viewPreviousOrders.addActionListener(this);
        panel5.add(viewPreviousOrders);
        this.add(panel1, BorderLayout.EAST);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.WEST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);
    }

    //MODIFIES: panel
    //helper method
    //EFFECTS: customises dimension of the panel given
    private void addPanel(JPanel panel) {
        panel.setPreferredSize(new Dimension(200, 200));
        //panel.setBackground(Color.GREEN);
    }

    //MODIFIES: this
    // EFFECTS: starts order process if start new order button is hit,
    // shows user the previous orders
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startNewOrder) {
            myGuiBread.setVisible(true);
            this.dispose();
        } else if (e.getSource() == viewPreviousOrders) {
            this.setVisible(false);
            myGuiPrevOrders.setVisible(true);
        }
    }
}

