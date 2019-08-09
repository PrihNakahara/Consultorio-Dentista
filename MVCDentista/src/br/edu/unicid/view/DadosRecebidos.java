package br.edu.unicid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class DadosRecebidos extends JFrame {

	private JPanel contentPane;
	private JTextArea txtRecebidos;
	private JTextArea txtRecebido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosRecebidos frame = new DadosRecebidos();
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
	public DadosRecebidos() {
		getContentPane().setLayout(null);

		txtRecebido = new JTextArea();
		txtRecebido.setBounds(33, 28, 352, 195);
		getContentPane().add(txtRecebido);

		TelaPaciente tel = new TelaPaciente();
		txtRecebidos.setText(tel.getRecebido());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtRecebidos = new JTextArea();
		txtRecebidos.setBounds(37, 31, 352, 193);
		contentPane.add(txtRecebidos);
	}
}
