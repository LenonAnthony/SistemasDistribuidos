package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import negocios.basicos.Funcionario;

public class RepositorioFuncionarios implements Serializable {
	//s
	private static final long serialVersionUID = -1919414877885418528L;
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private int tamanho;

	public RepositorioFuncionarios()  {
		
		BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("funcionarios.txt"));
            for(String line; (line = br.readLine()) != null; ) {  
                String[] splited = line.split("\s+");
                String nome = splited[0];
                String cpf = splited[1];
                String tipo = splited[2];
                String login = splited[3];
                String senha = splited[4];
                Boolean logado = Boolean.parseBoolean(splited[5]);
                Funcionario f = new Funcionario(nome, cpf, tipo, login, senha);
                cadastrarFuncionario(f);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        System.out.println(this.funcionarios);

	} 
	

	public void cadastrarFuncionario(Funcionario f) {
		this.funcionarios.add(f);		
		
		PrintStream ps;
        try {
            ps = new PrintStream("funcionarios.txt");
            for(int i = 0; i < this.funcionarios.size() -1; i++) {
                ps.println(this.funcionarios.get(i).toStringF());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		tamanho = this.funcionarios.size();
	}

	public int procurarIndiceLoginSenha(Funcionario f) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (f.verificaAcesso(this.funcionarios.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public int procurarIndice(Funcionario f) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (f.equals(this.funcionarios.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Funcionario procurarLoginSenha(Funcionario f) {
		int i = this.procurarIndiceLoginSenha(f);
		Funcionario resultado = null;
		if (i != this.funcionarios.size()) {
			resultado = f;

		}
		return resultado;
	}

	public Funcionario procurarFuncionario(Funcionario f) {
		int i = this.procurarIndice(f);
		Funcionario resultado = null;
		if (i != this.funcionarios.size()) {
			resultado = f;

		}
		return resultado;
	}


	public boolean existe(Funcionario f) {
		boolean existe = false;
		int indice = this.procurarIndice(f);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta n�o existe");
		}
		return existe;
	}

	public boolean existeLoginSenha(Funcionario f) {
		boolean existe = false;
		int indice = this.procurarIndiceLoginSenha(f);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta n�o existe");
		}
		return existe;
	}

	public void remover(Funcionario f) {
		int i = this.procurarIndice(f);
		if (i != tamanho) {
			this.funcionarios.remove(i);
			System.out.println("Funcionario removido.");
		} else {
			System.out.println("Funcionario n�o encontrado. Portanto, n�o foi removido.");
		}
		tamanho = this.funcionarios.size();
	}
	
	public void atualiza() {
		PrintStream ps;
		try {
			ps = new PrintStream("funcionarios.txt");
			for(int i = 0; i < this.funcionarios.size(); i++) {
				ps.println(this.funcionarios.get(i).toStringF());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String toString() {
		return "Funcionarios: " + funcionarios;
	}

}
