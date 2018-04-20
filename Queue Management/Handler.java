
/**
 * Write a description of interface Handler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Handler
{
    void handleRequest(Guest guest);
    void setSuccessor(Handler next);
    
}
