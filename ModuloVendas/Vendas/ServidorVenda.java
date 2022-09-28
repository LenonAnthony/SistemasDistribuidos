package Vendas;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Clientes.ControladorCliente;
import Funcionarios.ControladorFuncionario;
import Produtos.ControladorProduto;

public class ServidorVenda {
	public static void main(String[] args) throws Exception {

		try {

			Registry registry = LocateRegistry.createRegistry(1102);
			registry.rebind("CV", new ControladorVenda());

		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}

		System.out.println("Servidor de Venda Iniciado");
	}
}
