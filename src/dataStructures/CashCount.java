package dataStructures;

import java.util.HashMap;
import java.util.Set;

/**
 * This is an implementation of the Zoo's cashMachine
 * It is a model class that stores the money in the cashMachine
 */
public class CashCount implements ICashCount
{
    HashMap<Integer,Integer>poundNotesCoins = new HashMap<>();// the amount of pound notes left/put in the machine
    HashMap<Integer,Integer>penceCoins = new HashMap<>();// the amount of pence coins left/put in the machine
    double Sum;

    public CashCount() // default sets machine to have 0 Cash
    {
        setNrCoins_1pound(0);
        setNrCoins_2pounds(0);
        setNrNotes_5pounds(0);
        setNrNotes_10pounds(0);
        setNrNotes_20pounds(0);
        setNrCoins_10p(0);
        setNrCoins_20p(0);
        setNrCoins_50p(0);
    }

    @Override
    public void setNrNotes_20pounds(int noteCount)
    {
        poundNotesCoins.put(20,noteCount);
    }

    @Override
    public void setNrNotes_10pounds(int noteCount)
    {
        poundNotesCoins.put(10,noteCount);
    }

    @Override
    public void setNrNotes_5pounds(int noteCount)
    {
        poundNotesCoins.put(5,noteCount);
    }

    @Override
    public void setNrCoins_2pounds(int coinCount)
    {
        poundNotesCoins.put(2,coinCount);
    }

    @Override
    public void setNrCoins_1pound(int coinCount)
    {
        poundNotesCoins.put(1,coinCount);
    }

    @Override
    public void setNrCoins_50p(int coinCount)
    {
        penceCoins.put(50,coinCount);
    }

    @Override
    public void setNrCoins_20p(int coinCount)
    {
        penceCoins.put(20,coinCount);
    }

    @Override
    public void setNrCoins_10p(int coinCount)
    {
        penceCoins.put(10,coinCount);
    }

    @Override
    public int getNrNotes_20pounds()
    {
        return poundNotesCoins.get(20);
    }

    @Override
    public int getNrNotes_10pounds() {
        return poundNotesCoins.get(10);
    }

    @Override
    public int getNrNotes_5pounds() {
        return poundNotesCoins.get(5);
    }

    @Override
    public int getNrCoins_2pounds() {
        return poundNotesCoins.get(2);
    }

    @Override
    public int getNrCoins_1pound() {
        return poundNotesCoins.get(1);
    }

    @Override
    public int getNrCoins_50p() {
        return penceCoins.get(50);
    }

    @Override
    public int getNrCoins_20p() {
        return penceCoins.get(20);
    }

    @Override
    public int getNrCoins_10p() {
        return penceCoins.get(10);
    }

    public double totalCash() // returns the total cash inserted in the machine
    {
        Sum=0;
        Set<Integer> pounds=  poundNotesCoins.keySet();// arraylist of denominations of pounds
        Set<Integer> pence=  penceCoins.keySet();// arraylist of denominations of pence
        for(int i=0 ; i<pounds.size();i++)
        {

            Sum=Sum + poundNotesCoins.get(getElement(pounds,i))*getElement(pounds,i);
        }
        for( int i=0; i<pence.size();i++)
        {
            Sum=Sum+ penceCoins.get(getElement(pence,i))*getElement(pence,i)*0.01;
        }
        return Sum;
    }
    public void updateCashCount(CashCount CashInserter)
    {
        this.setNrCoins_1pound(this.getNrCoins_1pound()+ CashInserter.getNrCoins_1pound());
        this.setNrCoins_2pounds(this.getNrCoins_2pounds()+ CashInserter.getNrCoins_2pounds());
        this.setNrNotes_5pounds(this.getNrNotes_5pounds()+ CashInserter.getNrNotes_5pounds());
        this.setNrNotes_10pounds(this.getNrNotes_10pounds()+ CashInserter.getNrNotes_10pounds());
        this.setNrNotes_20pounds(this.getNrNotes_20pounds()+ CashInserter.getNrNotes_20pounds());
        this.setNrCoins_10p(this.getNrCoins_10p()+ CashInserter.getNrCoins_10p());
        this.setNrCoins_20p(this.getNrCoins_20p()+ CashInserter.getNrCoins_20p());
        this.setNrCoins_50p(this.getNrCoins_50p()+ CashInserter.getNrCoins_50p());

    }
    public int getElement(Set<Integer> set, int index)
    {
        int count=0;
        for (int i : set)
        {
            if (count==index)
            {
                return i;
            }
            count++;
        }
        return 0; // index not found
    }
}
