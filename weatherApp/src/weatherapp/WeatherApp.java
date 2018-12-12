package weatherapp;

import java.io.*;

/**
 *
 * @author Phil Trommer
 */
public class WeatherApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       int port = 50000; 
       try
       {
       TcpServer server = new TcpServer(port, "WetterServer1");
            
       
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
    
}
