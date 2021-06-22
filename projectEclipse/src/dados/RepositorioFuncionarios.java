package dados;

import java.util.ArrayList;

import negocios.basicos.Funcionario;

public class RepositorioFuncionarios {
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private int tamanho;

	public RepositorioFuncionarios() {
	}

	public void cadastrarFuncionario(Funcionario f) {
		this.funcionarios.add(f);
		tamanho = this.funcionarios.size();
	}

	private int procurarIndice(Funcionario f) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (f.equals(this.funcionarios.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Funcionario procurar(Funcionario f) {
		int i = this.procurarIndice(f);
		Funcionario resultado = null;
		if (i != this.funcionarios.size()) {
			resultado = f;

		}
		return resultado;
	}

	public boolean existe(Funcionario f) {
		boolean existe = false;
		int indice = this.procurarIndice(f);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}
	

	public void remover(Funcionario f) {
		int i = this.procurarIndice(f);
		if (i != tamanho) {
			this.funcionarios.remove(i);
			System.out.println("Funcionario removido.");
		} else {
			System.out.println("Funcionario não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.funcionarios.size();
	}

	public String toString() {
		return "Funcionarios: " + funcionarios;
	}

}
