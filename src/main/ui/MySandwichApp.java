package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MySandwich Application
public class MySandwichApp {
    // available breads with prices
    private static final SandwichComponent ENGLISH = new Bread("English Bread", 1.00);
    private static final SandwichComponent FLAT = new Bread("Flat Bread", 1.00);
    private static final SandwichComponent GLUTEN_FREE = new Bread("Gluten-Free Bread", 1.00);
    private static final SandwichComponent HARVEST_GRAIN = new Bread("Harvest-Grain Bread", 1.00);
    private static final SandwichComponent ITALIAN = new Bread("Italian Bread", 1.00);
    private static final SandwichComponent ITALIAN_HERBS_AND_CHEESE = new Bread("Italian, Herbs and Cheese", 1.00);
    private static final SandwichComponent MULTIGRAIN = new Bread("Multigrain Bread", 1.00);

    // available proteins with prices
    private static final SandwichComponent BACON_STRIPS = new Protein("Bacon Strips", 1.00);
    private static final SandwichComponent GRILLED_CHICKEN = new Protein("Grilled Chicken", 2.00);
    private static final SandwichComponent CRISPY_CHICKEN = new Protein("Crispy Chicken", 2.00);
    private static final SandwichComponent HAM = new Protein("Ham", 1.50);
    private static final SandwichComponent ITALIAN_BMT = new Protein("Italian BMT", 3.50);
    private static final SandwichComponent MARINARA_MEATBALLS = new Protein("Marinara Meatballs", 3.00);
    private static final SandwichComponent PEPPERONI = new Protein("Pepperoni", 2.50);
    private static final SandwichComponent ROAST_BEEF = new Protein("Roast Beef", 3.00);
    private static final SandwichComponent TUNA = new Protein("Tuna", 1.75);
    private static final SandwichComponent VEGGIE_PATTY = new Protein("Veggie Patty", 1.50);

    // available cheese
    private static final SandwichComponent CHEDDAR = new Cheese("Cheddar Cheese", 1.50);
    private static final SandwichComponent PARMESAN = new Cheese("Parmesan Cheese", 1.50);
    private static final SandwichComponent FETA = new Cheese("Feta Cheese", 2.00);
    private static final SandwichComponent MONTEREY_JACK = new Cheese("Monterey Jack Cheese", 2.00);
    private static final SandwichComponent SWISS = new Cheese("Swiss Cheese", 2.50);

    // available sauces
    private static final SandwichComponent BBQ = new Sauce("BBQ", 1.25);
    private static final SandwichComponent CAESAR = new Sauce("Caesar", 1.25);
    private static final SandwichComponent CHIPOTLE_SOUTHWEST = new Sauce("Chipotle Southwest", 1.25);
    private static final SandwichComponent CREAMY_SRIRACHA = new Sauce("Creamy Sriracha", 1.25);
    private static final SandwichComponent GARLIC_AIOLI = new Sauce("Garlic Aioli", 1.25);
    private static final SandwichComponent MAYONNAISE = new Sauce("Mayonnaise", 1.25);
    private static final SandwichComponent MUSTARD = new Sauce("Mustard", 1.25);
    private static final SandwichComponent HOT = new Sauce("Hot Sauce", 1.25);
    private static final SandwichComponent GREEN_GODDESS = new Sauce("Green Goddess Dressing", 2.00);
    private static final SandwichComponent SWEET_ONION_SAUCE = new Sauce("Sweet Onion", 1.25);

    // available vegetables
    private static final SandwichComponent TOMATO = new Vegetable("Tomato", 0.35);
    private static final SandwichComponent ONION = new Vegetable("Onion", 0.35);
    private static final SandwichComponent LETTUCE = new Vegetable("Lettuce", 0.35);
    private static final SandwichComponent SPINACH = new Vegetable("Spinach", 0.35);
    private static final SandwichComponent CUCUMBER = new Vegetable("Cucumber", 0.35);
    private static final SandwichComponent OLIVE = new Vegetable("Olive", 0.35);
    private static final SandwichComponent GUACAMOLE = new Vegetable("Guacamole", 0.35);
    private static final SandwichComponent PICKLE = new Vegetable("Pickle", 0.35);
    private static final SandwichComponent BANANA_PEPPER = new Vegetable("Banana Pepper", 0.35);
    private static final SandwichComponent JALAPENO = new Vegetable("Jalapeno", 0.35);

