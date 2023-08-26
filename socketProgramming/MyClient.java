import java.io.DataOutputStream;
import java.net.Socket;

/**
 * This class represents a simple client that establishes a connection to a server
 * and sends a message to it.
 */
public class MyClient {

    /**
     * The main method of the client program.
     * It establishes a connection to a server and sends a message to it.
     * 
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            // Establish a socket connection to the server
            Socket s = new Socket("localhost", 10000);

            // Create a data output stream to send data to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Send a message to the server
            dout.writeUTF("Hello Server");
            dout.flush();

            // Close the data output stream and the socket
            dout.close();
            s.close();

        } catch (Exception e) {
            // Print any exceptions that occur during the process
            System.out.println(e);
        }
    }
}
