package negocios;

import dados.RepositorioFuncionarios;
import negocios.basicos.Funcionario;

public class ControladorFuncionario {

	private RepositorioFuncionarios repositorioFuncionario;

	public ControladorFuncionario() {
		this.repositorioFuncionario = new RepositorioFuncionarios();
	}

	public void cadastrar(Funcionario f) {
		if (f != null) {
			if (!this.repositorioFuncionario.existe(f)) {
				this.repositorioFuncionario.cadastrarFuncionario(f);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Funcionario f) {
		this.repositorioFuncionario.procurar(f);
		if (f != null) {
			this.repositorioFuncionario.remover(f);
			;
		} else {

		}

	}

	public Funcionario procurar(Funcionario f) {
		return this.repositorioFuncionario.procurar(f);
	}

	public boolean existe(Funcionario f) {
		return this.repositorioFuncionario.existe(f);
	}

	public void remover(Funcionario f) {
		this.repositorioFuncionario.remover(f);
	}
	

	public RepositorioFuncionarios getRepositorioFuncionario() {
		return repositorioFuncionario;
	}

	public void setRepositorioFuncionario(RepositorioFuncionarios repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}

	@Override
	public String toString() {
		return repositorioFuncionario.toString();
	}

}
