import java.time.LocalDateTime;

public class Venda {
	
	private Funcionario funcionario;
	private LocalDateTime datahora;
	private boolean aprovado;
	
	public Venda(Funcionario funcionario, LocalDateTime datahora, boolean aprovado) {
		
		this.funcionario = funcionario;
		this.datahora = datahora;
		this.aprovado = aprovado;
		
	}
	
	public Funcionario getFuncionario() {
		
		return funcionario;
		
	}
	
	public void setFuncionario(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
	}
	
	public LocalDateTime getDatahora() {
		
		return datahora;
		
	}
	
	public void setDatahora(LocalDateTime datahora) {
		
		this.datahora = datahora;
		
	}
	
	public boolean isAprovado() {
		
		return aprovado;
		
	}
	
	public void setAprovado(boolean aprovado) {
		
		this.aprovado = aprovado;
		
	}
	
	//FALTANDO ESSE MÉTODO.
	public void finalizaVenda() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if (obj instanceof Venda) {
			
			Venda v = (Venda) obj;
			
			if (this.funcionario.equals(v.funcionario) && this.datahora.isEqual(v.datahora) && this.aprovado == v.aprovado) {
				
				resultado = true;
				
			}
			
		}
		
		return resultado;
		
	}
	
	@Override
	public String toString() {
		
		return "\nFuncionário encarregado: " + funcionario + " | Data/Hora da venda: " + datahora + 
				" | A venda foi concluída? " + aprovado;
		
	}
	
}