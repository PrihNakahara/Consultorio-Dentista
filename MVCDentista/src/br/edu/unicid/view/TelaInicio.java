package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblConsu;
	private JButton btnCadastroDePaciente;
	private JButton btnSair;
	private JDesktopPane desktopPane;
	private JButton btnCadastroDeServios;
	private JButton btnOramentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 730, 550);
		contentPane.add(desktopPane);

		btnCadastroDePaciente = new JButton("Cadastro de Paciente");
		btnCadastroDePaciente.setBounds(271, 129, 193, 40);
		desktopPane.add(btnCadastroDePaciente);
		btnCadastroDePaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPaciente telapaciente = new TelaPaciente();
				desktopPane.add(telapaciente);
				telapaciente.show();
			}
		});
		btnCadastroDePaciente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));

		lblConsu = new JLabel("Consultorio Odontologico");
		lblConsu.setBounds(225, 64, 313, 40);
		desktopPane.add(lblConsu);
		lblConsu.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));

		btnSair = new JButton("Sair");
		btnSair.setBounds(271, 400, 193, 40);
		desktopPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio frame = new TelaInicio();
				dispose();
			}
		});
		btnSair.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));

		btnCadastroDeServios = new JButton("Cadastro de Servi\u00E7os");
		btnCadastroDeServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaServicos telaservicos = new TelaServicos();
				desktopPane.add(telaservicos);
				telaservicos.show();
			}
		});
		btnCadastroDeServios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnCadastroDeServios.setBounds(271, 180, 193, 40);
		desktopPane.add(btnCadastroDeServios);

		btnOramentos = new JButton("Or\u00E7amentos");
		btnOramentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOrcamento telaorcamentos;
				try {
					telaorcamentos = new TelaOrcamento();
					desktopPane.add(telaorcamentos);
					telaorcamentos.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnOramentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnOramentos.setBounds(271, 231, 193, 40);
		desktopPane.add(btnOramentos);
	}

}
