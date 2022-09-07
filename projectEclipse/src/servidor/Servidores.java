package servidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import negocios.ControladorFuncionario;


public class Servidores {
	public static void main(String[] args) throws Exception {
//s
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CF", new ControladorFuncionario());
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		System.out.println("Servidor Iniciado");
	}

}