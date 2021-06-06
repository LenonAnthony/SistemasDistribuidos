package negocios;

import java.util.ArrayList;

public class Carrinho {
	
	private Cliente cliente;
	private Venda venda;
	private ArrayList<Produto> produtos;
	private double valorTotal;
	
	public Carrinho(Cliente cliente, Venda venda, double valorTotal) {
		
		this.cliente = cliente;
		this.venda = venda;
		setValorTotal(valorTotal);
		produtos = new ArrayList<>();
		
	}
	
	public Cliente getCliente() {
		
		return cliente;
		
	}
	
	public void setCliente(Cliente cliente) {
		
		this.cliente = cliente;
		
	}
	
	public Venda getVenda() {
		
		return venda;
		
	}
	
	public void setVenda(Venda venda) {
		
		this.venda = venda;
		
	}
	
	public double getValorTotal() {
		
		return valorTotal;
		
	}
	
	public void setValorTotal(double valorTotal) {
		
		if (valorTotal > 0) {
			
			this.valorTotal = valorTotal;
			
		}
		
	}
	
	public ArrayList<Produto> getProdutos() {
		
		return produtos;
		
	}
	
	public void adicionarItem(Produto p) {
		
		produtos.add(p);
		
	}
	
	public double calcularTotal() {
		
		double resultado = 0;
		
		for (Produto p : produtos) {
			
			resultado += p.getPreco();
			
		}
		
		return resultado;
		
	}
	
}