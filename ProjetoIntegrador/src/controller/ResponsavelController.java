package controller;

import java.sql.SQLException;

import model.Responsavel;
import repository.ResponsavelRepository;

public class ResponsavelController {
	private ResponsavelRepository repository;
	
	public ResponsavelController() {
		this.repository = new ResponsavelRepository();
	}
	
	/**
	 * M�todo para salvar o Respons�vel no reposit�rio.
	 * @param responsavel Novo respons�vel
	 * @throws SQLException 
	 */

	public void persistir(Responsavel responsavel) throws SQLException {
		this.repository.persistir(responsavel);
	}
	
	public Responsavel consultar(String cpfResp) {
		return null;
	}
	
	public void excluir (String cpfResp) {
		
	}

	public void alterar(String cpfResp, String nomeAtual) {
		
	}
	
	 
	
	
}