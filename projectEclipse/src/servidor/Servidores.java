package servidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import negocios.ControladorFuncionario;
import negocios.ControladorProduto;


public class Servidores {
	public static void main(String[] args) throws Exception {
//s
		try {
			Registry registry1 = LocateRegistry.createRegistry(1099);
			registry1.rebind("CF", new ControladorFuncionario());
			Registry registry2 = LocateRegistry.createRegistry(1100);
			registry2.rebind("CP", new ControladorProduto());
			
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		System.out.println("Servidor Iniciado");
	}

}