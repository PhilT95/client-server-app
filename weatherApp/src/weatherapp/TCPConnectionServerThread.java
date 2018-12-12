
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
                connection.recieveMessage();
                connection.sendMessage("SERVER RECIEVED MESSAGE");
            }catch(IOException ex)
            {
                return;
            }
             
            
        } 
    }
    
}
