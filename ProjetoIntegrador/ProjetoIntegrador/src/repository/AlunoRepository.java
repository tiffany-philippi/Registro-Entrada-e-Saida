package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Aluno;
import model.Responsavel;

public class AlunoRepository {

	public void persistir(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO alunos VALUES ('"+ aluno.getMatricula() + "','" + aluno.getCpfResp() + "','" + 
					aluno.getTelefoneResp() + "','" + aluno.getNomeAluno() + "','" + aluno.getEnderecoAluno() + aluno.getEmailAluno() + 
					aluno.getPeriodo() + aluno.getCursando() + aluno.getTranspPublico() + "','" + "','" + "','" + "','" + "');";
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Aluno consultar(String matricula) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM alunos WHERE matricula = '" + matricula + "';";
		Aluno aluno = null;
		
		try (Connection conn = ConexaoBD.getConexao()) {
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		String matricula = null;
		String cpfResp = null;
		String telefoneResp = null;
		String nomeAluno = null;
		String enderecoAluno = null;
		String emailAluno = null;
		String periodo = null;
		String cursando = null;
		String transpPublico = null;
		
			while(resultSet.next()) {
				matricula = resultSet.getString("matricula");
				cpfResp = resultSet.getString("cpf_resp");
				telefoneResp = resultSet.getString("telefone_resp");
				nomeAluno = resultSet.getString("nome_aluno");
				enderecoAluno = resultSet.getString("endereco_aluno");
				emailAluno = resultSet.getString("email_aluno");
				periodo = resultSet.getString("cursando");
				cursando = resultSet.getString("periodo");
				transpPublico = resultSet.getString("transp_publico");

				aluno = new Aluno();
				System.out.println("Matr�cula: " + matricula + "\nCPF do respons�vel: " + cpfResp + 
						"\nTelefone do respons�vel: " + telefoneResp + "\nNome do aluno: " + nomeAluno + "\nEndere�o: " + enderecoAluno 
						+ "\nEmail: " + emailAluno +"\nPer�odo: " + periodo + "\nCursando: " + cursando + 
						"\nTransporte p�blico: " + transpPublico +"\n");
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return aluno;
		
		
	}
	
	public void remover(String cpfResp) throws SQLException {
		
		String sql = "DELETE FROM alunos WHERE cpf_resp = '" + cpfResp + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizarRespNome(Aluno aluno) throws SQLException {
		String sql = "UPDATE alunos SET nome_resp = '" + aluno.getMatricula() + "' WHERE nome_aluno = '" + aluno.getNomeAluno() + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void atualizarRespTelefone(Responsavel aluno) throws SQLException {
		String sql = "UPDATE alunos SET telefone_resp = '" + aluno.getFoneResp() + "' WHERE cpf_resp = '" + aluno.getCPFResp() + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void atualizarRespEmail(Responsavel aluno) throws SQLException {
		String sql = "UPDATE alunos SET email_resp = '" + aluno.getEmailResp() + "' WHERE cpf_resp = '" + aluno.getCPFResp() + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
