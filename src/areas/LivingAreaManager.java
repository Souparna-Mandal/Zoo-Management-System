package areas;

import animals.Animal;
import zoo.Codes;

import java.util.ArrayList;

/**
 * CLass Storing data relevant to the 3 habitats- Aquarium, Cage, Enclosure
 * It stores the habitat size and the animals in each habitat as an Arraylist.
 * It includes methods to add animals to a habitat and return a list of animals for a given habitat
 */
public class LivingAreaManager extends AllAreaManager
{

    protected ArrayList<Animal> animalObject ; // Arraylist to store the animals in a habitat
    protected int noOfAnimal =-1;              // count of animals in a habitat
    protected int habitatSize;                 // size of the Habitat

    public LivingAreaManager (int habitatSize)
    {
        animalObject=new ArrayList<>();
        this.habitatSize=habitatSize;
    }

    public boolean sharingAnimalCompatibility(Animal animal) // checks whether the animal being added to the habitat
    {                                                        // is compatible with rest of the animals there
         for (Animal value : animalObject)
            {
                if (!(animal.isCompatibleWith(value)))
                {
                    return true; // returns True if it is NOT COMPATIBLE
                }
            }
        return false; // returns false if it is COMPATIBLE
    }

    public byte addAnimal(Animal animal) // adds the given animal to the arraylist storing animals in a habitat
    {
        if (noOfAnimal ==habitatSize-1)
        {
            return Codes.HABITAT_FULL;
        }

        if (sharingAnimalCompatibility(animal))
        {
            return Codes.INCOMPATIBLE_INHABITANTS;
        }

        else
        {
            animalObject.add(animal);
            noOfAnimal++;
            return Codes.ANIMAL_ADDED;
        }
    }
    public ArrayList<Animal> getAnimal()
    {
        return animalObject;
    }

}
