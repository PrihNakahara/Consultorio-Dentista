package br.edu.unicid.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Servico;
import br.edu.unicid.bean.Servico;
import br.edu.unicid.dao.ServicoDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaServicos extends JInternalFrame {
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtCdOrca;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLimpa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServicos frame = new TelaServicos();
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
	public TelaServicos() {
		setTitle("Cadastro de Servi\u00E7o");
		setBounds(100, 100, 458, 371);
		getContentPane().setLayout(null);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(194, 72, 211, 28);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(194, 114, 86, 28);
		getContentPane().add(txtPreco);

		JLabel lblNomeDoServio = new JLabel("Nome do Servi\u00E7o: ");
		lblNomeDoServio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeDoServio.setBounds(24, 74, 136, 21);
		getContentPane().add(lblNomeDoServio);

		JLabel lblValorDoServio = new JLabel("Valor do Servi\u00E7o: ");
		lblValorDoServio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorDoServio.setBounds(24, 116, 136, 21);
		getContentPane().add(lblValorDoServio);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(24, 33, 136, 21);
		getContentPane().add(lblCdigo);

		txtCdOrca = new JTextField();
		txtCdOrca.setColumns(10);
		txtCdOrca.setBounds(194, 33, 86, 28);
		getContentPane().add(txtCdOrca);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(-11, -26, 463, 371);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// =======================
				try {
					Servico Servico;
					ServicoDAO dao = new ServicoDAO();
					int cd = Integer.parseInt(txtCdOrca.getText());
					Servico = dao.procurarServico(cd);
					// mostrar dados
					txtDescricao.setText(Servico.getDescricao());
					txtPreco.setText(String.valueOf(Servico.getPreco()));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro de Consulta");
				}

				// =======================

			}
		});
		btnConsultar.setBounds(192, 196, 75, 46);
		internalFrame.getContentPane().add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.20.20.jpeg"));

		JButton btnSalvar = new JButton("");
		btnSalvar.setBounds(107, 196, 75, 46);
		internalFrame.getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ====================
				Servico Servico = new Servico();
				// populei o objeto Servico
				Servico.setCdOrca(Integer.parseInt(txtCdOrca.getText()));
				Servico.setDescricao(txtDescricao.getText());
				Servico.setPreco(Double.parseDouble(txtPreco.getText()));

				try {
					// chamar a classe ServicoDAO
					ServicoDAO dao = new ServicoDAO();
					dao.salvar(Servico);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				// ====================

			}
		});
		btnSalvar.setIcon(new ImageIcon(
				"C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\WhatsApp Image 2019-05-11 at 22.20.20(1).jpeg"));

		JButton Sair_1 = new JButton("");
		Sair_1.setBounds(36, 264, 75, 46);
		internalFrame.getContentPane().add(Sair_1);
		Sair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaServicos telaservico = new TelaServicos();
				dispose();

			}
		});
		Sair_1.setIcon(new ImageIcon("C:\\Users\\gabriele.costa\\Desktop\\MVCDentista\\icons\\icons8-sair-26.png"));

		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ====================
				Servico Servico = new Servico();
				// populei o objeto Servico
				Servico.setCdOrca(Integer.parseInt(txtCdOrca.getText()));
				Servico.setDescricao(txtDescricao.getText());
				Servico.setPreco(Double.parseDouble(txtPreco.getText()));

				try {
					// chamar a classe ServicoDAO
					ServicoDAO dao = new ServicoDAO();
					dao.atualizar(Servico);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Errou aqui?" + ex.getMessage());
				}

				// ====================

			}
		});
		btnAlterar.setBounds(277, 196, 75, 46);
		internalFrame.getContentPane().add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// =======================
				try {
					ServicoDAO dao = new ServicoDAO();
					int ca = Integer.parseInt(txtCdOrca.getText());
					dao.excluir(ca);
					JOptionPane.showMessageDialog(null, "Excluido");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				// =======================

			}
		});
		btnExcluir.setBounds(362, 196, 75, 46);
		internalFrame.getContentPane().add(btnExcluir);

		btnLimpa = new JButton("");
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtCdOrca.setText(null);
				txtDescricao.setText(null);
				txtPreco.setText(null);

			}
		});
		btnLimpa.setBounds(22, 196, 75, 46);
		internalFrame.getContentPane().add(btnLimpa);
		internalFrame.setVisible(true);

	}
}
