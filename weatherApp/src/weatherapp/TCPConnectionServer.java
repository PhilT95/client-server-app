
package weatherapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author phil
 */
public class TCPConnectionServer

{
    private Socket socket;
    private BufferedReader inMessage;
    private DataOutputStream outMessageStream;
    private String clientName;
    private String serverName;
    
    public TCPConnectionServer(Socket socket, String client, String server) throws IOException
    {
        this.clientName = client;
        this.serverName = server;
        this.socket = socket;
        this.inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outMessageStream = new DataOutputStream(socket.getOutputStream());
    }
    
    public void sendMessage(String message) throws IOException
    {
        outMessageStream.writeBytes(message + '\n');
        outMessageStream.flush();
    }
    
    public void recieveMessage() throws IOException
    {
        String recievedMessage = inMessage.readLine();
        if(recievedMessage != null)
        {
            System.out.println("The following message was send by Client " + clientName + " :\n" + recievedMessage); 
        }
            
    }
    
}
