package PopUps;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.PopUpCliente;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUpAuxCliente extends JFrame {
	
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoEndereco;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpAuxCliente frame = new PopUpAuxCliente("","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	
	public PopUpAuxCliente()
	{
		
	}
	 */
	
	public PopUpAuxCliente(String nome, String cpf, String endereco) {
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
		
		
		campoCpf = new JTextField();
		campoCpf.setBounds(5, 60, 424, 20);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		campoCpf.setText(cpf);
		
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(5, 115, 424, 20);
		contentPane.add(campoEndereco);
		campoEndereco.setColumns(10);
		campoEndereco.setText(endereco);
		
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PopUpCliente.getCc().getRepositorioClientes().getClientes().size(); i++) {
				if(nome == PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).getNome() 
						&& cpf == PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).getCpf()
						&& endereco == PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).getEndereco())
					{
						PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).setNome(campoNome.getText());
						PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).setCpf(campoCpf.getText());
						PopUpCliente.getCc().getRepositorioClientes().getClientes().get(i).setEndereco(campoEndereco.getText());
					}
				
				}
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(174, 179, 89, 23);
		contentPane.add(btnNewButton);
	}

}
