package negocios.basicos;

public class Funcionario extends Pessoa {

	private String login;
	private String senha;
	private String tipo;
	private double salario;

	public Funcionario(String nome, String cpf, String tipo, String login, String senha, double salario) {

		super(nome, cpf);
		setTipo(tipo);
		setLogin(login);
		setSenha(senha);
		setSalario(salario);

	}

	public String getLogin() {

		return login;

	}

	public void setLogin(String login) {

		if (login != null) {

			this.login = login;

		}

	}

	public String getSenha() {

		return senha;

	}

	public void setSenha(String senha) {

		if (senha != null) {

			this.senha = senha;

		}

	}

	public String getTipo() {

		return tipo;

	}

	public void setTipo(String tipo) {

		if (tipo.equalsIgnoreCase("Funcionario") || tipo.equalsIgnoreCase("Gerente")) {

			this.tipo = tipo;

		}

	}

	public double getSalario() {

		return salario;

	}

	public void setSalario(double salario) {

		if (salario > 0) {

			this.salario = salario;

		}

	}
	
	public boolean verificaAcesso(Object obj) {

		boolean resultado = false;

		if (obj instanceof Funcionario) {

			Funcionario f = (Funcionario) obj;
			// Depois adicionar CPF.
			if (this.login.equals(f.login) && this.senha.equals(f.senha)) {

				resultado = true;
			}
		}

		return resultado;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return super.toString() + " | Tipo: " + tipo + " | Login: " + login + " | Senha: " + senha + " | Salário: R$ "
				+ salario;

	}

}