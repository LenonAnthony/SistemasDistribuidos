package negocios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dados.RepositorioVendas;
import negocios.basicos.Venda;
import negocios.interfaces.CPInterface;
import negocios.interfaces.CVInterface;

public class ControladorVenda extends UnicastRemoteObject implements CVInterface {

	private static final long serialVersionUID = -7358390655644495761L;
	private RepositorioVendas repositorioVendas;

	public ControladorVenda() throws RemoteException {
		this.repositorioVendas = new RepositorioVendas();
	}

	public void cadastrar(Venda v) {
		if (v != null) {
			if (!this.repositorioVendas.existe(v)) {
				this.repositorioVendas.adicionarVenda(v);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, n�o foi criado!");

			}
		}
	} 

	public void descadastrar(Venda v) {
		this.repositorioVendas.procurar(v);
		if (v != null) {
			this.repositorioVendas.remover(v);
		} else {

		}

	}

	public Venda procurar(Venda v) {
		return this.repositorioVendas.procurar(v);
	}

	public boolean existe(Venda v) {
		return this.repositorioVendas.existe(v);
	}

	public void remover(Venda v) {
		this.repositorioVendas.remover(v);
	}
	
	public RepositorioVendas getRepositorioVendas() {
		return repositorioVendas;
	}

	public void setRepositorioVendas(RepositorioVendas repositorioVendas) {
		this.repositorioVendas = repositorioVendas;
	}

	@Override
	public String toString() {
		return repositorioVendas.toString();
	}
}