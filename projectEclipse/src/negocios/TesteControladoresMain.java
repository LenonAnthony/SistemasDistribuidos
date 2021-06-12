package negocios;

import java.time.LocalDateTime;
import java.util.ArrayList;

import negocios.basicos.Carrinho;
import negocios.basicos.Cliente;
import negocios.basicos.Funcionario;
import negocios.basicos.Produto;
import negocios.basicos.Venda;

public class TesteControladoresMain {

	public static void main(String[] args) {
		LocalDateTime datahora = LocalDateTime.now();
		boolean aprovado = true;
		Cliente c1 = new Cliente("Lenon", "88899933300", "Olinda", 0);
		Cliente c2 = new Cliente("Joao", "88899933400", "Olinda", 0);
		Cliente c3 = new Cliente("Lenon", "88899933300", "Olinda", 0);
		Produto p1 = new Produto("X-Burger", "descricao", 1, 10, true);
		Produto p2 = new Produto("X-Burger2", "descricao", 2, 12, true);
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123", 1200);

		ControladorCliente cc = new ControladorCliente();
		ControladorProduto cp = new ControladorProduto();
		ControladorVenda cv = new ControladorVenda();
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		Carrinho car1 = new Carrinho(c1, produtos);

		Venda v1 = new Venda(car1, f1, datahora, aprovado);
		Venda v2 = new Venda(car1, f1, datahora, aprovado);

		cv.cadastrar(v1);

		System.out.println(cv);

		cc.cadastrar(c1);
		cc.cadastrar(c2);
		cc.cadastrar(c3);
		cp.cadastrar(p1);
		cp.cadastrar(p2);
		System.out.println(cp);

	}
}
