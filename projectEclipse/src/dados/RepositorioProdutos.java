package dados;

import java.util.ArrayList;

import negocios.basicos.Produto;

public class RepositorioProdutos {
	
	ArrayList<Produto> produtos = new ArrayList<>();
	private int tamanho;
	
	public RepositorioProdutos() {
		
	}
	

	public void cadastrarProduto(Produto p) {
		this.produtos.add(p);
		tamanho = this.produtos.size();
	}

	private int procurarIndice(Produto p) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (p.equals(this.produtos.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	
	public Produto procurar(Produto p) {
		int i = this.procurarIndice(p);
		Produto resultado = null;
		if (i != this.produtos.size()) {
			resultado = p;

		}
		return resultado;
	}

	public boolean existe(Produto p) {
		boolean existe = false;
		int indice = this.procurarIndice(p);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(Produto p) {
		int i = this.procurarIndice(p);
		if (i != tamanho) {
			this.produtos.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.produtos.size();
	}

	public String toString() {
		return "Produtos: "+produtos;
	}
	

}
