package zoo;

import areas.Cage;
import areas.Enclosure;
import areas.PicnicArea;
import dataStructures.*;

public class Test
{

    public static void main(String[] args)
    {
        Zoo zoo= new Zoo();
        zoo.addArea(new PicnicArea());
        zoo.addArea(new Enclosure(10));
        zoo.addArea(new Cage(3));
        zoo.addArea((new Cage(3)));
        zoo.addArea((new Cage(3)));
        zoo.addArea((new Cage(3)));
        zoo.addArea((new Cage(3)));
        zoo.addArea((new Cage(3)));

        zoo.connectAreas(0,1);
        zoo.connectAreas(0,2);
        zoo.connectAreas(1,3);
        zoo.connectAreas(2,3);
        zoo.connectAreas(3,4);
        zoo.connectAreas(4,2);
        zoo.connectAreas(4,1);
        zoo.connectAreas(1,5);
        zoo.connectAreas(2,5);
        zoo.connectAreas(0,6);
        zoo.connectAreas(5,7);
        zoo.connectAreas(3,7);
        zoo.connectAreas(5,6);
        System.out.println(zoo.findUnreachableAreas());
        ICashCount cashSupply= new CashCount();
        ICashCount cashInserterd = new CashCount();
        cashInserterd.setNrCoins_1pound(1);
        zoo.setEntranceFee(1,0);
        zoo.setCashSupply(cashSupply);
        System.out.println(zoo.payEntranceFee(cashInserterd));







    }
}
