package br.edu.unicid.view;

import br.edu.unicid.bean.*;
import br.edu.unicid.dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.DefaultComboBoxModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

public class TelaPaciente extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblCdCliente;
	private JLabel lblNomeCliente;
	private JLabel lblEmailCliente;
	private JLabel lblDataDeNascimento;
	private JLabel lblEndereoCliente;
	private JLabel lblIdadeCliente;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JTextField txtCdCliente;
	private JTextField txtNomeCliente;
	private JTextField txtEmailCliente;
	private JTextField txtEndCliente;
	private JTextField txtIdadeCliente;
	private JButton btnConsultar;
	private JButton btnExcluso;
	private JButton btnAlterar;
	private JLabel lblEnderecoCliente;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JCheckBox chckbxConvenio;
	private JButton btnSair;
	private JComboBox cmbEstadoCivil;

	private JComboBox comboBox;
	private JMonthChooser monthChooser;
	private JDateChooser dateChooser;
	private JInternalFrame internalFrame;
	private String recebido;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		setTitle("Cadastro de Pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCdCliente = new JLabel("Codigo Cliente");
		lblCdCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCdCliente.setBounds(29, 11, 203, 30);
		contentPane.add(lblCdCliente);

		lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomeCliente.setBounds(29, 52, 175, 30);
		contentPane.add(lblNomeCliente);

		lblEmailCliente = new JLabel("Email Cliente");
		lblEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmailCliente.setBounds(29, 93, 188, 30);
		contentPane.add(lblEmailCliente);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDataDeNascimento.setBounds(29, 134, 203, 30);
		contentPane.add(lblDataDeNascimento);

		lblEndereoCliente = new JLabel("Endereco Cliente");
		lblEndereoCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEndereoCliente.setBounds(29, 216, 203, 30);
		contentPane.add(lblEndereoCliente);

		lblIdadeCliente = new JLabel("Idade Cliente");
		lblIdadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblIdadeCliente.setBounds(29, 175, 175, 30);
		contentPane.add(lblIdadeCliente);

		txtCdCliente = new JTextField();
		txtCdCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCdCliente.setBounds(281, 12, 264, 30);
		contentPane.add(txtCdCliente);
		txtCdCliente.setColumns(10);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(281, 53, 264, 30);
		contentPane.add(txtNomeCliente);

		txtEmailCliente = new JTextField();
		txtEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(281, 94, 264, 30);
		contentPane.add(txtEmailCliente);

		txtEndCliente = new JTextField();
		txtEndCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndCliente.setColumns(10);
		txtEndCliente.setBounds(281, 217, 264, 30);
		contentPane.add(txtEndCliente);

		txtIdadeCliente = new JTextField();
		txtIdadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIdadeCliente.setColumns(10);
		txtIdadeCliente.setBounds(281, 176, 264, 30);
		contentPane.add(txtIdadeCliente);

		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.20.19.jpeg"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ====================
				Cliente cliente = new Cliente();
				// populei o objeto Cliente
				cliente.setcdCliente(Integer.parseInt(txtCdCliente.getText()));
				cliente.setnomeCliente(txtNomeCliente.getText());
				cliente.setemailCliente(txtEmailCliente.getText());
				cliente.setDtaNasc(dateChooser.getDate());
				cliente.setidadeCliente(Integer.parseInt(txtIdadeCliente.getText()));
				cliente.setendCliente(txtEndCliente.getText());
				cliente.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString());
				cliente.setTelefone(Integer.parseInt(txtTelefone.getText()));
				cliente.setConvenio(chckbxConvenio.isSelected());

				try {
					// chamar a classe ClienteDAO
					ClienteDAO dao = new ClienteDAO();
					dao.atualizar(cliente);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errou aqui?" + e.getMessage());
				}

				// ====================

			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlterar.setBounds(567, 268, 90, 50);
		contentPane.add(btnAlterar);

		lblEnderecoCliente = new JLabel("Estado Civil");
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEnderecoCliente.setBounds(29, 257, 203, 30);
		contentPane.add(lblEnderecoCliente);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTelefone.setBounds(29, 295, 203, 30);
		contentPane.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(281, 299, 264, 30);
		contentPane.add(txtTelefone);

		chckbxConvenio = new JCheckBox("Convenio?");
		chckbxConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 21));
		chckbxConvenio.setBounds(29, 343, 203, 23);
		contentPane.add(chckbxConvenio);

		cmbEstadoCivil = new JComboBox();
		cmbEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] { "Selecione:" }));
		cmbEstadoCivil.setBounds(281, 258, 264, 29);

		ArrayList<String> lista = new ArrayList<>();
		lista.add("Casado(a)");
		lista.add("Solteira(a)");
		lista.add("Viuvo(a)");
		lista.add("Divorciado(a)");

		for (int i = 0; i < lista.size(); i++) {
			cmbEstadoCivil.addItem(lista.get(i));
		}
		contentPane.add(cmbEstadoCivil);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(281, 134, 264, 30);
		dateChooser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dateChooser.setForeground(new Color(0, 0, 0));
		contentPane.add(dateChooser);

		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(-12, -26, 685, 517);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		btnNovo = new JButton("");
		btnNovo.setBounds(32, 375, 96, 49);
		internalFrame.getContentPane().add(btnNovo);
		btnNovo.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.59.52.jpeg"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ==================
				txtCdCliente.setText(null);
				txtNomeCliente.setText(null);
				txtEmailCliente.setText(null);
				dateChooser.setDate(null);
				txtIdadeCliente.setText(null);
				txtEndCliente.setText(null);
				cmbEstadoCivil.setSelectedItem(null);
				txtTelefone.setText(null);
				chckbxConvenio.setSelected(false);

				// ==================
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSalvar = new JButton("");
		btnSalvar.setBounds(150, 375, 96, 48);
		internalFrame.getContentPane().add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.20.20(1).jpeg"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ====================

				Cliente Cliente = new Cliente();
				// populei o objeto Cliente
				Cliente.setcdCliente(Integer.parseInt(txtCdCliente.getText()));
				Cliente.setnomeCliente(txtNomeCliente.getText());
				Cliente.setemailCliente(txtEmailCliente.getText());
				Cliente.setDtaNasc(dateChooser.getDate());
				Cliente.setidadeCliente(Integer.parseInt(txtIdadeCliente.getText()));
				Cliente.setendCliente(txtEndCliente.getText());
				Cliente.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString());
				Cliente.setTelefone(Integer.parseInt(txtTelefone.getText()));
				Cliente.setConvenio(chckbxConvenio.isSelected());

				try {
					// chamar a classe ClienteDAO
					ClienteDAO dao = new ClienteDAO();
					dao.salvar(Cliente);
					recebido = "Codigo: " + txtCdCliente.getText() + "\nNome: " + txtNomeCliente.getText() + "\nE-mail:"
							+ txtEmailCliente.getText() + "\nData de nascimento:" + dateChooser.getDate()
							+ "\nIdade do cliente:" + txtIdadeCliente.getText() + "\nEndereço:"
							+ txtEndCliente.getText() + "\nEstado Civil:" + cmbEstadoCivil.getSelectedItem().toString()
							+ "\nTelefone:" + Integer.parseInt(txtTelefone.getText()) + "\nConveniado:"
							+ chckbxConvenio.isSelected();
					JOptionPane.showMessageDialog(null, "Dados Recebidos com sucesso:\n" + recebido);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				// ====================
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnConsultar = new JButton("");
		btnConsultar.setBounds(270, 375, 90, 51);
		internalFrame.getContentPane().add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.20.20.jpeg"));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// =======================
				try {
					Cliente Cliente;
					ClienteDAO dao = new ClienteDAO();
					int cd = Integer.parseInt(txtCdCliente.getText());
					Cliente = dao.procurarcliente(cd);
					// mostrar dados
					txtNomeCliente.setText(Cliente.getnomeCliente());
					txtEmailCliente.setText(Cliente.getemailCliente());
					dateChooser.setDate(Cliente.getDtaNasc());
					txtIdadeCliente.setText(String.valueOf(Cliente.getidadeCliente()));
					txtEndCliente.setText(Cliente.getendCliente());
					cmbEstadoCivil.setSelectedItem(Cliente.getEstadoCivil());
					txtTelefone.setText(String.valueOf(Cliente.getTelefone()));
					chckbxConvenio.setSelected(Cliente.isConvenio());

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro de Consulta");
				}

				// =======================
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnExcluso = new JButton("");
		btnExcluso.setBounds(382, 375, 84, 51);
		internalFrame.getContentPane().add(btnExcluso);
		btnExcluso.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.30.36.jpeg"));
		btnExcluso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// =======================
				try {
					ClienteDAO dao = new ClienteDAO();
					int ca = Integer.parseInt(txtCdCliente.getText());
					dao.excluir(ca);
					JOptionPane.showMessageDialog(null, "Excluido");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				// =======================

			}
		});
		btnExcluso.setFont(new Font("Tahoma", Font.PLAIN, 22));

		btnSair = new JButton("");
		btnSair.setBounds(575, 375, 84, 49);
		internalFrame.getContentPane().add(btnSair);
		btnSair.setIcon(new ImageIcon("C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\icons8-sair-26.png"));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPaciente frame = new TelaPaciente();
				dispose();
			}
		});
		internalFrame.setVisible(true);

		// recebido = "Codigo: " + txtCdCliente.getText() + "\nNome: " +
		// txtNomeCliente.getText();

		/*
		 * Cliente.setcdCliente(Integer.parseInt(txtCdCliente.getText()));
		 * Cliente.setnomeCliente(txtNomeCliente.getText());
		 * Cliente.setemailCliente(txtEmailCliente.getText());
		 * Cliente.setDtaNasc(dateChooser.getDate());
		 * Cliente.setidadeCliente(Integer.parseInt(txtIdadeCliente.getText()));
		 * Cliente.setendCliente(txtEndCliente.getText());
		 * Cliente.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString());
		 * Cliente.setTelefone(Integer.parseInt(txtTelefone.getText()));
		 * Cliente.setConvenio(chckbxConvenio.isSelected());
		 */

	}

	public String getRecebido() {
		return recebido;
	}

	public void setRecebido(String recebido) {
		this.recebido = recebido;
	}
}
