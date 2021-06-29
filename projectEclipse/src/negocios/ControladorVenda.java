package negocios;

import dados.RepositorioVendas;
import negocios.basicos.Venda;

public class ControladorVenda {

	private RepositorioVendas repositorioVendas;

	public ControladorVenda() {
		this.repositorioVendas = new RepositorioVendas();
	}

	public void cadastrar(Venda v) {
		if (v != null) {
			if (!this.repositorioVendas.existe(v)) {
				this.repositorioVendas.adicionarVenda(v);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

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

	@Override
	public String toString() {
		return repositorioVendas.toString();
	}

	public RepositorioVendas getRepositorioVendas() {
		return repositorioVendas;
	}

	public void setRepositorioVendas(RepositorioVendas repositorioVendas) {
		this.repositorioVendas = repositorioVendas;
	}

}
