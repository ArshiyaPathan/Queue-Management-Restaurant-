import java.util.*;
/**
 * Write a description of class WaitList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaitList
{
    // instance variables - replace the example below with your own
    public Queue<Guest> guestQueue;
    public ArrayList<AvailableTable> availableTables;
    public static WaitList waitList;

    /**
     * Constructor for objects of class WaitList
     */
    private WaitList()
    {
        // initialise instance variables
       guestQueue= new LinkedList<>();
       availableTables= new ArrayList<>();
       
    }
    
    public static WaitList getInstance(){
        if(waitList==null){
            waitList= new WaitList();
        }
        return waitList;
    }

  
    public void addGuest(Guest a)
    {
      guestQueue.add(a);
    }
    
     public void addAvailableTable(AvailableTable a)
    {
      availableTables.add(a);
    }
      public void removeAvailableTable(AvailableTable a)
    {
      availableTables.remove(a);
    }
    
    
    @Override
    public String toString(){
        return "GUEST QUEUE"+ guestQueue.toString()+"\n"+" Available Tables "+  availableTables.toString();
    }
}
