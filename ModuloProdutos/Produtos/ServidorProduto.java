package Produtos;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Clientes.ControladorCliente;
import Funcionarios.ControladorFuncionario;
import Vendas.ControladorVenda;

public class ServidorProduto {
	
public static void main(String[] args) throws Exception {
		
		try {
			
			Registry registry = LocateRegistry.createRegistry(1100);
			registry.rebind("CP", new ControladorProduto());
			
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}
		
		System.out.println("Servidor do Produto Iniciado"); 
	}


}
