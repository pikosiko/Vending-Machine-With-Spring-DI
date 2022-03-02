package dao;

import dto.Item;
import view.VendingMachineView;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineDaoImpl {

    public static final String INPUTS_FILE = "inventory.txt";
    public static final String DELIMITER = ",";

    VendingMachineView view = new VendingMachineView();
    ArrayList<Item> itemArrayList = new ArrayList<Item>();


    public Item unmarshallData(String itemAsText){
        String[] itemTokens = itemAsText.split(DELIMITER);

        String itemName = itemTokens[0];
        String itemPrice = itemTokens[1];
        String itemInventory = itemTokens[2];


        Item itemFromFile = new Item(itemName, itemPrice, itemInventory);

        return  itemFromFile;
    }

    public String marshallData(Item aItem){
        String itemAsText = aItem.getItemName() + DELIMITER;
        itemAsText += aItem.getItemPrice() + DELIMITER;
        itemAsText += aItem.getItemInventory() + DELIMITER;
        return  itemAsText;
    }



    public void loadDvDFromFile(ArrayList<Item> itemArrayList){
        Scanner scanner = null;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INPUTS_FILE)));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        String currentLine;
        Item currentItem;

        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentItem = unmarshallData(currentLine);

            String strCurrentInv = currentItem.getItemInventory();
            int currentInv = Integer.parseInt(strCurrentInv);
            if(currentInv > 0){
                itemArrayList.add(currentItem);
            }


        }
        scanner.close();
    }

    public void writeDvdToFile(ArrayList<Item> itemArrayList){

        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(INPUTS_FILE));
        } catch (IOException e) {
            System.out.println("Error IOException");
        }

        String itemAsText;
        for(Item i: itemArrayList){
            itemAsText = marshallData(i);
            out.println(itemAsText);
            out.flush();
        }
        out.close();

    }
}
