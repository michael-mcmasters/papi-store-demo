package com.codedifferently.store;

// Importing objects from the util folder so that we can create new references to them.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PapiStore {

    // This is a field for the class. All properties are null but will be assigned in the constructor when the class is instantiated.
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    Map<String, Double> owesPapiMoney;

    // This is one constructor that sets the default values for its properties.
    public PapiStore(){
        this.isStoreOpen = false;
        this.tabs = new ArrayList();            // creating a new arraylist object.
        this.owesPapiMoney = new HashMap<>();   // creating a new HashMap object.
    }

    // Method Overriding. If a class passes these arguments, this constructor will be called instead of the one above.
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    // This is a publicly accessible function that returns nothing... and does nothing. Not sure why this is here lol. It is currently not being called.
    public void closeStore(){

    }

    // This function opens the store by setting the boolean to true. It returns nothing.
    public void openStore(){
        this.isStoreOpen = true;
    }

    // This function checks that the store is open by getting the value of the boolean that openStore() sets.
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    // This function takes a user's name and returns true or false depending on if they can use a tab or not.
    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))      // If the user has a tab, and does not have an overdue balance, return true.
            response = true;
        return response;                                            // Otherwise return false.
    }

    // This function takes in a user's name and returns true or false depending on if they have an overdue balance or not.
    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }

    // This function takes in a user's name and returns true or false depending on if they have an existing tab open or not.
    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        return false;
    }

    // This will create a new tab for the name of the person passed to the function.
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    // This initiates the program. It is the gate that allows us to communicate with the heap.
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
