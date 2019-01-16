
package weatherapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author phil
 */
public class TcpServer 
{
    private int port;
    ServerSocket serverSocket;
    String servername;
    private int IDCounter = 0;
    public static HashMap<String, String> weatherData = new HashMap<String,String>();
    
    public TcpServer(int port, String name) throws Exception
    {
        this.port = port;
        this.servername = name;
        this.serverSocket = new ServerSocket(port);
        weatherData.put("Amsterdam", getRngWeather());
        weatherData.put("Berlin", getRngWeather());
        weatherData.put("Gummersbach", getRngWeather());
        weatherData.put("New York", getRngWeather());
        weatherData.put("Peking", getRngWeather());       
        startServer();
       
    }
    
    public void startServer() throws Exception
    {
        while(true)
        {
        try{
            Socket connectionSocket = serverSocket.accept();
            createConnection(connectionSocket);          
        }catch(java.net.SocketException ex)
        {
            System.out.println("Verbindung fehlerhaft");
        }
        }
     
    }
    
    public void createConnection(Socket socket) throws Exception
    {
        TCPConnectionServer connection = new TCPConnectionServer(socket, Integer.toString(IDCounter), servername);
        new TCPConnectionServerThread(IDCounter, connection);
        
        
        IDCounter++;
    }
    
    private String getRngWeather()
    {
        String[] weather = {
            "Sunny",
            "Rainy",
            "Grey",
            "Cold",
            "Hot",
            "Apocalyptic"
        };
        Random r = new Random();
        return weather[r.nextInt(weather.length)];
    }
    
   
    
    
    
    
    
    
    
}
