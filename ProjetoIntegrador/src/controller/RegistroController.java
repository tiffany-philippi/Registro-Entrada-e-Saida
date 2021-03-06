package controller;

import java.sql.SQLException;

import model.Aluno;
import model.Registro;
import model.Responsavel;
import repository.AlunoRepository;
import repository.RegistroRepository;

public class RegistroController {
	
private RegistroRepository repository;
	
	public RegistroController() {
		this.repository = new RegistroRepository();
	}

/**
 * Método para salvar o Registro no repositório.
 * @param registro Novo registro
 * @throws SQLException 
 */

	public void persistir(Registro registro) throws SQLException {
		this.repository.persistir(registro);
	}

	public Registro consultar(String matricula) throws SQLException{
		return this.repository.consultar(matricula);
	}
	
	public void excluir (String codPront) throws SQLException {
		this.repository.remover(codPront);
	}

}


