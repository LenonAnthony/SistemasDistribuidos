package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaNovaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEndereo;
	private JTable table_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel valorFinal;
	private JButton btnNewButton_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaVenda frame = new TelaNovaVenda();
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
	public TelaNovaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setForeground(SystemColor.info);
		panel.setBounds(10, 11, 267, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(100, 15, 92, 14);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setText("Nome:");
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setBounds(10, 40, 247, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.LEFT);
		txtCpf.setText("CPF:");
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 71, 247, 20);
		panel.add(txtCpf);
		
		txtEndereo = new JTextField();
		txtEndereo.setText("Endere\u00E7o:");
		txtEndereo.setColumns(10);
		txtEndereo.setBounds(10, 104, 247, 20);
		panel.add(txtEndereo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 11, 967, 414);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(287, 436, 977, 233);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 166, 267, 55);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(10, 255, 267, 55);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Finalizar Compra");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setToolTipText("Finaliza a compra e fecha a aba");
		btnNewButton_2.setBounds(10, 593, 267, 77);
		contentPane.add(btnNewButton_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 409, 267, 173);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Valor final:");
		lblNewLabel_1.setBounds(10, 11, 83, 14);
		panel_1.add(lblNewLabel_1);
		
		valorFinal = new JLabel("uga");
		valorFinal.setFont(new Font("Tahoma", Font.PLAIN, 35));
		valorFinal.setToolTipText("Valor \u00E0 ser pago");
		valorFinal.setBounds(10, 24, 257, 149);
		panel_1.add(valorFinal);
		//teste
		btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(10, 343, 267, 55);
		contentPane.add(btnNewButton_3);

	}
}
