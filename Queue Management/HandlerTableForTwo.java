
/**
 * Write a description of class HandlerTableForTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HandlerTableForTwo implements Handler
{
  private Handler successor=null;

    /**
     * Constructor for objects of class HandlerTableForTwo
     */
    public HandlerTableForTwo()
    {
        
    }

      public void handleRequest(Guest guest){
          WaitList wt= WaitList.getInstance();
          if(guest.partySize<=2  ){
              System.out.println("-----------------------------------------------");
              AvailableTable tableUsed=null;
              if( guest.alreadyServed==false){ 
                  for(AvailableTable at:wt.availableTables){
                      if (at.tableSize==2){
                           System.out.println("-----------------------------------------------");
                            System.out.println("Handling party of two or less");
                            System.out.println("Giving Table to "+guest.name+", party of"+ guest.partySize);
                            guest.alreadyServed=true;
                            tableUsed=at;
                        }
                    }
                    if(guest.alreadyServed==false){
                        
                            System.out.println("Please ask "+guest.name+" to wait");
                       
                    }else{
                        wt.availableTables.remove(tableUsed);
                    }
              }
              else if(wt.guestQueue.peek().equals(guest)){
                wt.guestQueue.remove();
                }
        }else{
        if(successor!=null){
        successor.handleRequest(guest);
        }
        }
    } 
        
        
    public void setSuccessor(Handler next){
        this.successor=next;
    }
}
