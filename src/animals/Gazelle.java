package animals;

/**
 * Utilizes general properties of an animal while checking other animals a gazelle is compatible with
 */
public class Gazelle extends Animal
{
    public Gazelle(String nickName)
    {
        super(nickName);
    } //calls parent class's constructor

    @Override
    public boolean isCompatibleWith(Animal animal)
    {
        String animalName= animal.getClass().getSimpleName();
        return (animalName.equals(Zebra.class.getSimpleName())||animalName.equals(Gazelle.class.getSimpleName())) ;
    }
}
