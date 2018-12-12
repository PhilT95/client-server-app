
package weatherapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author phil
 */
public class TCPConnectionClient
{
    public Socket socket;
    int port;
    
    public TCPConnectionClient(int port) throws Exception
    {
        this.port = port;
        this.socket = new Socket("localholst", port);
    }
}
