package dataStructures;

import java.util.ArrayList;

/**
 * This Class sets the Zoo's entrance fee
 * It is a model class that stores entrance fee for the zoo
 */
public class MoneyData {
    ArrayList<Integer> entranceFee;

    public MoneyData()
    {
        entranceFee = new ArrayList<>(2);
    }// a length 2 Arraylist is used to store the entrance fee
    public void setEntranceFee(int pounds, int pence)// if it is a open day pounds and pence will be 0
    {
        if (pounds >= 0) {
            entranceFee.add(pounds);
        }
        if (pence <= 100 && pence >= 0) {
            entranceFee.add(pence);
        }
    }
    public double getEntranceFee()
    {
        return entranceFee.get(0)+entranceFee.get(1)*0.01;
    }
}
