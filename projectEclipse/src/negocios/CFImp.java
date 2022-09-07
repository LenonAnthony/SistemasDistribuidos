package negocios;

import java.rmi.Naming;
import negocios.interfaces.CFInterface;
import negocios.interfaces.CPInterface;
import negocios.basicos.Funcionario;
import negocios.basicos.Produto;

public class CFImp {
	private static CFInterface cf1;
	private static ControladorFuncionario c;
	
	private static CPInterface cp1;
	private static ControladorProduto p;
	

	public static void main(String[] args) throws Exception {
		
		Produto p1 = new Produto("X-Burger", "descricao", 1, 10, true);
		Produto p2 = new Produto("X-Burger2", "descricao", 2, 12, true);
		Produto p3 = new Produto("Cabra", "cabrinha", 3, 30, false);
		Produto p4 = new Produto("Rola", "rolinha", 4, 40, false);
		
		p = new ControladorProduto();
		cp1 = (CPInterface) Naming.lookup("rmi://localhost:1100/CP");
		Naming.rebind("rmi://localhost:1100/CP", p);
		p.cadastrar(p1);
		p.cadastrar(p2);
		p.cadastrar(p3);
		p.cadastrar(p4);
		System.out.println(cp1.getRepositorioProdutos().getProdutos().get(0).toStringP());
		
//s
		c = new ControladorFuncionario();
		cf1 = (CFInterface) Naming.lookup("rmi://localhost:1099/CF");
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123");
		Funcionario f2 = new Funcionario("Chagas2", "0300", "Gerente", "user1", "1234");
		Naming.rebind("rmi://localhost:1099/CF", c);
		c.cadastrar(f1);
		System.out.println(cf1.getRepositorioFuncionario().getFuncionarios());

	}

}