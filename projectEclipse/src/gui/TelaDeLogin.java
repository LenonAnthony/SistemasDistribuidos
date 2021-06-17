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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaDeLogin {

	private JFrame frame;
	private JTextField password;
	private JTextField login;

	/**
	 * Launch the application.
	 */
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
		logarButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		logarButton.setBounds(286, 242, 112, 41);
		frame.getContentPane().add(logarButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 641, 466);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/images/73eaa7ce4e6fe5c6b158fbf55d2cd6bf.jpg")));
		panel.add(lblNewLabel_2);
	}
}
