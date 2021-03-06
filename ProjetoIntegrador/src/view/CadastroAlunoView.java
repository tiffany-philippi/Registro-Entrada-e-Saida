package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JProgressBar;

public class CadastroAlunoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtaMat;
	private JTextField txtNomeAluno;
	private JTextField txtEndAluno;
	private JTextField txtEmailAluno;
	private JTextField txtCursando;
	private JTextField txtTranspp;
	private JTextField txtPeriodo;
	private JTextField txtcpfResp;
	private JTextField txtFoneResp;
	private String matricula;
	private String cpfResp;
	private String foneResp;
	private String nome;
	private String endereco;
	private String email;
	private String cursando;
	private String periodo;
	private String transpp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunoView frame = new CadastroAlunoView();
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
	public CadastroAlunoView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 727, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha os dados do aluno:");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(134, 21, 216, 14);
		contentPane.add(lblPreenchaOsDados);
				
		JLabel lblCpf = new JLabel("Matr\u00EDcula:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(20, 58, 98, 14);
		contentPane.add(lblCpf);
		
		txtaMat = new JTextField();
		txtaMat.setBounds(128, 56, 222, 20);
		contentPane.add(txtaMat);
		txtaMat.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(30, 83, 88, 14);
		contentPane.add(lblNome);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(128, 81, 222, 20);
		contentPane.add(txtNomeAluno);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(20, 108, 98, 14);
		contentPane.add(lblEndereo);
		
		txtEndAluno = new JTextField();
		txtEndAluno.setColumns(10);
		txtEndAluno.setBounds(128, 106, 222, 20);
		contentPane.add(txtEndAluno);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(40, 133, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(128, 131, 222, 20);
		contentPane.add(txtEmailAluno);
		
		JLabel lblCursando = new JLabel("Cursando:");
		lblCursando.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCursando.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCursando.setBounds(40, 183, 78, 14);
		contentPane.add(lblCursando);
		
		txtCursando = new JTextField();
		txtCursando.setColumns(10);
		txtCursando.setBounds(128, 181, 222, 20);
		contentPane.add(txtCursando);
		
		JLabel lblPeríodo = new JLabel("Per\u00EDodo:");
		lblPeríodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeríodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPeríodo.setBounds(40, 158, 78, 14);
		contentPane.add(lblPeríodo);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(128, 156, 222, 20);
		contentPane.add(txtPeriodo);
		
		JLabel lblTransportePblico = new JLabel("Transp. p\u00FAblico:");
		lblTransportePblico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransportePblico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportePblico.setBounds(20, 208, 98, 14);
		contentPane.add(lblTransportePblico);
		
		txtTranspp = new JTextField();
		txtTranspp.setColumns(10);
		txtTranspp.setBounds(128, 206, 222, 20);
		contentPane.add(txtTranspp);
		
		JLabel lblPreenchaOsDados_1 = new JLabel("Preencha os dados do respons\u00E1vel:");
		lblPreenchaOsDados_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados_1.setBounds(445, 95, 243, 14);
		contentPane.add(lblPreenchaOsDados_1);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf_1.setBounds(348, 129, 98, 14);
		contentPane.add(lblCpf_1);
		
		txtcpfResp = new JTextField();
		txtcpfResp.setColumns(10);
		txtcpfResp.setBounds(456, 127, 222, 20);
		contentPane.add(txtcpfResp);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(360, 152, 88, 14);
		contentPane.add(lblTelefone);
		
		txtFoneResp = new JTextField();
		txtFoneResp.setColumns(10);
		txtFoneResp.setBounds(456, 152, 222, 20);
		contentPane.add(txtFoneResp);
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			CadastroAlunoView frame = new CadastroAlunoView();
			
			Aluno aluno = new Aluno();
			
			matricula = aluno.setMatricula(txtaMat.getText());
			cpfResp = aluno.setCpfResp(txtcpfResp.getText());
			foneResp = aluno.setTelefoneResp(txtFoneResp.getText());
			nome = aluno.setNomeAluno(txtNomeAluno.getText());
			endereco = aluno.setEnderecoAluno(txtEndAluno.getText());
			email = aluno.setEmailAluno(txtEmailAluno.getText());
			cursando = aluno.setCursando(txtCursando.getText());
			periodo = aluno.setPeriodo(txtPeriodo.getText());
			transpp = aluno.setTranspPublico(txtTranspp.getText());
			
			AlunoController contr = new AlunoController();
			
			try {
				contr.persistir(aluno);					
				btnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MessageSucess msgSucesso = new MessageSucess();
						msgSucesso.setVisible(true);
					}
				});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				btnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MessageError msgError = new MessageError();
						msgError.setVisible(true);
					}
				});
				e.printStackTrace();
			}
			}
		});		
	
		btnInserir.setBounds(602, 245, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(503, 245, 89, 23);
		contentPane.add(btnVoltar);
		

	}
}
