package negocio;

public class Contato {
	private String nome;
	private int telefone;
	
	public Contato(String novoNome, int novoTelefone) {
		this.nome = novoNome;
		this.telefone = novoTelefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int novoTelefone) {
		this.telefone = novoTelefone;
	}
}