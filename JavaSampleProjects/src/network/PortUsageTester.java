package network;

import java.net.*;
import java.io.*;

public class PortUsageTester {
    public static void main(String[] args) {
        Socket Skt;
        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 39000; i <=39001; i++) {
            try {
                System.out.println("Looking for "+ i);
                Skt = new Socket(host, i);
                System.out.println("There is a server on port " + i + " of " + host);
            } catch (UnknownHostException e) {
                System.out.println("Exception occured"+ e);
                break;
            } catch (IOException e) {}
        }
    }
}