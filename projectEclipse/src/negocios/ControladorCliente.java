package negocios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dados.RepositorioClientes;
import negocios.basicos.Cliente;
import negocios.interfaces.CCInterface;

public class ControladorCliente extends UnicastRemoteObject implements CCInterface{

	private static final long serialVersionUID = -8936092397883043351L;
	private RepositorioClientes repositorioClientes;
	private int tamanho;

	public ControladorCliente() throws RemoteException{
	
		this.repositorioClientes = new RepositorioClientes();
	}
 
	public void cadastrar(Cliente c) {
		if (c != null) {
			if (!this.repositorioClientes.existe(c)) {
				this.repositorioClientes.cadastrarCliente(c);
				System.out.println("Portanto, criado com sucesso!");
				tamanho = tamanho + 1;
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Cliente c) {
		this.repositorioClientes.procurar(c);
		if (c != null) {
			this.repositorioClientes.remover(c);
			tamanho = tamanho - 1;
		} else {

		}

	}

	public Cliente procurar(Cliente c) {
		return this.repositorioClientes.procurar(c);
	}

	public boolean existe(Cliente c) {
		return this.repositorioClientes.existe(c);
	}

	public void remover(Cliente c) {
		this.repositorioClientes.remover(c);
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public RepositorioClientes getRepositorioClientes() {
		return repositorioClientes;
	}

	public void setRepositorioClientes(RepositorioClientes repositorioClientes) {
		this.repositorioClientes = repositorioClientes;
	}

	@Override
	public String toString() {
		return repositorioClientes.toString();
	}

}
