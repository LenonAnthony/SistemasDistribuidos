package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import negocios.basicos.Produto;
import negocios.basicos.Venda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaControleVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtInicio;
	private JTextField txtFim;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean filtroCliente;
	private boolean filtroFuncionario;
	private boolean filtroArea;
	private String aux[] = {"Funcionario", "Cliente", "Area", "Data/Hora", "Valor Total"};
	private DefaultTableModel dtm = new DefaultTableModel(aux, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaControleVendas frame = new TelaControleVendas();
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
	//da funcao recebe os filtros relativos aos botes e atualiza a tabela em funcao dos mesmos.
	public void atualizarSemFiltros(boolean filtro1, boolean filtro2, boolean filtro3)
	{
		int tamanho = TelaNovaVenda.getCv().getRepositorioVendas().getTamanho();
		ArrayList<Venda> arrays = new ArrayList<>();
		arrays.addAll(TelaNovaVenda.getCv().getRepositorioVendas().getVendas());
		for (int i = 0; i < tamanho; i++) {
			Object[] objs = { arrays.get(i).getFuncionario().getNome(), arrays.get(i).getCarrinho().getCliente().getNome(), 
					arrays.get(i).getCarrinho().getCliente().getEndereco(), arrays.get(i).getDatahora(), arrays.get(i).getCarrinho().getValorTotal() };
			dtm.addRow(objs);
		}
	}
	
	
	
	
	public TelaControleVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 11, 926, 659);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dtm);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(9, 11, 309, 659);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filtros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 289, 27);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Area");
		rdbtnNewRadioButton.setBounds(10, 55, 54, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Funcion\u00E1rio");
		rdbtnNewRadioButton_1.setBounds(10, 147, 103, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Cliente");
		rdbtnNewRadioButton_2.setBounds(10, 242, 66, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Per\u00EDodo");
		rdbtnNewRadioButton_3.setBounds(10, 458, 75, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		txtInicio = new JTextField();
		txtInicio.setBounds(10, 510, 134, 23);
		panel.add(txtInicio);
		txtInicio.setColumns(10);
		
		txtFim = new JTextField();
		txtFim.setColumns(10);
		txtFim.setBounds(165, 510, 134, 23);
		panel.add(txtFim);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//atualizar a table em relação aos filtros
				//ta com problema no valor final.
				atualizarSemFiltros(filtroArea, filtroCliente, filtroFuncionario);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnNewButton.setBounds(10, 544, 289, 70);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fechar tela");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 625, 289, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(10, 272, 289, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 177, 289, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 85, 289, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data de inicio");
		lblNewLabel_1.setBounds(10, 488, 134, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Final");
		lblNewLabel_1_1.setBounds(165, 488, 134, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 303, 289, 145);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(32, 5, 225, 225);
		lblNewLabel_2.setIcon(new ImageIcon(TelaControleVendas.class.getResource("/images/download (1).jpg")));
		panel_1.add(lblNewLabel_2);
	}
}
