package negocios;

public class Cliente extends Pessoa {

	private int pontos;
	private String endereco;

	public Cliente(String nome, String cpf, String endereco, int pontos) {

		super(nome, cpf);
		setEndereco(endereco);
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
	public void addPontos(Cliente c) {
		c.setPontos(c.getPontos() + 1);

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

		return super.toString() + " | Endereço: " + endereco + " | Pontos acumulados: " + pontos;

	}

}