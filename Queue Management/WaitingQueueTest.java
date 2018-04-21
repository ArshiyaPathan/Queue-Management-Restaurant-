

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WaitingQueueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WaitingQueueTest
{
    /**
     * Default constructor for test class WaitingQueueTest
     */
     WaitList wt;
    public WaitingQueueTest()
    {
        wt= WaitList.getInstance();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
         wt= WaitList.getInstance();
    }
    
     @Test
    public void testWithAllTablesoccupiedAndCheckingAvailability()
    {
        System.out.println("\n***Test 1: test With All TAbles Occupied and check if user is waitlisted***");
        // when all tables are occupied check table availability for new user coming in
        Handler h1 = new HandlerTableForTwo();
        Handler h2 = new HandlerTableForFour();
        Handler h3 = new HandlerTableForSix();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        Guest g1 = new Guest(5,"Divya", "123567890");
        wt.addGuest(g1);
        Guest g2 = new Guest(2,"Arshiya", "1242351");
         wt.addGuest(g2);
         Guest g3 = new Guest(6,"Uttara", "2534634");
         wt.addGuest(g3); 
         
         
        AvailableTable table1 = new AvailableTable(2);
         AvailableTable table2 = new AvailableTable(4);
          wt.addAvailableTable(table1);
         wt.addAvailableTable(table2);
          System.out.println(wt);
         //for(int i=0;i<wt.guestQueue.size();i++){
          for(Guest g: wt.guestQueue){
           h1.handleRequest(g);
            System.out.println(wt);
        }
        //System.out.println("Number of Available TAbles"+ wt.getNumberOfAvailableTables());
        //assertEquals(0.00,wt.getNumberOfAvailableTables());
        //assertEquals(0, wt.availableTables.size());
       assertEquals(false, g3.alreadyServed); 
    }
    
    @Test
    public void testTocheckIftableAssignedtoUserWhenTableisAvailable(){
        System.out.println("\n***Test 2: test To check If user is properly Assigned table When required Table is available ***");
         Handler h1 = new HandlerTableForTwo();
        Handler h2 = new HandlerTableForFour();
        Handler h3 = new HandlerTableForSix();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        Guest g1 = new Guest(5,"Divya", "123567890");
        wt.addGuest(g1);
        Guest g2 = new Guest(2,"Arshiya", "1242351");
         wt.addGuest(g2);
        AvailableTable table1 = new AvailableTable(2);
         AvailableTable table2 = new AvailableTable(4);
          wt.addAvailableTable(table1);
         wt.addAvailableTable(table2);
         System.out.println(wt);
         for(Guest g: wt.guestQueue){
           h1.handleRequest(g);
            System.out.println(wt);
        }
        assertEquals(true, g2.alreadyServed); 
    
    }
    
    @Test
    public void testTocheckIfNextUserInQueueIsAssignedTableifCapacityOfAvailableTableMatches(){
        System.out.println("\n***Test 3: test To check If Next User InQueue Is Assigned Table if Capacity Of Available Table Matches***");
        Handler h1 = new HandlerTableForTwo();
        Handler h2 = new HandlerTableForFour();
        Handler h3 = new HandlerTableForSix();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        Guest g1 = new Guest(5,"Divya", "123567890");
        wt.addGuest(g1);
        Guest g2 = new Guest(2,"Arshiya", "1242351");
         wt.addGuest(g2);
        AvailableTable table1 = new AvailableTable(2);
         //AvailableTable table2 = new AvailableTable(4);
          wt.addAvailableTable(table1);
         //wt.addAvailableTable(table2);
         System.out.println(wt);
         for(Guest g: wt.guestQueue){
           h1.handleRequest(g);
            System.out.println(wt);
        }
        assertEquals(true, g2.alreadyServed); 
        }
   @Test
    public void testTocheckIfUsersAreAssignedTableBasedOnPriorityndCapacity(){
        System.out.println("\n***Test 4: test To check If Users Are assigned table based on prority as well as capacity***");
         Handler h1 = new HandlerTableForTwo();
        Handler h2 = new HandlerTableForFour();
        Handler h3 = new HandlerTableForSix();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        Guest g1 = new Guest(5,"Divya", "123567890");
        wt.addGuest(g1);
        Guest g2 = new Guest(2,"Arshiya", "1242351");
         wt.addGuest(g2);
        AvailableTable table1 = new AvailableTable(2);
         //AvailableTable table2 = new AvailableTable(4);
          wt.addAvailableTable(table1);
         //wt.addAvailableTable(table2);
         System.out.println(wt);
         for(Guest g: wt.guestQueue){
           h1.handleRequest(g);
            System.out.println(wt);
        }
        assertEquals(false, g1.alreadyServed); 
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
