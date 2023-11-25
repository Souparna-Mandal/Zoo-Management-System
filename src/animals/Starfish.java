package animals;

/**
 *Utilizes general properties of an animal while checking other animals a starfish is compatible with
 */
public class Starfish extends Animal
{
    public Starfish(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Starfish.class.getSimpleName())||animalName.equals(Shark.class.getSimpleName())||animalName.equals(Seal.class.getSimpleName())) ;
    }
}
