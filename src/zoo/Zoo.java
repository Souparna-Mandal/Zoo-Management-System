package zoo;

import animals.*;
import areas.*;
import dataStructures.CashCount;
import dataStructures.ICashCount;
import dataStructures.MoneyData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This is the main class that implements the Zoo
 * This is the Controller Class for this project
 * It contains methods and data structures necessary to make the zoo run and uses methods from every class
 */
public class Zoo implements IZoo
{
    StoreArea zooAreas;                 // Instance of StoreArea to access the methods present there without inheriting it
    HashMap<String,String> HABITATANIMALCOMPATIBILITY; // HashMap to store which animal can be in which habitat
    Set<Integer> unreachableArea;       // copy of all the areas unreachable by a visitor
    ArrayList<Integer> areaIdsChecked;  // Arraylist having the list of reachable areas by a visitor
    MoneyData moneyData;                // Instance storing the Entrance Fee of the Zoo
    CashCount machineValues;            // Instance storing the cash inserted into the Cash Machine at the Zoo

    public Zoo() //Constructor initialises variables introduced above
    {
        this.zooAreas= new StoreArea();
        this.moneyData=new MoneyData();
        HABITATANIMALCOMPATIBILITY = new HashMap<>();
        unreachableArea= zooAreas.getIdList();
        areaIdsChecked=new ArrayList<>();

        // Initializing HashMap Storing Animal-Habitat Compatibility

        HABITATANIMALCOMPATIBILITY.put(Buzzard.class.getSimpleName(),Cage.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Parrot.class.getSimpleName(), Cage.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Shark.class.getSimpleName(), Aquarium.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Starfish.class.getSimpleName(), Aquarium.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Seal.class.getSimpleName(), Aquarium.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Lion.class.getSimpleName(),  Enclosure.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Gazelle.class.getSimpleName(), Enclosure.class.getSimpleName());
        HABITATANIMALCOMPATIBILITY.put(Zebra.class.getSimpleName(), Enclosure.class.getSimpleName());
    }

    private boolean checkDuplicate(IArea area) // checks if an area already exists in the zoo
    {
        return zooAreas.getId(area)!=-1;
    }

    @Override
    public int addArea(IArea area)
    {
        if ((checkDuplicate(area)) || area.getClass().getSimpleName().equals("Entrance"))
        // checks that area passed is not already in the zoo or is not Entrance as we can only have unique areas and 1 Entrance
        {
            return -1;
        }
        else
        {
            zooAreas.addData(area);
            return zooAreas.getId(area);
        }
    }

    @Override
    public boolean removeArea(int areaId) //removes an area from the zoo as long as it isn't Entrance
    {
       if (areaId==0)
       {
           return false;
       }
       return zooAreas.removeData(areaId);
    }

    @Override
    public IArea getArea(int areaId)
    {
        return zooAreas.getAreaName(areaId);
    }

    @Override
    public byte addAnimal(int areaId, Animal animal)  //Adds an Animal to a given habitati
    {
        IArea area=getArea(areaId);
        String areaClassName=area.getClass().getSimpleName(); // gets name of the class of which area is an instance
        if (areaClassName.equals("PicnicArea") || areaClassName.equals("Entrance"))
        {
            return Codes.NOT_A_HABITAT;
        }
        LivingAreaManager areaNew= (LivingAreaManager) area; //casting area to LivingAreaManager to access the methods defined there
        if (HABITATANIMALCOMPATIBILITY.get(animal.getClass().getSimpleName()).equals(area.getClass().getSimpleName()))
        // fetches the class name of the given area and animal,thus checks whether it is a compatible habitat for the given animal
        {
           return areaNew.addAnimal(animal);
        }
        else
        {
            return Codes.WRONG_HABITAT;
        }
    }

    @Override
    public void connectAreas(int fromAreaId, int toAreaId) // connects 2 areas in the zoo
    {
        if (fromAreaId!=toAreaId)
        {
            if (zooAreas.idExists(fromAreaId)&&zooAreas.idExists(toAreaId)) // checks if both areaIds exist in the zoo
            {
                getArea(fromAreaId).addAdjacentArea(toAreaId); // adds the toAreaId to the list of adjacent areas for the area with fromAreaId
            }
        }
    }

