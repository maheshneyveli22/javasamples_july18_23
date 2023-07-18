package network;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
/**
 * @author Crunchify.com
 *
 */
public class IsSocketAliveUtility {
    public static void main(String[] args) {
        // Run Apache Tomcat server on Port 8080 in Eclipse to see success
        // result
        log(isSocketAliveUitlity("localhost", 8443));
        log(isSocketAliveUitlity("localhost", 8445));
        log(isSocketAliveUitlity("localhost", 8099));
        log(isSocketAliveUitlity("localhost", 4205));
        log(isSocketAliveUitlity("bookingdb1qa.aeu1.ei", 5432));
        log(isSocketAliveUitlity("https://txnsvc-dev-ssl.dr1.ei/txnsvc/web-services/GlobalCompanyIdentifierService", 80));
             //http://txnsvc-dev.dr1.ei:8121/txnsvc/web-services/GlobalCompanyIdentifierService


        Class fromClass=PortUsageTester.class;
        Class toClass=URLHeaderFields.class;

        System.out.println("Maheshhh"+ (fromClass==fromClass));


        log(isSocketAliveUitlity("www.google.com", 80));
        // Now change port to 8081 and you should see failure

    }
    /**
     * Crunchify's isAlive Utility
     *
     * @param hostName
     * @param port
     * @return boolean - true/false
     */
    public static boolean isSocketAliveUitlity(String hostName, int port) {
        boolean isAlive = false;
        // Creates a socket address from a hostname and a port number
        SocketAddress socketAddress = new InetSocketAddress(hostName, port);
        Socket socket = new Socket();
        // Timeout required - it's in milliseconds
        int timeout = 2000;
        log("hostName: " + hostName + ", port: " + port);
        try {
            socket.connect(socketAddress, timeout);
            socket.close();
            isAlive = true;
        } catch (SocketTimeoutException exception) {
            System.out.println("SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println(
                    "IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
        }
        return isAlive;
    }
    // Simple log utility
    private static void log(String string) {
        System.out.println(string);
    }
    // Simple log utility returns boolean result
    private static void log(boolean isAlive) {
        System.out.println("isAlive result: " + isAlive + "\n");
    }
}