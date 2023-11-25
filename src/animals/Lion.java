package animals;

/**
 *Utilizes general properties of an animal while checking other animals a lion is compatible with
 */
public class Lion extends Animal
{
    public Lion(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();//simpleName gets the name of the class as a String
        return (animalName.equals(Lion.class.getSimpleName())) ;
    }
}
