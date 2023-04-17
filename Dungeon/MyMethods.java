import java.util.*;
public class MyMethods {

    public static void start()
    {
        System.out.println("Hi, welcome to this Dungeon!");
    }

    public static void move()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Where would you like to move?");
        String input = scan.nextLine();
        System.out.println(input);
        scan.close();

    }

    
    public static void playerTurn()
    {
        System.out.println("It is you turn.");
        System.out.println("On each turn, you can choose to do one of the following:");
        System.out.println( " - go <dir>, where <dir> is one of n, s, e, or w");
    }

    public static void battle(Hero h1)
    {
        Monster m1 = new Monster();
        System.out.println("You have walked into a room with a monster");
        System.out.println("On each turn, you can choose to do one of the following:");
        System.out.println( "   'attack' ");
        while(h1.getHealth() > 0 || m1.getHealth() > 0)
        {   
            System.out.println("What do you want to do?");
            String input = Dungeon.scan.nextLine();
            if(input.equals("attack"))
            {
                m1.takeDamage(h1.getDamage());
                h1.takeDamage(m1.getDamage());
                System.out.println("Your health is: " + h1.getHealth());
                System.out.println("Monster health is: " + m1.getHealth());
            }
            else{
                System.out.println(input + "is not a valid input");
            }
        }

    }



      
}
