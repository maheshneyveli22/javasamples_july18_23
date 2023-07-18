package rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/*
* a) Create two packages for server and client
* b) In client package create Product class and in server package create Server, Product and ProductImpl class
* c) In server's Server class: do as specified in this class
* d) Do compilation of the classes: Product.java, ProductImpl.java:
 C:\Workspace\JavaSampleProj\JavaSampleProjects\src\rmi\server> javac .\Product.java
  Directory: C:\Workspace\JavaSampleProj\JavaSampleProjects\src\rmi\server


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
-a----         7/18/2023   2:26 PM            293 Product.class
-a----         7/18/2023   1:12 PM            299 Product.java
-a----         7/18/2023   2:26 PM            685 ProductImpl.class
-a----         7/18/2023   2:24 PM            676 ProductImpl.java
-a----         7/18/2023   2:26 PM           1500 Server.class
-a----         7/18/2023   2:24 PM           3326 Server.java
* e) Copy Product.java content from server to client
* f) Then we should implement Client.java class..
* -> locate the registry and lookup the relevant object and then call the relevant methods from client side
* g) then compile the Client.java and Product.java in client folder
*
*   Directory: C:\Workspace\JavaSampleProj\JavaSampleProjects\src\rmi\client


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
-a----         7/18/2023   2:49 PM           1646 Client.class
-a----         7/18/2023   2:45 PM           1257 Client.java
-a----         7/18/2023   2:49 PM            293 Product.class
-a----         7/18/2023   2:28 PM            301 Product.java
*
* h) now coding is done and time to run our code
* i) To run : Open 3 terminals
* 1) One to run the RMI registry
* 2) One to run the client
* 3) One to run the server
* i) To start RMI registry, go to server folder and use the command: start rmiregistry portNumber
PS C:\Workspace\JavaSampleProj\JavaSampleProjects\src\rmi\server> start rmiregistry 9100


*a cmd prompt wil open:
* WARNING: A terminally deprecated method in java.lang.System has been called
WARNING: System::setSecurityManager has been called by sun.rmi.registry.RegistryImpl
WARNING: Please consider reporting this to the maintainers of sun.rmi.registry.RegistryImpl
WARNING: System::setSecurityManager will be removed in a future release

j) now rmiregistry is started, next step is to run the server using cmd: java Server
* -> if alreadyBoundException is thrown, change the below line to rebind in Server class
*
*
*             registry.rebind("L",stub1);
            registry.rebind("M",stub2);
            registry.rebind("C",stub3);
            registry.rebind("B",stub4);
k) then recompile the class and the run java Server



*
*
 * */

public class Server {

    public static void main(String[] args) {
        try{

            //Set hostname for the server using javaproperty
            System.setProperty("java.rmi.server.hostname","127.0.0.1");



            ProductImpl p1 = new ProductImpl("Laptop","lenova laptop", 1240.3);
            ProductImpl p2 = new ProductImpl("Mobile","mi mobile", 120.3);
            ProductImpl p3 = new ProductImpl("Charger","lenova charger", 130.3);
            ProductImpl p4 = new ProductImpl("Motor bike","Yamaha bike", 124330.3);

            //Export p1,p2,p3 objects using UnicastRemoteObject class
            // We will export the objects of the class , so that we can create the stub , so that the stub can be used to communicate with client
            //Here 0 indicates the portnumber that will be used by the RMI registry and the server to communicate
            Product stub1=    (Product) UnicastRemoteObject.exportObject(p1,0);
            Product stub2=    (Product) UnicastRemoteObject.exportObject(p2,0);
            Product stub3=    (Product) UnicastRemoteObject.exportObject(p3,0);
            Product stub4=    (Product) UnicastRemoteObject.exportObject(p4,0);

            /// after exporting the class, we need to register the exported class in  RMI registry with some name
            // Client will use that name to get the reference of those exported objects

            //get the registry to register the object
            // we will start our rmi in one local machine in port number 9100
            // thuse we get instance of registry from machine with IP: 127.0.0.1 and port 9100
       //    Registry registry= LocateRegistry.getRegistry("127.0.0.1",9100);
          Registry registry= LocateRegistry.createRegistry(0);

            //Using registry we will register the objects now in the RMI registry
            // Client will use the namespaces we give in bind like "L" to locate the stub1 and thus the p1 object

            registry.bind("L",stub1);
            registry.bind("M",stub2);
            registry.bind("C",stub3);
            registry.bind("B",stub4);


        }
        catch (Exception e)
        {
            System.out.println("Some Server error.. ");
            e.printStackTrace();
        }
    }
}
