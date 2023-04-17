import java.util.*;
public class Dungeon
{ 
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        Hero h1 = new Hero();
        Wizard w1 = new Wizard();

        NullRoom x = new NullRoom();
        MonsterRoom m = new MonsterRoom();
        FountainRoom f = new FountainRoom();
        AccessoryRoom a = new AccessoryRoom();
        WeaponRoom w = new WeaponRoom();
        BossRoom b = new BossRoom();
        Room s = new Room();

        Boolean gameOver = false;

        Room[][] dungeon = {{x,x,b,x,x},
                            {x,a,m,a,x},
                            {w,m,f,m,w},
                            {x,a,m,a,x},
                            {x,x,s,x,x}};
        h1.setY(4);
        h1.setX(2);                    
        h1.setLocation(dungeon[h1.getY()][h1.getX()]);

        MyMethods.start();
        h1.moveN();
        h1.setLocation(dungeon[h1.getY()][h1.getX()]);

        while(gameOver == false)
        {
            MyMethods.playerTurn();
            String input = scan.nextLine();
            if(input == "go n")
            {
                h1.moveN();
                h1.setLocation(dungeon[h1.getY()][h1.getX()]);

            }
            else if(input == "go s")
            {
                h1.moveS();
                h1.setLocation(dungeon[h1.getY()][h1.getX()]);
            }
            else if(input == "go w")
            {
                h1.moveW();
                h1.setLocation(dungeon[h1.getY()][h1.getX()]);
            }
            else if(input == "go e")
            {
                h1.moveE();
                h1.setLocation(dungeon[h1.getY()][h1.getX()]);
            }  
            if(h1.getLocation() instanceof MonsterRoom)
            {
                Monster m1 = new Monster();
                System.out.println("You have walked into a room with a monster");
                System.out.println("On each turn, you can choose to do one of the following:");
                System.out.println( "   'attack' ");
                while(m1.getHealth() > 0)
                {   
                    System.out.println("What do you want to do?");
                    String input2 = scan.nextLine();
                    if(input2.equals("attack"))
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

    }

}