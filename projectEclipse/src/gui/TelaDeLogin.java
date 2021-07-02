package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import negocios.ControladorFuncionario;
import negocios.basicos.Funcionario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaDeLogin extends JFrame {
	PopUpFuncionario popf = new PopUpFuncionario();
	private JFrame frame;
	private JTextField password;
	private JTextField login;
	private String aux;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin window = new TelaDeLogin();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(159, 138, 64, 41);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(159, 190, 73, 41);
		frame.getContentPane().add(lblNewLabel_1);

		password = new JTextField();
		password.setBounds(242, 201, 211, 30);
		frame.getContentPane().add(password);
		password.setColumns(10);

		login = new JTextField();
		login.setColumns(10);
		login.setBounds(242, 149, 211, 30);
		frame.getContentPane().add(login);

		JButton logarButton = new JButton("Logar");
		logarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario f = new Funcionario("", "", "", login.getText(), password.getText(), 0);
				System.out.println(PopUpFuncionario.getCf());
				if (PopUpFuncionario.getCf().existeLoginSenha(f)) {
					for(int i = 0; i<PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().size();i++)
					{
						if (PopUpFuncionario.getCf().existeLoginSenha(f))
						{
							PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i).setLogado(true);
							aux = PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i).getTipo();
							
						}
					}
					
					JOptionPane.showMessageDialog(null, "Logado com Sucesso.");
					frame.dispose();
					if(aux.equals("Gerente"))
					{
						TelaGerente tg = new TelaGerente();
						tg.setVisible(true);	
					}
					else 
					{
						TelaDeFuncionario tf = new TelaDeFuncionario();
						tf.setVisible(true);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Dados Incorretos.");
				}

			}
		});
		logarButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		logarButton.setBounds(286, 242, 112, 41);
		frame.getContentPane().add(logarButton);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 641, 466);
		frame.getContentPane().add(panel);

		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpFuncionario popf = new PopUpFuncionario();
				popf.setVisible(true);
			}
		});
		panel.add(button);

		JButton btnNewButton_1 = new JButton("Deletar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario f = new Funcionario("", "", "", login.getText(), password.getText(), 0);
				System.out.println(PopUpFuncionario.getCf());
				if (PopUpFuncionario.getCf().existe(f)) {
					PopUpFuncionario.getCf().descadastrar(f);
					JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");

				} else {
					JOptionPane.showMessageDialog(null, "Dados Incorretos.");
				}

			}
		});
		panel.add(btnNewButton_1);

	}
}
