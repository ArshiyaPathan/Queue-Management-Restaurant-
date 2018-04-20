
/**
 * Write a description of class Guest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Guest
{
    // instance variables - replace the example below with your own
    public int partySize;
    public String name;
    public String contactNumber;
    public boolean wantToLeave;
    public boolean alreadyServed;

    /**
     * Constructor for objects of class Guest
     */
    public Guest(int partySize,String name,String contactNumber)
    {
       this.partySize=partySize;
       this.name=name;
       this.contactNumber= contactNumber;
       wantToLeave= false;
       alreadyServed=false;
    }
    
    @Override
    public String toString(){
        if(alreadyServed==true){
            return "";
        }
        
        return "Name : "+name+", Party of "+partySize;
    }

    
}
