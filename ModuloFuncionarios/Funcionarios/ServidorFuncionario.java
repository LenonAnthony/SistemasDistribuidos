package Funcionarios;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServidorFuncionario {
public static void main(String[] args) throws Exception {
		
		try {
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CF", new ControladorFuncionario());
			
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		
		System.out.println("Servidor do Funcionário Iniciado"); 
	}

}
