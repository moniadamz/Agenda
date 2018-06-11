package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.Contato;

public class AgendaDAODTODerby implements AgendaDAO{
	
	public List<ContatoDTO> buscarTodos() throws AgendaDAOException{
	 List<ContatoDTO> contatos = new ArrayList<>();
     String sql = "select * from contato";
     try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
         try (Statement comando = conexao.createStatement()) {
             try (ResultSet resultado = comando.executeQuery(sql)) {
                 while (resultado.next()) {
                	 ContatoDTO contato = new ContatoDTO();
                     contato.setTelefone(resultado.getInt("telefone"));
                     contato.setNome(resultado.getString("nome"));
                     contatos.add(contato);
                 }
                 return contatos;
             }
         }
     } catch (Exception e) {
         throw new AgendaDAOException("Falha na busca", e);
     }
 }
	
	public void adicionar(ContatoDTO contato) throws AgendaDAOException {
	        String sql = "insert into contato(telefone, nome) values(?,?)";
	        int resultado = 0;
	        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
	            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
	                comando.setInt(1, contato.getTelefone());
	                comando.setString(2, contato.getNome());
	                resultado = comando.executeUpdate();
	            }
	        } catch (Exception e) {
	            throw new AgendaDAOException("Falha na inserção", e);
	        }
	        if (resultado == 0) {
	            throw new AgendaDAOException("Falha na inserção");
	        }
	    }

	@Override
	public ContatoDTO buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}
