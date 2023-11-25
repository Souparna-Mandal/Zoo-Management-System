package areas;

import java.util.ArrayList;

/**
 * This class contains data relating to the connections between different areas in the zoo
 * That involves storing the adjacent area ids in an arraylist
 * It involves methods to get, add and remove basically manipulate the areas adjacent to a given area.
 */
public class AllAreaManager implements IArea
{
    private ArrayList<Integer> connectedAreas= new ArrayList<>(); //arraylist to store adjacent area ids`to which users can go

    @Override
    public ArrayList<Integer> getAdjacentAreas()
    {
        return connectedAreas;
    }

    @Override
    public void addAdjacentArea(int areaId)
    {
        connectedAreas.add(areaId);// checking of whether areaId exists is done before calling the function
    }

    @Override
    public void removeAdjacentArea(int areaId) // removes the adjacent areaId only if it is presently connected
    {
        if (connectedAreas.contains(areaId))
        {
            connectedAreas.remove(areaId);
        }
    }
}
