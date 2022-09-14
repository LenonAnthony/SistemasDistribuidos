package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import negocios.basicos.Cliente;
import negocios.basicos.Funcionario;

public class RepositorioClientes implements Serializable {


	private static final long serialVersionUID = 1324200405309612664L;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int tamanho;

	public RepositorioClientes() {
		BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("Clientes.txt"));
            for(String line; (line = br.readLine()) != null; ) {  
                String[] splited = line.split("\s+");
                String nome = splited[0];
                String cpf = splited[1];
                String endereco = splited[2];
                Integer pontos = Integer.parseInt(splited[3]);
                Cliente c = new Cliente(nome, cpf, endereco, pontos);
                cadastrarCliente(c);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        System.out.println(this.clientes);

	}

	public void cadastrarCliente(Cliente c) {
		this.clientes.add(c);
		
		PrintStream ps;
        try {
            ps = new PrintStream("Clientes.txt");
            for(int i = 0; i < this.clientes.size(); i++) {
                ps.println(this.clientes.get(i).toStringC());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		tamanho = this.clientes.size();
	}


	private int procurarIndice(Cliente c) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) { 
			if (c.equals(this.clientes.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Cliente procurar(Cliente c) {
		int i = this.procurarIndice(c);
		Cliente resultado = null;
		if (i != this.clientes.size()) {
			resultado = c;

		}
		return resultado;
	}

	public boolean existe(Cliente c) {
		boolean existe = false;
		int indice = this.procurarIndice(c);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(Cliente c) {
		int i = this.procurarIndice(c);
		if (i != tamanho) {
			this.clientes.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.clientes.size();
	}

	public void atualiza() {
		PrintStream ps;
		try {
			ps = new PrintStream("Clientes.txt");
			for(int i = 0; i < this.clientes.size(); i++) {
				ps.println(this.clientes.get(i).toStringC());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String toString() {
		return "Clientes: " + clientes;
	}

}
