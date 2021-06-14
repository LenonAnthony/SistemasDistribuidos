package negocios;

import dados.RepositorioProdutos;
import negocios.basicos.Produto;

public class ControladorProduto {

	private RepositorioProdutos repositorioProdutos;

	public ControladorProduto() {
		this.repositorioProdutos = new RepositorioProdutos();
	}

	public void cadastrar(Produto p) {
		if (p != null) {
			if (!this.repositorioProdutos.existe(p)) {
				this.repositorioProdutos.cadastrarProduto(p);
				;
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Produto p) {
		this.repositorioProdutos.procurar(p);
		if (p != null) {
			this.repositorioProdutos.remover(p);
		} else {

		}

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

	@Override
	public String toString() {
		return repositorioProdutos.toString();
	}

}
