package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import negocios.basicos.Funcionario;
import negocios.basicos.Produto;

public class RepositorioProdutos implements Serializable {

	private static final long serialVersionUID = -7693241962439731138L;
	ArrayList<Produto> produtos = new ArrayList<>();
	private int tamanho;

	public RepositorioProdutos() {
		
		BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("produtos.txt"));
            for(String line; (line = br.readLine()) != null; ) { 
                String[] splited = line.split("\s+");
                String nome = splited[0];
                String descricao = splited[1];
                int quantidade = Integer.parseInt(splited[2]);
                double preco = Double.parseDouble(splited[3]);
                Boolean estoque = Boolean.parseBoolean(splited[4]);
                Produto p = new Produto(nome, descricao, quantidade, preco, estoque);
                cadastrarProduto(p);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        System.out.println(this.produtos);

	}

	public void cadastrarProduto(Produto p) {
		this.produtos.add(p);
		
		PrintStream ps;
        try {
            ps = new PrintStream("produtos.txt");
            for(int i = 0; i < this.produtos.size() -1; i++) {
                ps.println(this.produtos.get(i).toStringP());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		
		tamanho = this.produtos.size();
	}

	private int procurarIndice(Produto p) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (p.equals(this.produtos.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Produto procurar(Produto p) {
		int i = this.procurarIndice(p);
		Produto resultado = null;
		if (i != this.produtos.size()) {
			resultado = p;

		}
		return resultado;
	}

	public boolean existe(Produto p) {
		boolean existe = false;
		int indice = this.procurarIndice(p);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta n�o existe");
		}
		return existe;
	}

	public void remover(Produto p) {
		int i = this.procurarIndice(p);
		if (i != tamanho) {
			this.produtos.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente n�o encontrado. Portanto, n�o foi removido.");
		}
		tamanho = this.produtos.size();
	}
	
	public void atualiza() {
		PrintStream ps;
		try {
			ps = new PrintStream("produtos.txt");
			for(int i = 0; i < this.produtos.size(); i++) {
				ps.println(this.produtos.get(i).toStringP());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Produto pegaPeloNome (String nome)
	{
		
		for(int i = 0; i<this.produtos.size(); i++)
		{
			if(this.produtos.get(i).getNome().equals(nome))
			{
				return this.produtos.get(i);
			}
		}
		
		return null;
		
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String toString() {
		return "Produtos: " + produtos;
	}

}
