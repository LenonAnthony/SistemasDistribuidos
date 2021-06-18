package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class TelaControleVendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtParamtro;
	private JTextField txtInicio;
	private JTextField txtFim;

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
	public TelaControleVendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 11, 926, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(10, 11, 309, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filtros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 289, 27);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Area");
		rdbtnNewRadioButton.setBounds(6, 45, 54, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Funcion\u00E1rio");
		rdbtnNewRadioButton_1.setBounds(94, 45, 103, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Cliente");
		rdbtnNewRadioButton_2.setBounds(233, 45, 66, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		txtParamtro = new JTextField();
		txtParamtro.setText("Param\u00EAtro");
		txtParamtro.setBounds(10, 83, 289, 36);
		panel.add(txtParamtro);
		txtParamtro.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Per\u00EDodo");
		rdbtnNewRadioButton_3.setBounds(6, 142, 75, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		txtInicio = new JTextField();
		txtInicio.setText("Inicio");
		txtInicio.setBounds(10, 179, 134, 23);
		panel.add(txtInicio);
		txtInicio.setColumns(10);
		
		txtFim = new JTextField();
		txtFim.setText("Fim");
		txtFim.setColumns(10);
		txtFim.setBounds(165, 179, 134, 23);
		panel.add(txtFim);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(94, 226, 125, 70);
		panel.add(btnNewButton);
	}
}
