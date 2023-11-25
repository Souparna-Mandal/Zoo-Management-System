package animals;

/**
 * You can modify the contents of this class, but you cannot:gi
 * - change the name, parameters or return types of provided methods
 * - change it to an interface or concrete class
 * - remove it entirely
 */
// defines the basic properties to be shared by all animals
public abstract class Animal
{
	/**
	 * @return Returns this animal's given name.
	 */
	protected String nickName;

	public Animal (String nickName) // constructor initializes nickname
	{
		this.nickName= String.valueOf(nickName); //nickName is the nickName given to the Animal
	}

	public String getNickname()
	{
		return nickName;
	}

	/**
	 * Check whether two animals can live together.
	 * @param animal The animal for which to check compatibility with this animal.
	 * @return Returns true for compatible animals and false otherwise.
	 */
	public abstract boolean isCompatibleWith(Animal animal);//  returns whether the passed animal can be in the same habitat
}															//  as the instance of the animal calling it
