package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import negocios.ControladorProduto; 
import negocios.basicos.Carrinho;
import negocios.basicos.Cliente;
import negocios.basicos.Funcionario;
import negocios.basicos.Produto;
import negocios.basicos.Venda;

public class RepositorioVendas implements Serializable {
	
	private static final long serialVersionUID = 7221116099443829541L;
	ArrayList<Venda> vendas = new ArrayList<>();
	private int tamanho;
	
			
	public RepositorioVendas(){
		
		BufferedReader br;
        try {
        	
        	br = new BufferedReader(new FileReader("vendas.txt"));
            for(String line; (line = br.readLine()) != null;  ) { 
            	
                
            	String[] splited = line.split("\s+");
                String nomeC = splited[0];
                String cpfC = splited[1];
                String nomeF = splited[2];
                String cpfF = splited[3];
                String datahora = splited[4];
                double valorTotal = Double.parseDouble(splited[5]);
                Boolean aprovado = Boolean.parseBoolean(splited[6]);
                
                ArrayList<Produto> product = new ArrayList<>();
                
                for(int j = 7; j < splited.length; j++) {
                	
                	String nome = (splited[j]);
                	j++;
                	int quantidade = Integer.parseInt(splited[j]);
                    j++;
                	double preco = Double.parseDouble(splited[j]);
        	
                    Produto p = new Produto(nome, quantidade, preco);
                    product.add(p);
                        
                }
                   
                Funcionario f = new Funcionario(nomeF, cpfF);
                Cliente c1 = new Cliente(nomeC, cpfC);
                Carrinho c = new Carrinho(c1, product);
                Venda v = new Venda(c, f, datahora, aprovado);
                
                adicionarVenda(v);
                System.out.println(v.toStringV());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

		
		
	}
	
	public void adicionarVenda(Venda v) {
		this.vendas.add(v);
		PrintStream ps;
        try {
            ps = new PrintStream("vendas.txt");
            for(int i = 0; i < this.vendas.size(); i++) {
                ps.println(this.vendas.get(i).toStringV());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		
		
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
			System.out.println("A conta n�o existe");
		}
		return existe;
	}

	public void remover(Venda v) {
		int i = this.procurarIndice(v);
		if (i != tamanho) {
			this.vendas.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente n�o encontrado. Portanto, n�o foi removido.");
		}
		tamanho = this.vendas.size();
	}

	public String toString() {
		return "Vendas: "+vendas;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
