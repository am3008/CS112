public class Monster
{
    private int damage;
    private int health;
    private int dexterity;
  
    public Monster()
    {
      damage = (int) (Math.random()*5)+1;
      health = (int) (Math.random()*6)+5;
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
    public void takeDamage(int damage)
    {
      health-=damage;
  
    }
    
    
}
