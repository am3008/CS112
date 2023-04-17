public class Wizard
{
    private int damage;
    private int health;
    private int dexterity;
    
    public Wizard()
    {
        damage = (int) (Math.random()*5)+4; 
        health = (int) (Math.random()*13)+12;

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
    
}
    
