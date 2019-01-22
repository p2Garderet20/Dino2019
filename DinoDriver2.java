
import java.util.Scanner;

/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        // int[] nums = new int[10];
        // System.out.println(nums[0]);

        // for(int i =0; i < nums.length; i++)
        // {
        // nums[i] = 10+i;

        // }
        // for(int i =0; i < nums.length; i++)
        // {
        // System.out.println(nums[i]);
        // }

        // for(int answer: nums)
        // {
        // System.out.println(answer);
        // }
        System.out.println("How many dinos? ");
        Dinosaur[] pop = new Dinosaur[s.nextInt()];
        for(int i = 0; i < (int)(pop.length*.33); i++)
        {
            pop[i] = new Triceratops();
        }
        for(int i = (int)(pop.length*.33); i < (int)(pop.length*.66); i++)
        {
            pop[i] = new Stego();
        }
        for(int i = (int)(pop.length*.66); i < pop.length; i++)
        {
            pop[i] = new TRex();
        }

        for(int i = 0; i< pop.length; i++)
        {
            int rand = (int)(Math.random()*30);

            for(int a = 0; a < rand; a ++)
            {
                pop[i].ageUp();
            }
            //System.out.println(pop[i]);
        }

        int winCount = 0, battleCount = 0, rndCount = 0; //Count variables for the battles
        int deadAfter = 0, deadBefore = 0,  deadRnd = 0; //Variables to determine dead per round
   
        while(DinoDriver2.getLivingDinos(pop) >= 2)
        {   
            deadBefore = pop.length -  DinoDriver2.getLivingDinos(pop);
           
            for(Dinosaur d: pop)//Haves dinosaurs attack eachother
            {
                if((d.getIsAlive() == true) && (DinoDriver2.getLivingDinos(pop) >= 2))// The dinosaur d (attacker) is alive 
                //and there are more than 2 living dinosaurs, 
                {
                    Dinosaur Defender =  DinoDriver2.getDefender(pop, d);
                    battleCount++;
                    if(d.attack(Defender) == true)
                    {
                        winCount++;
                    }
                }

            }
            
            deadAfter = pop.length -  DinoDriver2.getLivingDinos(pop);
            deadRnd = deadAfter - deadBefore;
            rndCount++;
            System.out.println("End of round " + rndCount+ "."+ " Killed this round: " + deadRnd);//" Total living: "+ DinoDriver2.getLivingDinos(pop) + " Total dead " + deadAfter); 
        }
        for(Dinosaur d: pop)
        {
            //if(deadCount == pop.length-1)
            //{
                if(d.getIsAlive() == true)
                {
                    System.out.println("Total battles: "+ battleCount+ " Total living: "+ DinoDriver2.getLivingDinos(pop)+ " This boi won: " + d.toString());
                }
            //}

        }

    }

    public static Dinosaur getDefender(Dinosaur[] p,Dinosaur att)//Gets a suitable defender so that the 
    //attacker isn't the defender and that the defender isn't dead
    {
        Dinosaur def = att;

        do
        {
            int rand = (int)(Math.random()*p.length);
            def = p[rand];
        } while(def == att || def.getIsAlive() != true);

        return def;
    }

    public static int getLivingDinos(Dinosaur[] p ) //Returns number of living dinosaurs
    {
        int living = 0;
        for(Dinosaur d: p)
        {
            if(d.getIsAlive() == true)
            {
                living++;
            }
        } 
        return living;
    }

} 
