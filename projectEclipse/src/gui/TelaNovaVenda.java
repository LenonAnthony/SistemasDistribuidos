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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import negocios.ControladorVenda;
import negocios.basicos.Produto;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaNovaVenda extends JFrame {

	ControladorVenda cv = new ControladorVenda();
	DefaultTableModel dtm;
	DefaultTableModel dtm1;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEndereo;
	private JTable table_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_1;
	private JButton btnNewButton_3;
	private JTable table;
	private JTextField txtValorFinal;
	private int linha;
	private int linhaCarrinho;
	private String campoDeTexto;
	private String campoDeTexto_1;
	private String campoDeTexto_2;
	private ArrayList<Produto> produtosNoCarrinho = new ArrayList<>();
	public double valorCarrinho;

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

	public void mostrarJTableProdutos() {
		int tamanho = PopUpProduto.getCp().getRepositorioProdutos().getProdutos().size();
		if (tamanho == 0) {

		} else {
			ArrayList<Produto> arrays = new ArrayList<>();
			arrays.addAll(PopUpProduto.getCp().getRepositorioProdutos().getProdutos());
			for (int i = 0; i < tamanho; i++) {
				Object[] objs = { arrays.get(i).getNome(), arrays.get(i).getPreco(), arrays.get(i).getQuantidade() };
				dtm.addRow(objs);
				table.setModel(dtm);
			}
		}
	}

	public void adicionarAoCarrinho() {
		ArrayList<Produto> arrays = new ArrayList<>();
		arrays.addAll(PopUpProduto.getCp().getRepositorioProdutos().getProdutos());
		Object[] objs = { arrays.get(linha).getNome(), arrays.get(linha).getPreco(),
				arrays.get(linha).getQuantidade() };
		Produto pTest = new Produto(arrays.get(linha).getNome(), arrays.get(linha).getDescricao(),
				arrays.get(linha).getQuantidade(), arrays.get(linha).getPreco(), false);
		produtosNoCarrinho.add(pTest);
		dtm1.addRow(objs);
		table_1.setModel(dtm1);
	}

	public void removerDoCarrinho() {

		produtosNoCarrinho.remove(linhaCarrinho);
		dtm1.removeRow(linhaCarrinho);

	}

	public double atualizarValorFinal() {
		int tamanho = produtosNoCarrinho.size();
		double valorFinal = 0;
		for (int i = 0; i < tamanho; i++) {
			valorFinal = valorFinal + produtosNoCarrinho.get(i).getPrecoFinal();

		}
		txtValorFinal.setText(String.valueOf(valorFinal));
		return valorFinal;
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
		if (TelaGerente.getLinhaCliente() == -1) {
			txtNome.setText("Nome: ");
		} else {
			txtNome.setText("Nome: " + PopUpCliente.getCc().getRepositorioClientes().getClientes()
					.get(TelaGerente.getLinha()).getNome());
		}
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setBounds(10, 40, 247, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.LEFT);
		if (TelaGerente.getLinhaCliente() == -1) {
			txtCpf.setText("CPF: ");
		} else {
			txtCpf.setText("CPF: "
					+ PopUpCliente.getCc().getRepositorioClientes().getClientes().get(TelaGerente.getLinha()).getCpf());
		}

		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 71, 247, 20);
		panel.add(txtCpf);

		txtEndereo = new JTextField();
		if (TelaGerente.getLinhaCliente() == -1) {
			txtEndereo.setText("Endereco: ");
		} else {
			txtEndereo.setText("Endere\u00E7o: " + PopUpCliente.getCc().getRepositorioClientes().getClientes()
					.get(TelaGerente.getLinha()).getEndereco());
		}

		txtEndereo.setColumns(10);
		txtEndereo.setBounds(10, 104, 247, 20);
		panel.add(txtEndereo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 11, 967, 414);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linha = table.getSelectedRow();
				campoDeTexto = dtm.getValueAt(linha, 0).toString();
				System.out.println(campoDeTexto);
				campoDeTexto_1 = dtm.getValueAt(linha, 1).toString();
				System.out.println(campoDeTexto_1);
				campoDeTexto_2 = dtm.getValueAt(linha, 2).toString();
				System.out.println(campoDeTexto_2);
				System.out.println("Linha: " +linha);
			}
		});
		scrollPane.setViewportView(table);
		String aux1[] = new String[] { "Produto", "Preco", "Quantidade" };
		dtm = new DefaultTableModel(aux1, 0);
		table.setModel(dtm);
		mostrarJTableProdutos();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(287, 436, 977, 233);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		dtm1 = new DefaultTableModel(aux1, 0);
		table_1.setModel(dtm1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linhaCarrinho = table_1.getSelectedRow();
				campoDeTexto = dtm.getValueAt(linhaCarrinho, 0).toString();
				System.out.println(campoDeTexto);
				campoDeTexto_1 = dtm.getValueAt(linhaCarrinho, 1).toString();
				System.out.println(campoDeTexto_1);
				campoDeTexto_2 = dtm.getValueAt(linhaCarrinho, 2).toString();
				System.out.println(campoDeTexto_2);
				
				System.out.println("LinhaCarrinho:" +linhaCarrinho);

			}
		});
		scrollPane_1.setViewportView(table_1);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAoCarrinho();
				valorCarrinho = atualizarValorFinal();
				System.out.println(valorCarrinho);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 166, 267, 55);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerDoCarrinho();
				atualizarValorFinal();
			}
		});
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

		txtValorFinal = new JTextField();
		txtValorFinal.setText("Valor Final:");
		txtValorFinal.setHorizontalAlignment(SwingConstants.LEFT);
		txtValorFinal.setColumns(10);
		txtValorFinal.setBounds(10, 73, 247, 20);
		panel_1.add(txtValorFinal);
		btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(10, 343, 267, 55);
		contentPane.add(btnNewButton_3);

	}
}
