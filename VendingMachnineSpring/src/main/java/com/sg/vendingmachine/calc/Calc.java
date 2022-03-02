package com.sg.vendingmachine.calc;

import dto.Item;
import view.VendingMachineView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Calc {

    VendingMachineView view;

    public Calc (VendingMachineView aView){
        this.view = aView;
    }

    public double getMoney(){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert the amount of money in cents (2euro == 200): ");
        double money = in.nextDouble();
        return money;
    }

    public void checkTransaction(int choice, double amt, ArrayList<Item> itemArrayList ){

        //Boolean to keep the user in a loop, as long as the amount of money they input is not enough.
        boolean stillNotEnough = true;
        Scanner in = new Scanner(System.in);



        //Index based on the user's input, that we use to index in the Array List.
        int index = choice -1;
        int currInventory = Integer.parseInt(itemArrayList.get(index).getItemInventory());

        //Get the item price and convert it from a String to a double.
        String itemPrice = itemArrayList.get(index).getItemPrice();
        double currItemPrice = Double.parseDouble(itemPrice);


        //If the amount is not enough, we enter a loop where the user keeps giving input for money, until they insert a sufficient amount.


        if(amt < currItemPrice) {
            while (stillNotEnough) {

                //Alert the user that there isnt enough money.
                view.printNotEnoughMoney();
                amt = in.nextDouble();

                if (amt >= currItemPrice) {
                    //If the amount of money is enough, we lower the current inventory by 1, turn the int to a string, and use a setter to update the inventory
                    currInventory -= 1;
                    String strCurrInventory = Integer.toString(currInventory);
                    itemArrayList.get(index).setItemInventory(strCurrInventory);

                    //We print out success messages and calculate the change
                    view.printSucTransaction();
                    calculateChange(amt, currItemPrice);
                    stillNotEnough = false;

                }
            }
        }
        else {
            //If the amount of money is enough, we lower the current inventory by 1, turn the int to a string, and use a setter to update the inventory
            currInventory -= 1;
            String strCurrInventory = Integer.toString(currInventory);
            itemArrayList.get(index).setItemInventory(strCurrInventory);
            //We print out success messages and calculate the change
            view.printSucTransaction();
            calculateChange(amt, currItemPrice);        }
    }

    void calculateChange(double amt, double itemPrice){

        double change = amt - itemPrice;
        String strChange = Double.toString(change);
        //Converted from the original double amount to a BigDecimal, as per Guidelines ask.
        BigDecimal changeToBigDecimal = new BigDecimal(strChange);


        //VendingMachineView view = new VendingMachineView();

        if(changeToBigDecimal.equals(0)){
            view.printExactAmt(amt);
        }
        else {
            //Standard change calculation algorithm.
            //We get the change amount by subtracting the item price from the given money.
            //Then we use div and mod to break down that initial amount of change.
            int euroCoins = calcOneEuros(changeToBigDecimal);

            int remainder = (int) (change % 100);
            int fiftyCent = CalcFiftyC(remainder);

            remainder = remainder % 50;
            int twentyCent = calcTwentyC(remainder);

            remainder = remainder%20;
            int tenCent = calcTenC(remainder);

            remainder = remainder%10;
            int fiveCents = calcFiveC(remainder);

            int penies = remainder%5;

            //We print out the change.
            view.printChange(euroCoins, fiftyCent, twentyCent, tenCent, fiveCents, penies);
        }
    }

    public static int calcOneEuros(BigDecimal change){
        int returnedValue = change.intValue();
        returnedValue = returnedValue/100;
        return returnedValue;
    }
    public static int CalcFiftyC(double remainder){
        return (int)remainder/50;
    }
    public static int calcTwentyC(double remainder){
        return (int)remainder/20;
    }
    public static int calcTenC(double remainder){
        return (int)remainder/10;
    }
    public static int calcFiveC(double remainder){
        return (int)remainder/5;
    }

}
