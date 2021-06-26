package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import negocios.basicos.Cliente;
import negocios.basicos.Funcionario;
import negocios.basicos.Produto;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaGerente extends JFrame {

	int contador = 0;
	private JPanel contentPane;
	private JTable table;
	private static int linha;
	private static int linhaCliente = -1;
	private String campoDeTexto;
	private String campoDeTexto_1;
	private String campoDeTexto_2;
	private String campoDePreco;
	

	private DefaultTableModel dtm;
	
	

	public static int getLinha() {
		return linha;
	}

	public static void setLinha(int linha) {
		TelaGerente.linha = linha;
	}
	

	public static int getLinhaCliente() {
		return linhaCliente;
	}

	public static void setLinhaCliente(int linhaCliente) {
		TelaGerente.linhaCliente = linhaCliente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente frame = new TelaGerente();
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

	public void atualizarJTableFuncionarios() {
		int tamanho = PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().size();
		if (tamanho == 0) {

		} else {
			ArrayList<Funcionario> arrays = new ArrayList<>();
			arrays.addAll(PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios());
			for (int i = 0; i < tamanho; i++) {
				Object[] objs = { arrays.get(i).getNome(), arrays.get(i).getCpf(), arrays.get(i).getTipo() };
				dtm.addRow(objs);
				table.setModel(dtm);
			}
		}
	}

	public void atualizarJTableClientes() {
		int tamanho = PopUpCliente.getCc().getRepositorioClientes().getClientes().size();
		if (tamanho == 0) {

		} else {
			ArrayList<Cliente> arrays = new ArrayList<>();
			arrays.addAll(PopUpCliente.getCc().getRepositorioClientes().getClientes());
			for (int i = 0; i < tamanho; i++) {
				Object[] objs = { arrays.get(i).getNome(), arrays.get(i).getCpf(), arrays.get(i).getEndereco(),
						arrays.get(i).getPontos() };
				dtm.addRow(objs);
				table.setModel(dtm);
			}
		}

	}

	public void atualizarJTableProdutos() {
		int tamanho = PopUpProduto.getCp().getRepositorioProdutos().getProdutos().size();
		if (tamanho == 0) {

		} else {
			ArrayList<Produto> arrays = new ArrayList<>();
			arrays.addAll(PopUpProduto.getCp().getRepositorioProdutos().getProdutos());
			for (int i = 0; i < tamanho; i++) {
				Object[] objs = { arrays.get(i).getNome(), arrays.get(i).getPreco(), arrays.get(i).getDescricao() };
				dtm.addRow(objs);
				table.setModel(dtm);
			}
		}
	}

	public TelaGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel.setBounds(10, 11, 768, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tela do Gerente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(41, 11, 678, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(244, 164, 96));
		panel_1.setBounds(10, 87, 989, 583);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Equipe");
		btnNewButton_1.setBounds(10, 42, 161, 72);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador = 1;
				System.out.println(contador);
				String aux2[] = new String[] { "Funcionario", "CPF", "Tipo" };
				dtm = new DefaultTableModel(aux2, 0);
				table.setModel(dtm);
				atualizarJTableFuncionarios();
				linhaCliente = -1;
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnNewButton_1_1_1 = new JButton("Clientes");
		btnNewButton_1_1_1.setBounds(10, 125, 161, 72);
		panel_1.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador = 2;
				String aux1[] = new String[] { "Nome", "CPF", "Endereco", "Pontos" };
				dtm = new DefaultTableModel(aux1, 0);
				table.setModel(dtm);
				System.out.println(contador);
				atualizarJTableClientes();
				linhaCliente = -1;
				System.out.println(linhaCliente);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("Administrativo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 109, 20);
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton_1_1 = new JButton("Card\u00E1pio");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador = 3;
				String aux[] = new String[] { "Produto", "Valor", "Descricao" };
				dtm = new DefaultTableModel(aux, 0);
				table.setModel(dtm);
				System.out.println(contador);
				System.out.println(contador);
				atualizarJTableProdutos();
				linhaCliente = -1;
			}
		});
		btnNewButton_1_1.setBounds(10, 208, 161, 72);
		panel_1.add(btnNewButton_1_1);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(181, 42, 798, 483);
		panel_1.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (contador == 1) {
					linha = table.getSelectedRow();
					campoDeTexto = dtm.getValueAt(linha, 0).toString();
					System.out.println(campoDeTexto);
					campoDeTexto_1 = dtm.getValueAt(linha, 1).toString();
					System.out.println(campoDeTexto_1);
					campoDeTexto_2 = dtm.getValueAt(linha, 2).toString();
					System.out.println(campoDeTexto_2);
					linhaCliente = -1;
				} else if (contador == 2) {
					linhaCliente = table.getSelectedRow();
					campoDeTexto = dtm.getValueAt(linhaCliente, 0).toString();
					System.out.println(campoDeTexto);
					campoDeTexto_1 = dtm.getValueAt(linhaCliente, 1).toString();
					System.out.println(campoDeTexto_1);
					campoDeTexto_2 = dtm.getValueAt(linhaCliente, 2).toString();
					System.out.println(campoDeTexto_2);
					
				} else if (contador == 3) {
					linha = table.getSelectedRow();
					campoDeTexto = dtm.getValueAt(linha, 0).toString();
					System.out.println(campoDeTexto);
					campoDePreco = dtm.getValueAt(linha, 1).toString();
					campoDeTexto_2 = dtm.getValueAt(linha, 2).toString();
					
				}
			}
		});
		scrollPane.setViewportView(table);

		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 1) {
					PopUpFuncionario popf = new PopUpFuncionario();
					popf.setVisible(true);

				} else if (contador == 2) {
					PopUpCliente popc = new PopUpCliente();
					popc.setVisible(true);

				} else if (contador == 3) {
					PopUpProduto popp = new PopUpProduto();
					popp.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(304, 536, 89, 23);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Remover");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 1) {
					for (int i = 0; i < PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios()
							.size(); i++) {
						if (campoDeTexto.equals(
								PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i).getNome())
								&& campoDeTexto_1.equals(PopUpFuncionario.getCf().getRepositorioFuncionario()
										.getFuncionarios().get(i).getCpf())) {
							PopUpFuncionario.getCf().remover(
									PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(i));
							System.out.println(PopUpFuncionario.getCf());
						}
					}

				} else if (contador == 2) {
					for (int i = 0; i < PopUpCliente.getCc().getRepositorioClientes().getClientes().size(); i++) {
						if (campoDeTexto
								.equals(PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).getNome())
								&& campoDeTexto_1.equals(
										PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).getCpf())) {
							PopUpCliente.getCc()
									.remover(PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i));
							System.out.println(PopUpCliente.getCc());
						}
						
					}

				} else if (contador == 3) {
					for (int i = 0; i < PopUpProduto.getCp().getRepositorioProdutos().getProdutos().size(); i++) {
						if (campoDeTexto == (PopUpProduto.getCp().getRepositorioProdutos().getProdutos().get(i)
								.getNome())) {
							PopUpProduto.getCp()
									.remover(PopUpProduto.getCp().getRepositorioProdutos().getProdutos().get(i));
							System.out.println(PopUpProduto.getCp());
							
						}

					}

				}
			}
		});

		btnNewButton_2_1.setBounds(428, 536, 89, 23);
		panel_1.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Atualizar");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 1) {

					PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(linha)
							.setNome(campoDeTexto);
					PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(linha)
							.setCpf(campoDeTexto_1);
					PopUpFuncionario.getCf().getRepositorioFuncionario().getFuncionarios().get(linha)
							.setTipo(campoDeTexto_2);

				}
				if (contador == 2) {
					PopUpCliente.getCc().getRepositorioClientes().getClientes().get(linhaCliente).setNome(campoDeTexto);
					PopUpCliente.getCc().getRepositorioClientes().getClientes().get(linhaCliente).setCpf(campoDeTexto_1);
					PopUpCliente.getCc().getRepositorioClientes().getClientes().get(linhaCliente).setEndereco(campoDeTexto_2);

				}
				if (contador == 3) {
					PopUpProduto.getCp().getRepositorioProdutos().getProdutos().get(linha)
							.setPreco(Double.parseDouble(campoDePreco));
					PopUpProduto.getCp().getRepositorioProdutos().getProdutos().get(linha).setNome(campoDeTexto);
					PopUpProduto.getCp().getRepositorioProdutos().getProdutos().get(linha).setDescricao(campoDeTexto_2);

				}
			}
		});
		btnNewButton_2_2.setBounds(543, 536, 89, 23);
		panel_1.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("Buscar");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 1) {
					PopUpBuscaFuncionario popbf = new PopUpBuscaFuncionario();
					popbf.setVisible(true);

				} else if (contador == 2) {
					PopUpBuscaCliente popbc = new PopUpBuscaCliente();
					popbc.setVisible(true);

				} else if (contador == 3) {
					PopUpBuscaProduto popbp = new PopUpBuscaProduto();
					popbp.setVisible(true);

				}

			}
		});

		btnNewButton_2_3.setBounds(659, 536, 89, 23);
		panel_1.add(btnNewButton_2_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("PasswordField.border"));
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(788, 11, 466, 64);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_2 = new JLabel("Dados do Usu\u00E1rio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Teste");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 1;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("CPF:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("teste");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JButton btnNewButton = new JButton("Nova Venda");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaNovaVenda tnv = new TelaNovaVenda();
				tnv.setVisible(true);
			}
		});
		btnNewButton.setBounds(1009, 86, 245, 501);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1_2 = new JButton("Vendas");
		btnNewButton_1_2.setBounds(1009, 598, 245, 72);
		contentPane.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaControleVendas tcv = new TelaControleVendas();
				tcv.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
