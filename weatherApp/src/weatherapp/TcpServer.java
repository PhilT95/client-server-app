
package weatherapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
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
    
    public TcpServer(int port, String name) throws Exception
    {
        this.port = port;
        this.servername = name;
        this.serverSocket = new ServerSocket(port); 
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
    
   
    
    
    
    
    
    
    
}
