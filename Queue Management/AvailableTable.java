
/**
 * Write a description of class AvailableTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AvailableTable
{
   
    public int tableSize;

   
    public AvailableTable(int t)
    {
        // initialise instance variables
        tableSize = t;
    }

  @Override
    public String toString(){
       
        return "Table Size : "+tableSize;
    }
}
