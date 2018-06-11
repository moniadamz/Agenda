package persistencia;

public class ContatoDTO {
	private String nome;
	private int telefone;
	
	public String getNome() {
		return nome;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int novoTelefone) {
		this.telefone = novoTelefone;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
}
