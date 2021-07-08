package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import negocios.basicos.Funcionario;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.UIManager.*;

public class TelaDeLogin extends JFrame {

	private PopUpFuncionario popf = new PopUpFuncionario();
	private JFrame frame;
	private JTextField password;
	private JTextField login;
	private static String aux;

	public static String getAux() {
		return aux;
	}

	public static void setAux(String aux) {
		TelaDeLogin.aux = aux;
	}

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
		// mudando o Look and feel do programa.
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.a
		}

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeLogin.class.getResource("/images/IconPope.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 338, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Tela De Login - Pope's Dance");

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 332, 326);
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(255, 145, 145));

		JButton button = new JButton("Cadastrar");
		button.setBounds(10, 282, 104, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpFuncionario popf = new PopUpFuncionario();
				popf.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(button);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(10, 50, 64, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(10, 102, 73, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		password = new JTextField();
		password.setBounds(93, 113, 211, 30);
		panel.add(password);
		password.setColumns(10);

		login = new JTextField();
		login.setBounds(93, 61, 211, 30);
		panel.add(login);
		login.setColumns(10);

		JButton logarButton = new JButton("Logar");
		logarButton.setBounds(113, 185, 109, 41);
		panel.add(logarButton);
		logarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario f = new Funcionario("", "", "", login.getText(), password.getText(), 0);
				System.out.println(PopUpFuncionario.getCf());
				if (PopUpFuncionario.getCf().existeLoginSenha(f)) {
					for (int i = 0; i < PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios()
							.size(); i++) {
						if (PopUpFuncionario.getCf().existeLoginSenha(f)) {
							PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i)
									.setLogado(true);
							aux = PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i)
									.getTipo();

						}
					}

					JOptionPane.showMessageDialog(null, "Logado com Sucesso.");
					TelaDeLogin tl = new TelaDeLogin();	
					tl.frame.setVisible(true);
					/*
					 * TelaGerente tg = new TelaGerente(); tg.setVisible(true);
					 */

				} else {
					JOptionPane.showMessageDialog(null, "Dados Incorretos.");
				}

			}
		});
		logarButton.setFont(new Font("Tahoma", Font.PLAIN, 24));

	}
}
