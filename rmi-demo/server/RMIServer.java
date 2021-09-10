import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
	static String ip = "172.16.17.153";
	static String name = "Compute";
	static int port = 1099;
	
    public static void main(String[] args) throws RemoteException {
        exec2();
    }
    static void exec1() {// Naming实现方式(这种方式目前有问题)
        try {
            LocateRegistry.createRegistry(1099);
            IRemoteMath remote = new RemoteMath();
            Naming.rebind("rmi:/172.16.17.217:1099/Compute", remote);
            System.out.println("Math server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void exec2() {// LocateRegistry实现方式
        try {
            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(port);
            IRemoteMath remote = new RemoteMath();
            Registry registry = LocateRegistry.getRegistry(ip, port);
            registry.bind(name, remote);
            System.out.println("Math server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
