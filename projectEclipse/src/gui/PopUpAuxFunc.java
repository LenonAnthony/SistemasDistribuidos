package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class PopUpAuxFunc extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoTipo;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpAuxFunc frame = new PopUpAuxFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PopUpAuxFunc()
	{
		
	}
	
	
	public PopUpAuxFunc(String nome, String cpf, String Funcao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoNome = new JTextField();
		campoNome.setBounds(5, 5, 424, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		campoNome.setText(nome);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(5, 47, 424, 20);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		campoCpf.setText(cpf);
		
		campoTipo = new JTextField();
		campoTipo.setBounds(5, 91, 424, 20);
		contentPane.add(campoTipo);
		campoTipo.setColumns(10);
		campoTipo.setText(Funcao);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(162, 177, 89, 23);
		contentPane.add(btnNewButton);
	}

}