    // available seasoning
    private static final SandwichComponent SALT = new Seasoning("Salt", 0);
    private static final SandwichComponent PEPPER = new Seasoning("Pepper", 0);

    // available dessert
    private static final SandwichComponent CHOCO_CHIP_COOKIE = new Dessert("Choco-Chip Cookie", 4.50);
    private static final SandwichComponent BROWNIE = new Dessert("Brownie", 5.00);
    private static final SandwichComponent PLAIN_COOKIE = new Dessert("Plain Cookie", 3.50);
    private static final SandwichComponent CHOCOLATE_SOFTY = new Dessert("Chocolate Softy", 3.00);
    private static final SandwichComponent VANILLA_SOFTY = new Dessert("Vanilla Softy", 3.00);

    // available drinks
    private static final SandwichComponent WATER = new Drink("Bottled Water", 2.00);
    private static final SandwichComponent COCA_COLA = new Drink("Coca-Cola", 2.50);
    private static final SandwichComponent MOUNTAIN_DEW = new Drink("Mountain Dew", 2.50);
    private static final SandwichComponent ROOT_BEER = new Drink("Root Beer", 2.60);
    private static final SandwichComponent FANTA = new Drink("Fanta", 2.50);

    // variables
    private MySandwich order = new MySandwich();
    private Scanner input;
    private List<MySandwich> mySandwiches;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/mySandwiches.json";

