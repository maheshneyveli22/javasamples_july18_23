package rmi.server;

import java.rmi.RemoteException;

public class ProductImpl implements Product{
    public String name;
    public String description;
    public double price;

    public ProductImpl(String newName, String newDescription, double newPrice) throws  RemoteException
    {
        this.name=newName;
        this.description= newDescription;
        this.price=newPrice;
    }

    public String getName() throws RemoteException {
        return null;
    }


    public String getDescription() throws RemoteException {
        return null;
    }


    public double getPrice() throws RemoteException {
        return 0;
    }
}
