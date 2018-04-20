
/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{

    public static void main(String[] args){
        WaitList wt = WaitList.getInstance();
        //
        
        Handler h1 = new HandlerTableForTwo();
        Handler h2 = new HandlerTableForFive();
        Handler h3 = new HandlerTableForSixOrMore();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        Guest g1 = new Guest(5,"Divya", "123567890");
        wt.addGuest(g1);
        Guest g2 = new Guest(2,"Arshiya", "1242351");
         wt.addGuest(g2);
        Guest g3 = new Guest(6,"Uttara", "2534634");
         wt.addGuest(g3);
         
         Guest g4= new Guest(4, "John Doe", "1281246236");
         g4.wantToLeave=true;
         
   
       AvailableTable table1 = new AvailableTable(2);
       AvailableTable table2 = new AvailableTable(4);
       wt.addAvailableTable(table1);
       wt.addAvailableTable(table2);
       
            System.out.println(wt);
       
       for(Guest g: wt.guestQueue){
           h1.handleRequest(g);
            System.out.println(wt);
        }
        //System.out.println(wt);
        
    }
}
