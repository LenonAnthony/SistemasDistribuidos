package negocios;

import java.rmi.Naming;
import negocios.interfaces.CFInterface;
import negocios.basicos.Funcionario;

public class CFImp {
	private static CFInterface cf1;
	private static ControladorFuncionario c;

	public static void main(String[] args) throws Exception {

		c = new ControladorFuncionario();
		cf1 = (CFInterface) Naming.lookup("rmi://localhost:1099/CF");
		Funcionario f1 = new Funcionario("Chagas", "000", "Funcionario", "user", "123");
		Funcionario f2 = new Funcionario("Chagas2", "0300", "Gerente", "user1", "1234");
		Naming.rebind("rmi://localhost:1099/CF", c);
		c.cadastrar(f1);
		System.out.println(cf1.getRepositorioFuncionario().getFuncionarios());

	}

}