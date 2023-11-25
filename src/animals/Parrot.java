package animals;

/**
 *Utilizes general properties of an animal while checking other animals a parrot is compatible with
 */
public class Parrot extends Animal
{
    public Parrot(String nickName) //calls parent class's constructor
    {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Parrot.class.getSimpleName())) ;
    }
}
