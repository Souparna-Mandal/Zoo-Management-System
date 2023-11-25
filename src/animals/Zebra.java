package animals;

/**
 *Utilizes general properties of an animal while checking other animals a zebra is compatible with
 */
public class Zebra extends Animal
{
    public Zebra(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Zebra.class.getSimpleName())||animalName.equals(Gazelle.class.getSimpleName())) ;
    }
}
