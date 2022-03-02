package view;

import dto.Item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

public class VendingMachineView {
    public void viewMenu(){
        System.out.println("===Menu===");
        System.out.println("1. Insert cash amount ");
        System.out.println("2. Exit");
        System.out.println("Select from the menu.");
    }

    public void viewItems(ArrayList<Item> itemArrayList){

        int index = 1;
        for (Item i: itemArrayList){
            //Program gets the number of the inventory
            String strItemsLeft = i.getItemInventory();
            int itemsLeft = Integer.parseInt(strItemsLeft);


            //If there are items left, it displays the item
            if(itemsLeft > 0){
                System.out.println(index + ". " + i.getItemName() + ", Price: " + i.getItemPrice() + "c.");
                index += 1;
            }
        }
    }

   /* WAS USED TO SEE IF WE GET THE CORRECT INPUT FROM THE FILE
    public void displayInput(ArrayList<Item> itemList){
        for(Item i : itemList){
            System.out.println("Item name: " + i.getItemName());
        }
    }*/

    public void makeAChoice(ArrayList<Item> itemArrayList){
        int index = 1;
        for (Item i: itemArrayList){
            //Program gets the number of the inventory
            String strItemsLeft = i.getItemInventory();
            int itemsLeft = Integer.parseInt(strItemsLeft);


            //If there are items left, it displays the item
            if(itemsLeft > 0){
                System.out.println(index + ". " + i.getItemName() + ".");
                index += 1;
            }
        }

    }

    public void displayGoodbye(){
        System.out.println("Goodbye!");
    }

    /*public void printNotEnoughStock(){
        System.out.println("Not enough items left.");
    }*/

    public void printChange(int oneEuro, int fiftyC, int twentyC, int tenC, int fiveC, int penny){
        System.out.println("Euros: " +oneEuro);
        System.out.println("Fifties: " +fiftyC);
        System.out.println("20 cent: " +twentyC);
        System.out.println("10 cent: " +tenC);
        System.out.println("5 cent: " +fiveC);
        System.out.println("Penies: " + penny);
    }

    public void printSucTransaction(){
        System.out.println("Successful transaction, calculating change...");
        System.out.println("Your change is: ");
    }

    public void printNotEnoughMoney(){
        System.out.println("Not enough money.");
        System.out.println("Enter another amount:");
    }

    public void printDate(LocalDateTime ld){
        System.out.println("Time of the transaction: " + ld);
    }

    //USES A LAMBDA TO PRINT
    public void printExactAmt(double amt){

        //EXAMPLE OF LAMBDA USAGE, AS PER GUIDELINES.
        Consumer<Integer> display = a -> System.out.println("Exact amount: "+ a +" No change.");
        display.accept((int) amt);

        //WHAT WAS USED BEFORE THE LAMBDA IMPLEMENTATION.
        //System.out.println("Exact amount. No change.");
    }
}
