package animals;

/**
 *Utilizes general properties of an animal while checking other animals a shark is compatible with
 */
public class Shark extends Animal
{
    public Shark(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }
    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Shark.class.getSimpleName())||animalName.equals(Starfish.class.getSimpleName())) ;
    }
}
