
public class Warrior extends Human {
	public String[] skills = {"Slash","Fire Slash","Ice Slash","a VERY LARGE item to"};
	public int weapon ;

	/*******No input...so use default Name and weapon******/
	public Warrior() {
		super.setName("unknown");
		weapon = 0X00;
	}


	/*******Get name and use default weapon******/
	public Warrior(String name) {
		super.setName(name);
		weapon = 0X00;
	}


	/*******Get weapon and use default name******/
	public Warrior(int weapon) {
		super.setName("unknown");
		if(weapon < 0) this.weapon = 0;
		//number of weapon is too big
		else if(weapon > 2) this.weapon = 3;

		else this.weapon = weapon;
	}


	/*******Get weapon and name******/
	public Warrior(String name,int weapon) {
		super.setName(name);
		if(weapon < 0) this.weapon = 0;
		//number of weapon is too big
		else if(weapon > 2) this.weapon = 3;

		else this.weapon = weapon;
	}

	//attack function
	public void attack() {
		System.out.printf( "%s(Warrior) use %s attack!!%n",super.getName(),skills[weapon] ) ;
	}
}