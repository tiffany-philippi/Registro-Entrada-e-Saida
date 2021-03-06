package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;
import controller.ResponsavelController;
import model.Aluno;
import model.Periodo;
import model.SimNao;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class AlunoConsultView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMat;
	private JTable table;

	private String matricula;
	private String cpfResp;
	private String foneResp;
	private String nome;
	private String endereco;
	private String email;
	private SimNao cursando;
	private Periodo periodo;
	private SimNao transpp;

	ResponsavelController respControl = new ResponsavelController(); // Controller responsável pelas interações de
																		// Responsável
	AlunoController alunoControl = new AlunoController(); // Controller responsável pelas interações de Aluno

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoConsultView frame = new AlunoConsultView();
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
	public AlunoConsultView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 618, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTXT = new JLabel("Preencha o campo com a matrícula do aluno que deseja consultar");
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTXT.setBounds(42, 21, 514, 14);
		contentPane.add(lblTXT);

		JLabel lblMat = new JLabel("Matrícula:");
		lblMat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMat.setBounds(42, 63, 108, 14);
		contentPane.add(lblMat);

		txtMat = new JTextField();
		txtMat.setBounds(160, 58, 244, 26);
		contentPane.add(txtMat);
		txtMat.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 175, 602, 43);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "Matr\u00EDcula", "CPF respons.", "Fone respons.", "Nome", "Endere\u00E7o",
								"Email", "Per\u00EDodo", "Cursando", "Transp. p\u00FAblico" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane.setViewportView(table);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				matricula = txtMat.getText();
				Aluno aluno = null;
				try {
					aluno = alunoControl.consultar(matricula);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MessageError msgError = new MessageError();
					msgError.setVisible(true);

				}

				if (aluno != null) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
								{ aluno.getMatricula(), aluno.getCpf_resp(), aluno.getTelefone_resp(), aluno.getNome(), aluno.getEndereco_aluno(), aluno.getEmail_aluno(), aluno.getPeriodo(), aluno.getCursando(), aluno.getTransPublico() }, },
						new String[] { "Matr\u00EDcula", "CPF respons.", "Fone respons.", "Nome", "Endere\u00E7o",
								"Email", "Per\u00EDodo", "Cursando", "Transp. p\u00FAblico" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				}
			}
		});

		btnConsultar.setBounds(414, 60, 89, 23);
		contentPane.add(btnConsultar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 602, 2);
		contentPane.add(separator);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(503, 232, 89, 23);
		contentPane.add(btnVoltar);
	}
}
