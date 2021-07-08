package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocios.ControladorProduto;
import negocios.basicos.Produto;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PopUpProduto extends JFrame {

	public static ControladorProduto cp = new ControladorProduto();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static ControladorProduto getCp() {
		return cp;
	}

	public static void setCp(ControladorProduto cp) {
		PopUpProduto.cp = cp;
	}

	/**
	 * Launch the application.a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpProduto frame = new PopUpProduto();
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
	// TESTE
	public PopUpProduto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopUpProduto.class.getResource("/images/IconPope.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 145, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 145, 145));
		panel.setBounds(10, 11, 414, 167);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 0, 50, 27);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(85, 0, 329, 27);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(0, 56, 66, 24);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(85, 55, 329, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 113, 75, 24);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(85, 110, 329, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty()
						|| textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Favor, preencher tudo.");
				} else {
					if (Double.parseDouble(textField_1.getText()) <= 0) {
						JOptionPane.showMessageDialog(null, "Valor do Produto não pode ser negativo ou nulo.");
					} else {
						Produto p = new Produto(textField.getText(), textField_2.getText(), 1,
								Double.parseDouble(textField_1.getText()), true);
						JOptionPane.showMessageDialog(null, "Produto adicionado!");
						cp.cadastrar(p);
						System.out.println(cp);
						dispose();
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(218, 204, 171, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(44, 204, 171, 45);
		contentPane.add(btnNewButton_1);

		// String nome, String descricao, int quantidade, double preco, boolean estoqu
		// Produto p1 = new Produto("hamburguer", "2 pães, 1 carne e queijo prato", 1,
		// 10.0, true);
		// cp.getRepositorioProdutos().cadastrarProduto(p1);

	}

}
