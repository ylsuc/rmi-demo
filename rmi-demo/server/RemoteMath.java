import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMath extends UnicastRemoteObject implements IRemoteMath{

    public RemoteMath() throws RemoteException{
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }
}