    // runs the MySandwich application
    public MySandwichApp() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        mySandwiches = new ArrayList<>();
        runApp();
    }

    //MODIFIES: this
    //EFFECTS: processes the user input
    public void runApp() {
        displayWelcomeMenu();
        loadPreviousOrders();
        sandwich();
        dessert();
        drink();
        showPriceBreakDown();
        mySandwiches.add(order);
        saveMySandwiches();
    }

    public void loadPreviousOrders() {
        System.out.println("\nDo you want to view your previous orders? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            loadMySandwiches();
            printPreviousOrders();
        }
    }

    // EFFECTS: displays the welcome menu to user
    public void displayWelcomeMenu() {
        System.out.println("\nWelcome to MySandwich!");
        System.out.println("Make the sandwich of your life!");
    }

    //MODIFIES: this
    //EFFECTS: adds toppings (and extra) to the sandwich
    public void sandwich() {
        bread();
        protein();
        vegetable();
        sauce();
        seasoning();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: user input must be yes or no , and bread choice must be associated with bread in the menu
    //MODIFIES: this
    //EFFECTS: takes user input and uses the chosen bread, as well as adding cheese and getting it toasted or not
    public void bread() {
        displayBreadMenu();
        String breadType = input.next();
        breadType = breadType.toLowerCase();
        breadChoice(breadType);
        breadSize();
        cheese();
        System.out.println("\nDo you want to toast your bread? (yes or no)");
        String isToasted = input.next();
        isToasted = isToasted.toLowerCase();
        if (isToasted.equals("yes")) {
            System.out.println("Toast bread!");
        }
    }

    //REQUIRES: user input must be 6 or 12 only
    //MODIFIES: this
    //EFFECTS: asks user if they want 6 or 12 inch, and processes the user input
    public void breadSize() {
        System.out.println("\nChoose the size of your sandwich:");
        System.out.println("\t6 -> 6 inch");
        System.out.println("\t12 -> 12 inch");
        int size = input.nextInt();
        if (size == 6) {
            order.setIsSixInch();
            System.out.println("You have chosen: 6-inch Sandwich");
        } else {
            System.out.println("You have chosen: 12-inch Sandwich");
        }
    }

    //EFFECTS: displays the bread menu to user
    public void displayBreadMenu() {
        System.out.println("\nChoose the type of bread:");
        System.out.println("\tenglish -> English Bread");
        System.out.println("\tflat -> Flat Bread");
        System.out.println("\tglutenfree -> Gluten-Free Bread");
        System.out.println("\tharvest -> Harvest-Grain Bread");
        System.out.println("\titalian -> Italian Bread");
        System.out.println("\tihac -> Italian, Herbs and Cheese Bread");
    }

    //EFFECTS: processes user bread choice and displays user choice
    public void breadChoice(String s) {
        if (s.equals("english")) {
            order.addComponent(ENGLISH);
            System.out.println("You have chosen: " + ENGLISH.getName());
        } else if (s.equals("flat")) {
            order.addComponent(FLAT);
            System.out.println("You have chosen: " + FLAT.getName());
        } else if (s.equals("glutenfree")) {
            order.addComponent(GLUTEN_FREE);
            System.out.println("You have chosen: " + GLUTEN_FREE.getName());
        } else if (s.equals("harvest")) {
            order.addComponent(HARVEST_GRAIN);
            System.out.println("You have chosen: " + HARVEST_GRAIN.getName());
        } else if (s.equals("italian")) {
            order.addComponent(ITALIAN);
            System.out.println("You have chosen: " + ITALIAN.getName());
        } else if (s.equals("ihac")) {
            order.addComponent(ITALIAN_HERBS_AND_CHEESE);
            System.out.println("You have chosen: " + ITALIAN_HERBS_AND_CHEESE.getName());
        } else if (s.equals("multigrain")) {
            order.addComponent(MULTIGRAIN);
            System.out.println("You have chosen: " + MULTIGRAIN.getName());
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: user input must be yes or no , and protein choice must be associated with a protein in the menu
    //MODIFIES: this
    //EFFECTS: takes user input and adds the chosen protein(s)
    public void protein() {
        displayProteinMenu();
        String protein = input.next();
        protein = protein.toLowerCase();
        proteinChoice(protein);
        System.out.println("\nWould you like to add one more protein? (yes or no)");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equals("yes")) {
            System.out.println("Choose another protein:");
            displayProteinMenu();
            String proteinAgain = input.next();
            proteinAgain = proteinAgain.toLowerCase();
            proteinChoice(proteinAgain);
        }
    }

    //EFFECTS: displays protein menu to user
    public void displayProteinMenu() {
        System.out.println("\nChoose protein:");
        System.out.println("\tbacon -> Bacon Strips");
        System.out.println("\tgrilled -> Grilled Chicken");
        System.out.println("\tcrispy -> Crispy Chicken");
        System.out.println("\tham -> Ham");
        System.out.println("\tbmt -> Italian BMT");
        System.out.println("\tmeatballs -> Marinara Meatballs");
        System.out.println("\tpepperoni -> Pepperoni");
        System.out.println("\tbeef -> Roast Beef");
        System.out.println("\ttuna -> Tuna");
        System.out.println("\tveggie -> Veggie Patty");
    }

    //helper method
    //EFFECTS: adds protein to sandwich and displays user choice
    public void addAndPrintProtein(SandwichComponent sandwichComponent) {
        order.addComponent(sandwichComponent);
        System.out.println("You have chosen: " + sandwichComponent.getName());
    }

    //EFFECTS: processes user bread choice and displays user choice
    public void proteinChoice(String s) {
        switch (s) {
            case "bacon":
                addAndPrintProtein(BACON_STRIPS);
                break;
            case "grilled":
                addAndPrintProtein(GRILLED_CHICKEN);
                break;
            case "crispy":
                addAndPrintProtein(CRISPY_CHICKEN);
                break;
            case "ham":
                addAndPrintProtein(HAM);
                break;
            case "bmt":
                addAndPrintProtein(ITALIAN_BMT);
                break;
            case "meatballs":
                addAndPrintProtein(MARINARA_MEATBALLS);
                break;
           // case "pepperoni"://   addAndPrintProtein(PEPPERONI);// break;// case "beef":\//
            // addAndPrintProtein(ROAST_BEEF);/// break;
            //case "tuna":
                //addAndPrintProtein(TUNA);
                //break;
            case "veggie":
                addAndPrintProtein(VEGGIE_PATTY);
                break;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    //MODIFIES: this
    //EFFECTS: takes user input and adds the chosen vegetable(s)
    public void vegetable() {
        displayVegetableMenu();
    }

    public void displayVegetableMenu() {
        tomato();
        onion();
        lettuce();
        spinach();
        cucumber();
        olive();
        guacamole();
        pickle();
        bananaPepper();
        jalapeno();
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add tomatoes(and extra) and processes user input
    public void tomato() {
        System.out.println("Do you want to add Tomatoes? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(TOMATO);
            System.out.println("You have added: Tomatoes");
            System.out.println("Do you want to add extra Tomatoes? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(TOMATO);
                System.out.println("You have added: Tomatoes");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add onions(and extra) and processes user input
    public void onion() {
        System.out.println("Do you want to add Onions? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(ONION);
            System.out.println("You have added: Onions");
            System.out.println("Do you want to add extra Onions? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(ONION);
                System.out.println("You have added: Onions");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add lettuce(and extra) and processes user input
    public void lettuce() {
        System.out.println("Do you want to add Lettuce? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(LETTUCE);
            System.out.println("You have added: lettuce");
            System.out.println("Do you want to add extra Lettuce? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(LETTUCE);
                System.out.println("You have added: Lettuce");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add spinach(and extra) and processes user input
    public void spinach() {
        System.out.println("Do you want to add Spinach? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(SPINACH);
            System.out.println("You have added: Spinach");
            System.out.println("Do you want to add extra Spinach? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(SPINACH);
                System.out.println("You have added: Spinach");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add cucumbers(and extra) and processes user input
    public void cucumber() {
        System.out.println("Do you want to add Cucumbers? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(CUCUMBER);
            System.out.println("You have added: Cucumbers");
            System.out.println("Do you want to add extra Cucumbers? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(CUCUMBER);
                System.out.println("You have added: Cucumber");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add olives(and extra) and processes user input
    public void olive() {
        System.out.println("Do you want to add Olives? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(OLIVE);
            System.out.println("You have added: Olives");
            System.out.println("Do you want to add extra Olives? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(OLIVE);
                System.out.println("You have added: Olives");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add guacamole(and extra) and processes user input
    public void guacamole() {
        System.out.println("Do you want to add Guacamole? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(GUACAMOLE);
            System.out.println("You have added: Guacamole");
            System.out.println("Do you want to add extra Guacamole? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(GUACAMOLE);
                System.out.println("You have added: Guacamole");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add pickles(and extra) and processes user input
    public void pickle() {
        System.out.println("Do you want to add Pickles? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(PICKLE);
            System.out.println("You have added: Pickles");
            System.out.println("Do you want to add extra Pickles? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(PICKLE);
                System.out.println("You have added: Pickles");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add banana peppers(and extra) and processes user input
    public void bananaPepper() {
        System.out.println("Do you want to add Banana Peppers? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(BANANA_PEPPER);
            System.out.println("You have added: Banana Peppers");
            System.out.println("Do you want to add extra Banana Peppers? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(BANANA_PEPPER);
                System.out.println("You have added: Banana Peppers");
            }
        }
    }

    //helper method
    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: ask user if they want to add jalapenos(and extra) and processes user input
    public void jalapeno() {
        System.out.println("Do you want to add Jalapenos? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            order.addComponent(JALAPENO);
            System.out.println("You have added: Jalapenos");
            System.out.println("Do you want to add extra Jalapenos? (yes or no)");
            String choiceAgain = input.next();
            choiceAgain = choiceAgain.toLowerCase();
            if (choiceAgain.equals("yes")) {
                order.addComponent(JALAPENO);
                System.out.println("You have added: Jalapenos");
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: user input must be yes or no, and sauce choice must be associated with a sauce in the menu
    //MODIFIES: this
    //EFFECTS: asks user to choose up to 4 sauces, and processes user input
    public void sauce() {
        System.out.println("Choose up to 4 sauces:");
        int count = 0;
        while (count < 4) {
            System.out.println("\nSauce " + (count + 1));
            displaySauceMenu();
            String choice = input.next();
            choice = choice.toLowerCase();
            sauceChoice(choice);
            if (count < 3) {
                System.out.println("Do you want to add another sauce? (yes or no)");
                String addAnotherSauce = input.next();
                addAnotherSauce = addAnotherSauce.toLowerCase();
                if (addAnotherSauce.equals("no")) {
                    count = 5;
                } else {
                    count++;
                }
            } else if (count >= 3) {
                count = 5;
            }
        }
    }

    //EFFECTS: displays the sauce menu to user
    public void displaySauceMenu() {
        System.out.println("\tbbq -> BBQ");
        System.out.println("\tcaesar -> Caesar");
        System.out.println("\tchipotle -> Chipotle Southwest");
        System.out.println("\tsriracha -> Creamy Sriracha");
        System.out.println("\taioli -> Garlic Aioli");
        System.out.println("\tmayo -> Mayonnaise");
        System.out.println("\tmustard -> Mustard");
        System.out.println("\thot -> Hot Sauce");
        System.out.println("\tgoddess -> Green Goddess Dressing");
        System.out.println("\tonion -> Sweet Onion");
    }

    //EFFECTS: adds sauce to sandwich and displays user choice
    public void addAndPrintSauce(SandwichComponent sandwichComponent) {
        order.addComponent(sandwichComponent);
        System.out.println("You have added: " + sandwichComponent.getName());
    }

    //REQUIRES: string s must be associated with a sauce in the menu
    //EFFECTS: matches string and adds sauce to sandwich, displaying user choice
    public void sauceChoice(String s) {
        if (s.equals("bbq")) {
            addAndPrintSauce(BBQ);
        } else if (s.equals("caesar")) {
            addAndPrintSauce(CAESAR);
        } else if (s.equals("chipotle")) {
            addAndPrintSauce(CHIPOTLE_SOUTHWEST);
        } else if (s.equals("sriracha")) {
            addAndPrintSauce(CREAMY_SRIRACHA);
        } else if (s.equals("aioli")) {
            addAndPrintSauce(GARLIC_AIOLI);
        } else if (s.equals("mayo")) {
            addAndPrintSauce(MAYONNAISE);
        } else if (s.equals("mustard")) {
            addAndPrintSauce(MUSTARD);
        } else if (s.equals("hot")) {
            addAndPrintSauce(HOT);
        } else if (s.equals("goddess")) {
            addAndPrintSauce(GREEN_GODDESS);
        } else if (s.equals("onion")) {
            addAndPrintSauce(SWEET_ONION_SAUCE);
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: user input must be yes or no only
    //MODIFIES: this
    //EFFECTS: asks user if they want to add salt or pepper, then processes the input and adds it to the sandwich
    public void seasoning() {
        System.out.println("\nDo you want to add Salt? (yes or no)");
        String wantSalt = input.next();
        wantSalt = wantSalt.toLowerCase();
        if (wantSalt.equals("yes")) {
            order.addComponent(SALT);
            System.out.println("You have added: " + SALT.getName());
        }
        System.out.println("\nDo you want to add Pepper? (yes or no)");
        String wantPepper = input.next();
        wantPepper = wantPepper.toLowerCase();
        if (wantPepper.equals("yes")) {
            order.addComponent(PEPPER);
            System.out.println("You have added: " + PEPPER.getName());
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: input must be yes or no only
    //MODIFIES: this
    //EFFECTS: displays cheese menu, processes user input and adds cheese to sandwich
    public void cheese() {
        displayCheeseMenu();
        String cheeseType = input.next();
        cheeseType = cheeseType.toLowerCase();
        cheeseChoice(cheeseType);
        System.out.println("\nDo you want to add more cheese? (yes or no)");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equals("yes")) {
            displayCheeseMenu();
            String cheeseTypeAgain = input.next();
            cheeseTypeAgain = cheeseTypeAgain.toLowerCase();
            cheeseChoice(cheeseTypeAgain);
        }
    }

    //REQUIRES: string s must be associated with one of the cheese in the menu
    //EFFECTS: EFFECTS: matches string and adds cheese to sandwich, displaying user choice
    public void cheeseChoice(String s) {
        if (s.equals("cheddar")) {
            order.addComponent(CHEDDAR);
            System.out.println("You have chosen: " + CHEDDAR.getName());
        } else if (s.equals("parmesan")) {
            order.addComponent(PARMESAN);
            System.out.println("You have chosen: " + PARMESAN.getName());
        } else if (s.equals("feta")) {
            order.addComponent(FETA);
            System.out.println("You have chosen: " + FETA.getName());
        } else if (s.equals("jack")) {
            order.addComponent(MONTEREY_JACK);
            System.out.println("You have chosen: " + MONTEREY_JACK.getName());
        } else if (s.equals("swiss")) {
            order.addComponent(SWISS);
            System.out.println("You have chosen: " + SWISS.getName());
        }
    }

    //EFFECTS: displays the cheese menu to user
    public void displayCheeseMenu() {
        System.out.println("\nChoose the type of cheese:");
        System.out.println("\tcheddar -> Cheddar Cheese");
        System.out.println("\tparmesan -> Parmesan Cheese");
        System.out.println("\tfeta -> Feta Cheese");
        System.out.println("\tjack -> Monterey Jack");
        System.out.println("\tswiss -> Swiss Cheese");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: inputs must be yes or no only
    //MODIFIES: this
    //EFFECTS: displays drinks menu, processes user input and adds drink(s) to sandwich order
    public void drink() {
        boolean toContinue = true;
        System.out.println("\nDo you want a drink? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            while (toContinue) {
                displayDrinkMenu();
                String drinkChoice = input.next();
                drinkChoice = drinkChoice.toLowerCase();
                drinkChoice(drinkChoice);
                System.out.println("\nDo you want another drink? (yes or no)");
                String choice2 = input.next();
                choice2 = choice2.toLowerCase();
                if (choice2.equals("no")) {
                    toContinue = false;
                }
            }
        }
    }

    //REQUIRES: string s must be associated with one of the drinks in the menu
    //EFFECTS: matches string and adds drink to sandwich order, displaying user choice
    public void drinkChoice(String s) {
        if (s.equals("water")) {
            order.addComponent(WATER);
            System.out.println("You have chosen: " + WATER.getName());
        } else if (s.equals("coke")) {
            order.addComponent(COCA_COLA);
            System.out.println("You have chosen: " + COCA_COLA.getName());
        } else if (s.equals("dew")) {
            order.addComponent(MOUNTAIN_DEW);
            System.out.println("You have chosen: " + MOUNTAIN_DEW.getName());
        } else if (s.equals("root")) {
            order.addComponent(ROOT_BEER);
            System.out.println("You have chosen: " + ROOT_BEER.getName());
        } else if (s.equals("fanta")) {
            order.addComponent(FANTA);
            System.out.println("You have chosen: " + FANTA.getName());
        }
    }

    //EFFECTS: displays the cheese menu to user
    public void displayDrinkMenu() {
        System.out.println("\nChoose the drink of your choice:");
        System.out.println("\twater -> Bottled Water");
        System.out.println("\tcoke -> Coca Cola");
        System.out.println("\tdew -> Mountain Dew");
        System.out.println("\troot -> Root Beer");
        System.out.println("\tfanta -> Fanta");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //REQUIRES: inputs must be yes or no only
    //MODIFIES: this
    //EFFECTS: displays drinks menu, processes user input and adds drink(s) to sandwich order
    public void dessert() {
        boolean toContinue = true;
        System.out.println("\nDo you want a dessert? (yes or no)");
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.equals("yes")) {
            while (toContinue) {
                displayDessertMenu();
                String dessertChoice = input.next();
                dessertChoice = dessertChoice.toLowerCase();
                dessertChoice(dessertChoice);
                System.out.println("\nDo you want another dessert? (yes or no)");
                String choice2 = input.next();
                choice2 = choice2.toLowerCase();
                if (choice2.equals("no")) {
                    toContinue = false;
                }
            }
        }
    }

    //REQUIRES: string s must be associated with one of the desserts in the menu
    //EFFECTS: matches string and adds dessert to sandwich order, displaying user choice
    public void dessertChoice(String s) {
        if (s.equals("chocochip")) {
            order.addComponent(CHOCO_CHIP_COOKIE);
            System.out.println("You have chosen: " + CHOCO_CHIP_COOKIE.getName());
        } else if (s.equals("brownie")) {
            order.addComponent(BROWNIE);
            System.out.println("You have chosen: " + BROWNIE.getName());
        } else if (s.equals("plain")) {
            order.addComponent(PLAIN_COOKIE);
            System.out.println("You have chosen: " + PLAIN_COOKIE.getName());
        } else if (s.equals("chocolate")) {
            order.addComponent(CHOCOLATE_SOFTY);
            System.out.println("You have chosen: " + CHOCOLATE_SOFTY.getName());
        } else if (s.equals("vanilla")) {
            order.addComponent(VANILLA_SOFTY);
            System.out.println("You have chosen: " + VANILLA_SOFTY.getName());
        }
    }

    //EFFECTS: displays the dessert menu to the user
    public void displayDessertMenu() {
        System.out.println("\nChoose the dessert of your choice:");
        System.out.println("\tchocochip -> Choco-Chip Cookie");
        System.out.println("\tbrownie -> Brownie");
        System.out.println("\tplain -> Plain Cookie");
        System.out.println("\tchocolate -> Chocolate Softy");
        System.out.println("\tvanilla -> Vanilla Softy");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //EFFECTS: shows the total breakdown of each component of the sandwich, including total amount with tax
    public void showPriceBreakDown() {
        System.out.println("\nTotal price breakdown: ");
        for (int i = 0; i < order.getFillings().size(); i++) {
            String name = order.getFillings().get(i).getName();
            System.out.println(name + " - $" + String.format("%.2f", order.getFillings().get(i).getPrice()));
        }
        double tax = (order.returnPriceWithoutTax() * 0.07);
        System.out.println("Tax - $" + String.format("%.2f", tax));
        System.out.println(order.toString());
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //EFFECTS: saves the list of loans to file
    private void saveMySandwiches() {
        try {
            jsonWriter.open();
            jsonWriter.write(mySandwiches);
            jsonWriter.close();
            System.out.println("Saved to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: loads data from file
    private void loadMySandwiches() {
        try {
            mySandwiches = jsonReader.read();
            System.out.println("Loaded from: " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read file from: " + JSON_STORE);
        }
    }

    //EFFECTS: prints the previous orders with the total price including tax
    private void printPreviousOrders() {
        for (int i = 0; i < mySandwiches.size(); i++) {
            System.out.println("\nOrder " + (i + 1));
            for (int j = 0; j < mySandwiches.get(i).getFillings().size(); j++) {
                System.out.println(mySandwiches.get(i).getFillings().get(j).getName());
            }
            System.out.println(mySandwiches.get(i).toString());
        }
    }
}

