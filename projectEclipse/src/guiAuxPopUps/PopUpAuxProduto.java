package guiAuxPopUps;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class PopUpAuxProduto extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoDescricao;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpAuxProduto frame = new PopUpAuxProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	
	
	public PopUpAuxProduto()
	{
		
	}
	public PopUpAuxProduto(String nome, Double preco, String descricao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoNome = new JTextField();
		campoNome.setBounds(5, 5, 424, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		campoNome.setText(nome);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(5, 60, 424, 20);
		contentPane.add(campoPreco);
		campoPreco.setColumns(10);
		campoPreco.setText(String.valueOf(preco));
		
		campoDescricao = new JTextField();
		campoDescricao.setBounds(5, 115, 424, 20);
		contentPane.add(campoDescricao);
		campoDescricao.setColumns(10);
		campoDescricao.setText(descricao);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(163, 186, 89, 23);
		contentPane.add(btnNewButton);
		
	}

}
