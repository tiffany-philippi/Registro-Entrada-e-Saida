package model;

public class Responsavel extends Pessoa {
	
	private String cpfResp;
	private String telefone;
	
	public Responsavel(String cpfResp, String nome, String endereco, String telefoneResp, String email) {
		super(nome, endereco, email);

		this.cpfResp = cpfResp;
		this.telefone = telefoneResp;
	}
	
	public String getCPFResp () {
		return cpfResp;
	}
	public String getFoneResp () {
		return telefone;
	}
	
	
}