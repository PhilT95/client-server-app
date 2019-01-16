
package weatherapp;

import java.io.*;

/**
 *
 * @author phil
 */
public class WeatherApp2 {

    
    public static void main(String[] args) 
    {
        try{
            TcpClient client1 = new TcpClient(50000,"one");
            TcpClient client2 = new TcpClient(50000,"two");
            client1.sendMessage();
            client2.sendMessage();
            client1.sendMessage();
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
    }
    
}
