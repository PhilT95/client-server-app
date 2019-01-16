
package weatherapp;

import java.io.*;
import java.net.*;
/**
 *
 * @author phil
 */
public class TcpClient 
{
    Socket clientSocket;
    String name;
    int port;
    
    public TcpClient(int port, String name) throws Exception
    {
        this.port = port;
        this.name = name;
        this.clientSocket = new Socket("localhost", port);
        
    }
    
    public void sendMessage() throws IOException
    {
        System.out.println("Please enter a valid city:");
        BufferedReader messageToSend = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = messageToSend.readLine();
        outToServer.writeBytes(message + '\n');
        System.out.println("WEATHER STATUS: "  + inFromServer.readLine());
    }
    
    
    
}
