package dados;

import java.time.LocalDateTime;
import java.util.ArrayList;

import negocios.*;
import negocios.basicos.Carrinho;
import negocios.basicos.Cliente;
import negocios.basicos.Funcionario;
import negocios.basicos.Produto;
import negocios.basicos.Venda;

public class RepositorioTesteMain {

	public static void main(String[] args) {

		LocalDateTime datahora = LocalDateTime.now();
		boolean aprovado = true;
		RepositorioClientes rc = new RepositorioClientes();
		Cliente c1 = new Cliente("Lenon", "88899933300", "Olinda", 0);
		Cliente c2 = new Cliente("Joao", "88899933400", "Olinda", 0);
		RepositorioFuncionarios rf = new RepositorioFuncionarios();
		Produto p1 = new Produto("X-Burger", "descricao", 1, 10, true);
		Produto p2 = new Produto("X-Burger2", "descricao", 2, 12, true);
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123", 1200);
		Funcionario f2 = new Funcionario("Yagod", "001", "Funcionario", "user", "123", 1500);
		RepositorioVendas rv = new RepositorioVendas();
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		
		Carrinho car1 = new Carrinho(c1, produtos);
		
		Venda v1 = new Venda(car1, f1, datahora, aprovado);
		rv.adicionarVenda(v1);
		System.out.println(rv);
		
		
		rf.cadastrarFuncionario(f1);
		rc.cadastrarCliente(c1);
		rc.cadastrarCliente(c2);
		rf.cadastrarFuncionario(f2);
		System.out.println(rc);
		System.out.println(rf);
		
		
	}

}
