import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents a simple server that listens for incoming client connections,
 * receives a message from the client, and prints the received message.
 */
public class MyServer {

    /**
     * The main method of the server program.
     * It listens for incoming client connections, receives messages from clients,
     * and prints the received messages.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 10000
            ServerSocket ss = new ServerSocket(10000);

            // Accept an incoming client connection
            Socket s = ss.accept(); // establishes connection

            // Create a data input stream to receive data from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Read the received message from the client
            String str = dis.readUTF();
            System.out.println("message = " + str);

            // Close the server socket
            ss.close();
        } catch (Exception e) {
            // Print any exceptions that occur during the process
            System.out.println(e);
        }
    }
}
