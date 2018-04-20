
/**
 * Write a description of class HandleTableForMore here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HandlerTableForSixOrMore implements Handler
{
   private Handler successor=null;
   
  
    public void handleRequest(Guest guest){
        WaitList wt= WaitList.getInstance();
          if(guest.partySize>5 ){
              System.out.println("-----------------------------------------------");
              AvailableTable tableUsed=null;
                if( guest.alreadyServed==false){ 
                    
                       for(AvailableTable at:wt.availableTables){
                      if (at.tableSize==6){
                          
                            System.out.println("Handling party of more than 5");
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
