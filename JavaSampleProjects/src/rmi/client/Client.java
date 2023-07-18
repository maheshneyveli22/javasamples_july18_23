package rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try{


            // Locate the registry: this is the registry where server side objects are registered in server side
            Registry registry= LocateRegistry.getRegistry("10.249.5.23",9100);

            //get the reference of exported object from RMI registry
            // we will get the reference via lookup by using the name space, which we gave while binding in server eg:     registry.bind("L",stub1);
          Product laptop =  (Product)registry.lookup("L");
            Product mobile =  (Product)registry.lookup("M");
            Product charger =  (Product)registry.lookup("P");
            Product bike =  (Product)registry.lookup("B");

            //now invoke the methods of the referenced objects
            System.out.println("Name of laptop:"+charger.getName());
            System.out.println("Desc of laptop:"+charger.getDescription());
            System.out.println("Price of laptop:"+charger.getPrice());
    }
        catch (Exception e)
        {
            System.out.println("Client side error.."+e);
        }
    }
}
