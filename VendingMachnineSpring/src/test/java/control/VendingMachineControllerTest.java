package control;

import dto.Item;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineControllerTest {


    //DONE USING SPRING
    ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingMachineController controllerTest = ctx.getBean("controllertest", VendingMachineController.class);

    @Test
    public void checkIfThereIsStockTest() throws NoItemInventoryException{


        //OLD WAY
        //VendingMachineController controllerTest = new VendingMachineController();

        boolean caught = false;

        String testItemName = "Coca";
        String testItemPrice = "100";
        String testItemStock = "0";

        Item testItem = new Item(testItemName,testItemPrice,testItemStock);

        ArrayList<Item> testArrayList = new ArrayList<>();
        testArrayList.add(testItem);

        int testChoice = 1;

        try {
            controllerTest.checkIfThereIsStock(testChoice,testArrayList);
            fail("Did not throw NoItemInventoryException");
        }
        catch (NoItemInventoryException e){
            caught = true;
        }

        assertTrue(caught);

    }

    @Test
    public void checkIfTheIndexIsCorrect() throws IndexOutOfBoundsException{

        //OLD WAY
        //VendingMachineController controllerTest = new VendingMachineController();
        boolean caughtFlag = false;

        ArrayList<Item> testArrayList = new ArrayList<>();

        Item item1 = new Item("K", "33", "12");
        Item item2 = new Item("2", "33", "12");
        Item item3 = new Item("3", "33", "12");
        testArrayList.add(item1);
        testArrayList.add(item2);
        testArrayList.add(item3);

        int choice = 13;

        try {
            controllerTest.validateInput(choice, testArrayList);
            fail("Index should be out of bounds");
        }
        catch (IndexOutOfBoundsException e){
            caughtFlag = true;
        }

        assertTrue(caughtFlag);




    }

}