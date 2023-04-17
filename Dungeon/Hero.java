public class Hero
{
  private int damage;
  private int health;
  private int dexterity;
  private Room currLocation;
  private int currX;
  private int currY;

  public Hero()
  {
    damage = (int) (Math.random()*6)+1;
    health = (int) (Math.random()*11)+10;
    dexterity = (int) (Math.random()*6)+3;
  }

  public int getDamage()
  {
      return damage;
  }

  public int getHealth()
  {
      return health;
  }

  public int getDexterity()
  {
      return dexterity;
  }

  public void setLocation(Room location)
  {
    currLocation = location;
  }

  public Room getLocation()
  {
    return currLocation;
  }
  public int getX()
  {
    return currX;
  }
  public void setX(int x)
  {
    currX = x;
  }  
  public int getY()
  {
    return currY;
  }  
  public void setY(int y)
  {
    currY = y;
  }
  public void moveN()
  {
    currY-=1;
  }
  public void moveS()
  { 
    currY+=1;
  }
  public void moveW()
  {
    currX-=1;
  }
  public void moveE()
  {
    currX+=1;
  }
  public void takeDamage(int damage)
  {
    health-=damage;

  }
  
  

  

  
    

}
