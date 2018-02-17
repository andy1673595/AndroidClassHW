
public class Mage extends Human {
	public String[] skills = {"Arcane Missiles","Fireball","Frostbolt"};
	public int weapon ;

	/*******No input...so use default Name and weapon******/
	public Mage() {
		super.setName("unknown");
		weapon = 0X00;
	}


	/*******Get name and use default weapon******/
	public Mage(String name) {
		super.setName(name);
		weapon = 0X00;
	}


	/*******Get weapon and use default name******/
	public Mage(int weapon) {
		super.setName("unknown");
		if(weapon < 0) this.weapon = 0;
		//number of weapon is too big
		else if(weapon > 2) super.weapon_too_big();

		else this.weapon = weapon;
	}


	/*******Get weapon and name******/
	public Mage(String name,int weapon) {
		super.setName(name);
		if(weapon < 0) this.weapon = 0;
		//number of weapon is too big
		else if(weapon > 2) super.weapon_too_big();

		else this.weapon = weapon;
	}

	//attack function
	public void attack() {
		System.out.printf( "%s(Mage) use %s attack!!%n",super.getName(),skills[weapon] ) ;
	}
}