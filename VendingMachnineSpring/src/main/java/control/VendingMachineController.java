package control;

import com.sg.vendingmachine.calc.Calc;
import dao.VendingMachineDaoImpl;
import dto.Item;
import view.VendingMachineView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineController {

    public void startMachine(){

        int menuSelection;

        VendingMachineView view = new VendingMachineView();
        VendingMachineDaoImpl dao = new VendingMachineDaoImpl();
        Calc calc = new Calc(view);

        ArrayList<Item> itemArrayList = new ArrayList<Item>();

        Scanner in = new Scanner(System.in);

        double userAmtInput;
        int userItemChoice;

        //Load from file
        dao.loadDvDFromFile(itemArrayList);

        //View Insert Money or exit option and get input
        view.viewMenu();
        menuSelection = in.nextInt();


        if(menuSelection == 1){
            //User views the items
            view.viewItems(itemArrayList);

            //User inputs the amount of money
            userAmtInput = calc.getMoney();

            //User makes an item choice
            view.makeAChoice(itemArrayList);
            userItemChoice = in.nextInt();

            //Program checks if the user input is correct.
            try{
                if(validateInput(userItemChoice, itemArrayList) == true){

                    try {
                        //Program checks if there is enough stock
                        if(checkIfThereIsStock(userItemChoice, itemArrayList) == true){

                            //Program checks if they can make the transaction. If it is possible the user gets their change and the program closes. If it isn't the program asks the user to enter another amount until it is enough.
                            calc.checkTransaction(userItemChoice, userAmtInput, itemArrayList);
                            //As per guideline requirements.
                            LocalDateTime ld = LocalDateTime.now();
                            view.printDate(ld);

                            view.displayGoodbye();
                            try {
                                dao.writeDvdToFile(itemArrayList);
                            }
                            catch (Exception e){
                                System.out.println("File not found.");
                                e.printStackTrace();
                            }
                        }
                        //WORKS LIKE THIS:
                        /*
                         * if the item has 0 inventory the item isn't registered in the array, therefore the user can't choose it, and we don't get to see the exception that occurs.
                         * */

                    }
                    catch (NoItemInventoryException e){
                        System.out.println(e);
                    }
                }

            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Exception occurred, Index was out of bounds.");
            }



        }
        else{
            //Program displays goodbye message and saved everything from the arraylist to the file before exiting.
            view.displayGoodbye();
            try {
                dao.writeDvdToFile(itemArrayList);
            }
            catch (Exception e){
                System.out.println("File not found.");
            }
        }
    }

    public  boolean checkIfThereIsStock(int choice, ArrayList<Item> itemArrayList) throws NoItemInventoryException{

        //Create an index
        int index = choice -1;

        //Get the current inventory from the array list and turn in into an int
        String strItemsLeft = itemArrayList.get(index).getItemInventory();
        String msg = "Custom exception occurred. No stock left.";
        int itemsLeft = Integer.parseInt(strItemsLeft);

        //Check whether there are items left and return true or false.
        if(itemsLeft>0){
            return true;
        }
        else {
            throw new NoItemInventoryException(msg);
        }

    }

    public static boolean validateInput(int choice, ArrayList<Item> itemArrayList) throws IndexOutOfBoundsException{

        if(choice>-1 && choice<=itemArrayList.size()){
            return true;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }
}
