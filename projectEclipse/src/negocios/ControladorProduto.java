package negocios;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dados.RepositorioProdutos;
import negocios.basicos.Produto;
import negocios.interfaces.CPInterface;

public class ControladorProduto extends UnicastRemoteObject implements CPInterface {

	private static final long serialVersionUID = -4086474365074661265L;
	private RepositorioProdutos repositorioProdutos;
	private int tamanho;

	public ControladorProduto() throws RemoteException {
		this.repositorioProdutos = new RepositorioProdutos(); 
	}

	public void cadastrar(Produto p) {
		if (p != null) {
			if (!this.repositorioProdutos.existe(p)) {
				this.repositorioProdutos.cadastrarProduto(p);
				;
				System.out.println("Portanto, criado com sucesso!");
				tamanho = tamanho + 1;
			} else {
				System.out.println("Portanto, n�o foi criado!");
 
			}
		}
	}

	public void descadastrar(Produto p) {
		this.repositorioProdutos.procurar(p);
		if (p != null) {
			this.repositorioProdutos.remover(p);
			tamanho = tamanho - 1;
		} else {

		}

	}
	
	public Produto pegaPeloNome(String p)
	{
		return this.repositorioProdutos.pegaPeloNome(p);
	}

	public Produto procurar(Produto p) {
		return this.repositorioProdutos.procurar(p);
	}

	public boolean existe(Produto p) {
		return this.repositorioProdutos.existe(p);
	}

	public void remover(Produto p) {
		this.repositorioProdutos.remover(p);
	}

	public RepositorioProdutos getRepositorioProdutos() {
		return repositorioProdutos;
	}

	public void setRepositorioProdutos(RepositorioProdutos repositorioProdutos) {
		this.repositorioProdutos = repositorioProdutos;
	}
	

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return repositorioProdutos.toString();
	}

}
