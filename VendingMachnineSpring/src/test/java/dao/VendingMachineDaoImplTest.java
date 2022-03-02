package dao;

import dto.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineDaoImplTest {

    ////DONE USING SPRING
    ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingMachineDaoImpl daoTest = ctx.getBean("daotest", VendingMachineDaoImpl.class);

    @BeforeEach
    void setUp() {
    }

    //We check if we get the correct data from the file and the Item is created as expected.
    @Test
    public void testUnmarshall(){

        //OLD WAY
        //VendingMachineDaoImpl daoTest = new VendingMachineDaoImpl();

        String strToUnMar = "Cola,150,15";
        Item hardCodedItem = new Item("Cola", "150", "15");
        Item testItemp = daoTest.unmarshallData(strToUnMar);

        assertEquals(testItemp.getItemName(),hardCodedItem.getItemName(), "Both items should have the same name");
        assertEquals(testItemp.getItemPrice(),hardCodedItem.getItemPrice(), "Both items should have the same price");
        assertEquals(testItemp.getItemInventory(),hardCodedItem.getItemInventory(), "Both items should have the same inventory");
    }

    @Test
    public void testMarshall(){

        //OLD WAY
        //VendingMachineDaoImpl daoTest = new VendingMachineDaoImpl();

        String strToMar = "Cola,150,15,";
        Item hardCodedItem = new Item("Cola", "150", "15");
        String testItemp = daoTest.marshallData(hardCodedItem);

        assertEquals(strToMar, testItemp, "Both strings should be the same");
    }

}