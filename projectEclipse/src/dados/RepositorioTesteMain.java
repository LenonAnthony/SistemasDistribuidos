package dados;

import java.time.LocalDateTime;

import negocios.*;

public class RepositorioTesteMain {

	public static void main(String[] args) {

		LocalDateTime datahora = LocalDateTime.now();
		boolean aprovado = true;
		RepositorioClientes rc = new RepositorioClientes();
		Cliente c1 = new Cliente("Lenon", "88899933300", "Olinda", 0);
		Cliente c2 = new Cliente("Joao", "88899933400", "Olinda", 0);
		RepositorioFuncionarios rf = new RepositorioFuncionarios();
		Produto p1 = new Produto("X-Burger", "descricao", 1, 10, true);
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123", 1200);
		RepositorioVendas rv = new RepositorioVendas();
		
		rf.cadastrarFuncionario(f1);
		rc.cadastrarCliente(c1);
		rc.cadastrarCliente(c2);
		System.out.println(rc);
		System.out.println(rf);
		
	}

}
