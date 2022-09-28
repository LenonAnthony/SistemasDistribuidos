package Clientes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Funcionarios.ControladorFuncionario;
import Produtos.ControladorProduto;
import Vendas.ControladorVenda;

public class ServidorCliente {
	
	
public static void main(String[] args) throws Exception {
		
		try {

			Registry registry = LocateRegistry.createRegistry(1101);
			registry.rebind("CC", new ControladorCliente());
			
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		
		System.out.println("Servidor do Cliente Iniciado"); 
	}


}
