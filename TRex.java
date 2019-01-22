
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    public TRex()
    {
        super("TRex");
    }
    
    public boolean attack(Dinosaur def)
    {

        //If the defender is a TRex, the attacker has a 55% chance of winning
        if (def.getType().equals("TRex"))
        {
            if(Math.random() <= .55)
            {
                this.update(def, true);
                return true;
            }
            else
            {
                this.update(def, false);
                return false;
            }
            
        }
        //If the defender isn't a TRex, the attacker has a 90% chance of winning
        else
        {
            if(Math.random() <= .9)
            {
                this.update(def, true);
                return true;
            }
            else
            {
                this.update(def, false);
                return false;
            }
        }
        
    }
}
