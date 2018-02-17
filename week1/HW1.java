import static java.lang.System.out;

public class HW1 {
    public static void main(String[] args) {

        Hunter player1 = new Hunter("John" , 2);
		player1.attack();

        Mage player2 = new Mage(0);
        player2.attack();

        //test warrior specail attack
        Warrior player3 = new Warrior("Saitama teacher", 999);
        player3.attack();

        //test undefined weapon
        Hunter player4 = new Hunter("John" , -1);
        player4.attack();

        //test too big weapon
        Hunter player5 = new Hunter("QQ",3);
        player5.attack();

    }
}