
package weatherapp;

import java.io.*;
/**
 *
 * @author phil
 */
public class TCPConnectionServerThread implements Runnable
{
    private TCPConnectionServer connection;    
    public int ID;
    
    TCPConnectionServerThread (int connectionID, TCPConnectionServer connection)
    {
        this.ID = connectionID;
        this.connection = connection;
        
        Thread t = new Thread(this, "a");
        t.start();
        
    }
    
    public void run()
    {
        System.out.println("Connection " + ID + " established!");
        while(true)
        {   
            
            try
            {
                String tmp = connection.recieveMessage();
                connection.sendMessage("The weather is " + tmp);
            }catch(IOException ex)
            {
                return;
            }
             
            
        } 
    }
    
}
