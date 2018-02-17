
public class Human {

	/***
	**************** Tips ****************
	* Jobs: Hunter, Warrior, Mage
	* Weapons and Skills:
	* -----------------------------------
	* | Default Blade | Slash |
	* | Fire Blade | Fire Slash |
	* | Ice Blade | Ice Slash |
	* -----------------------------------
	* | Default Bow | Arrow |
	* | Fire Bow | Fire Arrow |
	* | Ice Bow | Ice Arrow |
	* -----------------------------------
	* | Default Staff | Arcane Missiles |
	* | Fire Staff | Fireball |
	* | Ice Staff | Frostbolt |
	* -----------------------------------
	*
	*/
	private String name ;
	public final static int FIRE_BOW = 0x01 ;
	public final static int ICE_BOW = 0x02 ;

	public Human () {
	}


	public void setName (String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void attack () {
		System.out.println( "Fist Attack!" ) ;
	}

	public void weapon_too_big() {
		System.out.println("this weapon is too 'big' to take..");
		System.exit(1);
	}

}