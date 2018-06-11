package persistencia;

import java.util.List;

import negocio.Contato;

public interface AgendaDAO {
	ContatoDTO buscarPorNome(String nome);
	void adicionar(ContatoDTO contato) throws AgendaDAOException;
	List<ContatoDTO> buscarTodos() throws AgendaDAOException;
}
