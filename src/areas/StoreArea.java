package areas;

import java.util.HashMap;
import java.util.Set;

/**
 *  Class acting as the Model for Zoo ,i.e. stores the different areas in the zoo as a Hashmap
 *  Implements methods to add, remove and get ids of the Areas in the zoo
 */
public class StoreArea
{
    private HashMap<Integer,IArea> areaData = new HashMap<>(); // hashmap is used to store the areas in the zoo with unique ids
    private int idGen;// unique id for each area

    public StoreArea () // constructor ensures an Entrance with id 0 is always present in the zoo
    {
        Entrance mainEntrance= new Entrance();
        areaData.put(0, mainEntrance);
        idGen=0;
    }

    public void addData(IArea area) // adds an area to the zoo (hashmap storing the areas in the zoo)
    {
        idGen++;
        areaData.put(idGen,area);
    }

    public boolean removeData(int id) // removes an area from the zoo if that area exists
    {
        if (idExists(id))
        {
            IArea area = areaData.get(id);
            areaData.remove(id);
            return getId(area) == -1; // returns true if successfully removed
        }
        else
        {
            return false;
        }
    }

    public int getId (IArea area) // returns the key storing a particular area
    {
        for (int i :areaData.keySet())
        {
            if (areaData.get(i).equals(area))
            {
                return i;
            }
        }
        return -1; // returns -1 if the area does not exist
    }

    public Set<Integer> getIdList()
    {
      return areaData.keySet();
    }

    public IArea getAreaName(int id)
    {
        return areaData.get(id);
    }

    public boolean idExists(int id) //checks whether an id exists in the hashmap storing the areas
    {
        return (areaData.containsKey(id));
    }

}
