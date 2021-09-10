import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;

public class MathClient {
	static String ip = "172.16.17.217";
	static String name = "Compute";
	static int port = 1099;
	
	public static void main(String[] args) {
		exec2();
	}
	static void exec1() {
		try {
			System.setProperty("java.rmi.server.hostname", ip);
			IRemoteMath remoteMath = (IRemoteMath) Naming.lookup("rmi:/" + ip + ":" + port + "/" + name);
			double addResult = remoteMath.add(5.0, 3.0);
			System.out.println("5.0 + 3.0 = " + addResult);
			
			double subResult = remoteMath.subtract(5.0, 3.0);
			System.out.println("5.0 - 3.0 = " + subResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void exec2() {
		try {
			Registry registry = LocateRegistry.getRegistry(ip, port);
			IRemoteMath remoteMath = (IRemoteMath) registry.lookup(name);
			double addResult = remoteMath.add(5.0, 3.0);
			System.out.println("5.0 + 3.0 = " + addResult);
			
			double subResult = remoteMath.subtract(5.0, 3.0);
			System.out.println("5.0 - 3.0 = " + subResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
