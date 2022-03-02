package app;


import control.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    //!!!!!!!!
    //Possible future code transformation, wasn't done for time reasons.
    //Instead of instantiating some objects of different classes through the code, I could have given them as parameters like I did in the calc class with the view object.
    //Then I would add the proper dependances in the beans as I did in the calc one. The conversion was left out.
    //!!!!!!!!
    public static void main(String[] args) {
        // write your code here
        //OLD CODE
       /* VendingMachineController controller = new VendingMachineController();


        controller.startMachine();
*/

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller =
                ctx.getBean("controller", VendingMachineController.class);
        controller.startMachine();




        //KNOWN PROBLEMS!!! :
        /*
         * IF THE USER BUYS THE LAST ITEM, THE VALUE OF STOCK LEFT TURNS TO 0, AND THE ITEMS FROM THE ARRAYLIST ARE WRITTEN TO THE FILE.
         * THE NEXT TIME THE PROGRAM RUNS, SINCE THAT ITEM HAS 0 LEFT IT ISN'T VISIBLE, NOR IS IT IN THE ARRAY.
         * THE PROGRAM OVERWRITES THE FILE WITH THE DATA FROM THE ARRAY, AND SINCE THE ITEM THAT ORIGINALLY HAD 0 AND WASN'T IN THE ARRAY, THE ITEM DISAPPEARS.
         * -----
         * THE ARRAYLIST ONLY REGISTERS THE ITEMS THAT HAVE A >0 STOCK LEFT, BECAUSE IF IT REGISTERED ALL OF THEM AND DISPLAYED ONLY THE ONES WITH THE STOCK, THERE WAS A BIG ISSUE WITH
         * THE INDEXING IN THAT ARRAY.
         * FOR EXAMPLE IF THERE WERE FOUR ITEMS : i1: 13, i2:0, i3: 1, i4:10
         * THE ARRAY WOULD TAKE THEM ALL IN BUT IT WOULDN'T DISPLAY THEM ALL.
         * THE USER THEN WAS SHOWN THE THREE AVAILABLE OPTIONS AND IF THEY CHOOSE 2(THINKING THEY WERE GOING TO GET I3, THEY WERE GETTING AN ERROR BECAUSE THE INDEX WAS SHOWING I2 (INDEX = CHOICE -1))
         * -----
         * POSSIBLE FIX: NOT IMPLEMENTED DUE TO PRIORITY OF TASKS TO DO.
         * CHECK IF THE VALUE OF STOCK LEFT IS >0. IF IT IS ADD THE OBJECT TO THE ARRAYLIST.
         * IF IT IS <=0, ADD THE OBJECT TO A NEW ARRAYLIST AND ONCE WE ARE DONE READING FROM THE FILE, ZIP THE LISTS TOGETHER, STILL ONLY SHOWING THE ITEMS WITH STOCK >0
         * THAT WAY THE ITEMS ARE WRITTEN FROM AND TO THE FILE REGARDLESS THEIR STOCK.
         *
         * */



    }
}