    @Override
    public boolean isPathAllowed(ArrayList<Integer> areaIds) //checks whether a given path can be taken by a visitor
    {
        for(int i=0 ; i<areaIds.size()-1;i++ )
        {
            ArrayList<Integer> adjacentAreas= getArea(areaIds.get(i)).getAdjacentAreas(); // list of adjacent areas for the area with AreaId i
            if (!(adjacentAreas.contains(areaIds.get(i+1))))
                {
                    return false;
                }
        }
        return true;
    }

    @Override
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) //returns a list of animals visited by a visitor going in the path areaIdsVisited

    {
        ArrayList<String> animalsVisited= new ArrayList<>(); //Arraylist storing the list of animals visited
        if (isPathAllowed(areaIdsVisited))
        {
            for(int i=0 ; i<areaIdsVisited.size();i++ )
            {
                IArea area = getArea(areaIdsVisited.get(i)); // variable area is the ith area visited by the visitor
                if (area instanceof LivingAreaManager)
                {
                    LivingAreaManager areaWithAnimal = (LivingAreaManager) area;//casting to access more methods
                    ArrayList<Animal> animals=areaWithAnimal.getAnimal();
                    for(Animal animal:animals )
                    {
                        animalsVisited.add(animal.getNickname());
                    }

                }
            }
            return animalsVisited;
        }
        else
        {
            return null;
        }

    }

    @Override
    public Set<Integer> findUnreachableAreas()// it returns the list of unreachable areas by a visitor
    {
        ArrayDeque <Integer> tocheckIds = new ArrayDeque<>(); // it is a queue in which you can manipulate data from both sides
        tocheckIds.add(0);// Entrance must be the first place the visitor visits
        areaIdsChecked.add(0);
        removeReachableArea(reachableArea(tocheckIds)); // calls a helper function that uses breadth search algorithm
        return unreachableArea;

    }

    private ArrayList<Integer> reachableArea(ArrayDeque<Integer> queueToCheck)
    {

        Integer firstEle=  queueToCheck.removeFirst();// returns the element  and removes it
        areaIdsChecked.add(firstEle);
        ArrayList<Integer> adjacentArea=getArea(firstEle).getAdjacentAreas();// list of adjacent areas to first element of the queue
        if( !adjacentArea.isEmpty())
        {
            for (Integer i : adjacentArea)
            {
                if (!((queueToCheck.contains(i)) || areaIdsChecked.contains(i))) // termination condition for the search
                {
                    queueToCheck.add(i);
                }
            }
        }
        if (!queueToCheck.isEmpty())
        {
            reachableArea(queueToCheck);
        }
        return areaIdsChecked;
    }

    private void removeReachableArea(ArrayList<Integer> reachableArea)
    {
        unreachableArea.removeAll(reachableArea); // removes reachable areaIds from a list of all areaIds
    }


    @Override
    public void setEntranceFee(int pounds, int pence) // sets the Entrance Fee for the Zoo which can be 0
    {
        moneyData.setEntranceFee(pounds,pence);
    }

    @Override
    public void setCashSupply(ICashCount coins) //sets the amount of Cash in the CashMachine
    {
        machineValues=(CashCount)coins;// casting

    }
    @Override
    public ICashCount getCashSupply() //gets the amount of Cash in the CashMachine
    {
        return machineValues;
    }

    @Override
    public ICashCount payEntranceFee(ICashCount cashInserted)
    {
        CashCount cashInMachine= (CashCount)getCashSupply(); // casting to CashCount to use other methods

        double totalCashInMachine=(cashInMachine).totalCash();
        double totalCashInserted=((CashCount)cashInserted).totalCash();
        double entranceFee= moneyData.getEntranceFee();
        if (totalCashInserted==entranceFee)
        {
            cashInMachine=UpdateCashSupply((CashCount) cashInMachine,(CashCount) cashInserted);
            return new CashCount(); // it has all the notes as 0
        }
        if (totalCashInserted < entranceFee) // returns the inserted cash if it's not enough to pay for a ticket
        {
            return cashInserted;
        }
        // does not check the case that there is enough cash, but not the right combination of notes to return it.
        if ((totalCashInserted+totalCashInMachine)<(totalCashInserted-entranceFee)) // not enough cash to give change
        {
            return cashInserted;
        }


        return null;
    }

    public CashCount UpdateCashSupply(CashCount cashInMachine, CashCount cashInserted)
    {
        cashInMachine.updateCashCount(cashInserted);
        return cashInMachine;
    }



}
