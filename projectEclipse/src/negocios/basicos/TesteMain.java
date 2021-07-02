package negocios.basicos;

import java.util.ArrayList;

import negocios.ControladorCliente;
import negocios.ControladorFuncionario;
import negocios.ControladorProduto;
import negocios.ControladorVenda;

public class TesteMain {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("Lenon", "88899933300", "Olinda", 0);
		Produto p1 = new Produto("X-Burger", "descricao", 1, 10, true);
		Produto p2 = new Produto("X-Burger2", "descricao", 2, 12, true);
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123", 1200);

		ControladorCliente cc = new ControladorCliente();
		ControladorProduto cp = new ControladorProduto();
		ControladorVenda cv = new ControladorVenda();
		ControladorFuncionario cf = new ControladorFuncionario();
		cf.cadastrar(f1);
		System.out.println(cf);
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		Carrinho car1 = new Carrinho(c1, produtos);
		double y = car1.gerarValorTotal();
		
		System.out.println(y);
	}

}
