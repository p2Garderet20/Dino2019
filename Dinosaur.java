
/**
 * Abstract class Dinosaur - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dinosaur
{
    private String type;
    private int age;
    private String gender;
    private int wins;
    private int battleCount;
    private int health; //0 is dead, and 100 is alive
    private boolean isAlive;
    
    /**
     * Dinosaur contructor--There is no default constructor because there may
     * be multiple types of dinosaurs created, all of which may have different
     * start parameters. However, there needs to be a basic constructor that
     * has only one parameter
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.wins = 0;
        this.health = 10;
        this.battleCount = 0;
        this.isAlive = true;
        //--------------------------------------------------------------------
        // Sets gender of dinosaur randomly---|
        //-------------------------------------------------------------------
        if(Math.random() <= .5)
        {
            this.gender = "M";
        }
        else
        {
            this.gender = "F";
        }

    }
    //-----------------------------------------------------------------------------------------
    // ----------------------------- Getters --------------------------------------------------
    //-----------------------------------------------------------------------------------------

    public String getType()
    {
        return this.type;
    }

    public String getGender()
    {
        return this.gender;
    }

    public int getAge()
    {
        return this.age;
    }

    public int getWins()
    {
        return this.wins;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getBattleCount()
    {
        return this.battleCount;
    }
    
    public boolean getIsAlive()
    {
        return this.isAlive;
    }

    //-------------------------------------------------------------------------------------------
    // --------------------------------- Setters --------------------------------------------------
    //-------------------------------------------------------------------------------------------
    public void setType(String s)
    {
        this.type = s;
    }

    public void setGender(String s)
    {
        this.gender = s;
    }

    public void setAge(int i)
    {
        this.age = this.age + i;
    }

    public void setWins(int i)
    {
        this.wins = i;
    }

    public void setHealth(int i)
    {
        this.health = i;
    }

    public void setBattleCount(int bc)
    {
        this.battleCount = bc;
    }
    
    //-------------------------------------------------------------------------
    // ---------------------------- Methods -----------------------------------
    //-------------------------------------------------------------------------
    /**
     * This method is abstract because while I could make a generic dinosaur 
     * attack method, I might want certain dinosaurs to have more attack 
     * power, or have different combinations have different outcomes
     */
    public abstract boolean attack(Dinosaur def);

    public void ageUp()
    {

        this.age++;
        if(this.age < 10)
        {
            this.setHealth(this.getHealth() + 10);
        }
        else if(this.age >=30)
        {
            this.setHealth(this.getHealth() - 20);
        }
        else if(this.age >=25)
        {
            this.health = this.health - 10;
        }
        this.checkHealth();
    }
    
    public void checkHealth()
    {
        if(this.health <= 0)
        {
            if(this.isAlive == true)//Just died
            {
                System.out.println("\t" + this.toString() + "just died");
            }
            this.isAlive = false;
            this.health = 0;
        }
        else if(this.health > 100)
        {
            this.health = 100;
        }
    }
    
    //Updates the win, battlecount, and health for a single dinosaur object
    public void update(Dinosaur def, boolean winner)
    {
        this.battleCount++;
        def.setBattleCount(def.getBattleCount() + 1);
        if(winner == true)
        {
            this.wins++;
            def.setHealth(def.getHealth() - 20);
            def.checkHealth();//Check health of losing dinosaur
        }
        else 
        {
            def.setWins(def.getWins() + 1);
            this.health -= 20;
            this.checkHealth();
        }
    }

    public String toString()
    {
        String answer = (this.age + " " + this.type +" "+ this.wins + " "+ this.battleCount + " " + this.health);
        return answer;
    }
}
