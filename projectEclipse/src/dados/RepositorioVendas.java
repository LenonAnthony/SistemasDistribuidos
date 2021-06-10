package dados;

import java.util.ArrayList;

import negocios.basicos.Venda;

public class RepositorioVendas {
	
	ArrayList<Venda> vendas = new ArrayList<>();
	private int tamanho;

	public RepositorioVendas() {
	}

	public void adicionarVenda(Venda v) {
		this.vendas.add(v);
		tamanho = this.vendas.size();
	}

	private int procurarIndice(Venda v) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (v.equals(this.vendas.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	
	public Venda procurar(Venda v) {
		int i = this.procurarIndice(v);
		Venda resultado = null;
		if (i != this.vendas.size()) {
			resultado = v;

		}
		return resultado;
	}

	public boolean existe(Venda v) {
		boolean existe = false;
		int indice = this.procurarIndice(v);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(Venda v) {
		int i = this.procurarIndice(v);
		if (i != tamanho) {
			this.vendas.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.vendas.size();
	}

	public String toString() {
		return "Vendas: "+vendas;
	}

}
