package negocios;

public class Funcionario extends Pessoa {
	
	private String loginnnnnnnn;
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
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if (obj instanceof Funcionario) {
			
			Funcionario f = (Funcionario) obj;
			
			if (super.equals(f) && this.tipo.equalsIgnoreCase(f.tipo) && this.login.equals(f.login) && 
					this.senha.equals(f.senha) && this.salario == f.salario) {
				
				resultado = true;
				
			}
			
		}
		
		return resultado;
		
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " | Tipo: " + tipo + " | Login: " + login + " | Senha: " + senha + " | Salário: R$ " + salario;
		
	}
	
}