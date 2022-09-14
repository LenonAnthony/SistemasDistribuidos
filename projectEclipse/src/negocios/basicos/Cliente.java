package negocios.basicos;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8036476078905499298L; 
	private String nome;
	private String cpf;
	private int pontos = 0;
	private String endereco;

	public Cliente(String nome, String cpf, String endereco, int pontos) {

		this.nome = nome;
		this.cpf = cpf;
		this.setEndereco(endereco);
		setPontos(pontos);

	}

	public int getPontos() {

		return pontos;
 
	}

	public void setPontos(int pontos) {

		if (pontos > -1) {

			this.pontos = pontos;

		}

	}

	public String getEndereco() {

		return endereco;

	}

	public void setEndereco(String endereco) {

		if (endereco != null) {

			this.endereco = endereco;

		}

	}

	// FALTANDO ESSE MÉTODO.
	public void addPontos() {
		this.pontos ++;

	}

	@Override
	public boolean equals(Object obj) {

		boolean resultado = false;

		if (obj instanceof Cliente) {

			Cliente c = (Cliente) obj;

			if (super.equals(c) && this.endereco.equalsIgnoreCase(c.endereco) && this.pontos == c.pontos) {

				resultado = true;

			}

		}

		return resultado;

	}

	@Override
	public String toString() {

		return "Nome: " + nome + " | CPF: " + cpf + " | Endereço: " + endereco + " | Pontos acumulados: " + pontos;

	}
	
	public String toStringC() {

		return  nome + " " + cpf + " " + endereco + " " + pontos;

    }

}