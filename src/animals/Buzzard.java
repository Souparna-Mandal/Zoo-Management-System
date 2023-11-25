package animals;

/**
 *Utilizes general properties of an animal while checking other animals a buzzard is compatible with
 */
public class Buzzard extends Animal
{
    public Buzzard(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Buzzard.class.getSimpleName())) ;
    }
}
