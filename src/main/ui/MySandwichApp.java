package ui;

import model.*;

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

    // variables
    private MySandwich order = new MySandwich();
    private Scanner input;

    // runs the MySandwich application
    public MySandwichApp() {
        runApp();
    }

    //MODIFIES: this
    //EFFECTS: processes the user input
    public void runApp() {
        displayWelcomeMenu();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        sandwich();
        showPriceBreakDown();
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
        if (s.equals("bacon")) {
            addAndPrintProtein(BACON_STRIPS);
        } else if (s.equals("grilled")) {
            addAndPrintProtein(GRILLED_CHICKEN);
        } else if (s.equals("crispy")) {
            addAndPrintProtein(CRISPY_CHICKEN);
        } else if (s.equals("ham")) {
            addAndPrintProtein(HAM);
        } else if (s.equals("bmt")) {
            addAndPrintProtein(ITALIAN_BMT);
        } else if (s.equals("meatballs")) {
            addAndPrintProtein(MARINARA_MEATBALLS);
        } else if (s.equals("pepperoni")) {
            addAndPrintProtein(PEPPERONI);
        } else if (s.equals("beef")) {
            addAndPrintProtein(ROAST_BEEF);
        } else if (s.equals("tuna")) {
            addAndPrintProtein(TUNA);
        } else if (s.equals("veggie")) {
            addAndPrintProtein(VEGGIE_PATTY);
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
                order.addExtra(TOMATO);
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
                order.addExtra(ONION);
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
                order.addExtra(LETTUCE);
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
                order.addExtra(SPINACH);
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
                order.addExtra(CUCUMBER);
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
                order.addExtra(OLIVE);
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
                order.addExtra(GUACAMOLE);
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
                order.addExtra(PICKLE);
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
                order.addExtra(BANANA_PEPPER);
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
                order.addExtra(JALAPENO);
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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //EFFECTS: shows the total breakdown of each component of the sandwich, including total amount with tax
    public void showPriceBreakDown() {
        System.out.println("\nTotal price breakdown: ");
        for (int i = 0; i < order.getFillings().size(); i++) {
            String name = order.getFillings().get(i);
            System.out.println(name + " - $" + String.format("%.2f", order.getAddedFillings().get(name)));
        }
        double tax = (order.returnPriceWithoutTax() * 0.07);
        System.out.println("Tax - $" + String.format("%.2f", tax));
        System.out.println(order.toString());
    }
}

