package animals;

/**
 *Utilizes general properties of an animal while checking other animals a seal is compatible with
 */
public class Seal extends Animal
{
    public Seal(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Seal.class.getSimpleName())||animalName.equals(Starfish.class.getSimpleName())) ;
    }
}
