package br.edu.unicid.view;

import br.edu.unicid.bean.*;
import br.edu.unicid.dao.*;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TelaOrcamento extends JInternalFrame {
	private JLabel lblServico;
	private JButton btnNewButton;
	private JButton btnConsultar;
	private JButton btnSomar;
	private JTextField txtPreco;
	private JLabel lblPreco;
	private JTextArea txtSoma;
	private JLabel lblSoma;
	private Double soma = 0D;
	private List<Servico> ser;
	private String somar = "";
	private JComboBox cmbservicos;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrcamento frame = new TelaOrcamento();
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
	 * @throws Exception
	 */
	public TelaOrcamento() throws Exception {
		setTitle("Or\u00E7amentos");
		setBounds(100, 100, 641, 501);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(122, 381, 46, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(122, 381, 46, 14);
		getContentPane().add(label_1);

		JLabel lblCalculoDeOramentos = new JLabel("Calculo de Or\u00E7amentos");
		lblCalculoDeOramentos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCalculoDeOramentos.setBounds(179, 11, 241, 39);
		getContentPane().add(lblCalculoDeOramentos);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(-13, -24, 649, 496);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		lblServico = new JLabel("Servico: ");
		lblServico.setBounds(34, 80, 46, 14);
		internalFrame.getContentPane().add(lblServico);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CalculoDAO calculo = new CalculoDAO();
					Double add = Double.parseDouble(txtPreco.getText().toString());
					/*
					 * somar = somar + "<html><br>Servico: " +
					 * cmbservicos.getSelectedItem().toString() + " Valor: R$" + add + "</html>";
					 */

					somar = somar + "\n Servico: " + cmbservicos.getSelectedItem().toString() + " Valor: R$" + add;

					soma = soma + calculo.adicionar(add);

					txtSoma.setText(somar);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAdicionar.setBounds(89, 206, 62, 45);
		internalFrame.getContentPane().add(btnAdicionar);
		btnAdicionar.setIcon(new ImageIcon("C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\adicionar.png"));

		JButton btnSair = new JButton("");
		btnSair.setBounds(89, 297, 62, 45);
		internalFrame.getContentPane().add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaOrcamento telaorcamento = new TelaOrcamento();
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\icons8-sair-26.png"));

		btnSomar = new JButton("");
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				somar = somar + "\n\nValor total: R$" + soma;

				txtSoma.setText(somar.toString());
				soma = 0D;
				somar = "";
			}
		});
		btnSomar.setBounds(538, 206, 62, 45);
		internalFrame.getContentPane().add(btnSomar);

		txtPreco = new JTextField();
		txtPreco.setBounds(89, 108, 128, 20);
		internalFrame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);

		cmbservicos = new JComboBox();
		cmbservicos.setBounds(90, 77, 128, 20);

		ServicoDAO dao = new ServicoDAO();
		ser = dao.listaServico();

		for (int i = 0; i < ser.size(); i++) {
			cmbservicos.addItem(ser.get(i).getDescricao());
		}

		cmbservicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ser.size(); i++) {
					if (ser.get(i).getDescricao().equals(cmbservicos.getSelectedItem().toString())) {
						txtPreco.setText(ser.get(i).getPreco().toString());
					}
				}
			}
		});

		internalFrame.getContentPane().add(cmbservicos);

		lblPreco = new JLabel("Preco: ");
		lblPreco.setBounds(34, 111, 46, 14);
		internalFrame.getContentPane().add(lblPreco);
		internalFrame.setVisible(true);

		txtSoma = new JTextArea();
		txtSoma.setBounds(292, 75, 308, 117);
		internalFrame.getContentPane().add(txtSoma);

		lblSoma = new JLabel("Valor total:");
		lblSoma.setBounds(233, 80, 62, 14);
		internalFrame.getContentPane().add(lblSoma);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				somar = "Relatório de orçamento cancelado.";
				txtSoma.setText(somar.toString());
				somar ="";
				soma=0D;
				
				
			}
		});
		btnCancelar.setBounds(292, 206, 62, 45);
		internalFrame.getContentPane().add(btnCancelar);

	}
}
