package negocio;

import java.util.ArrayList;
import java.util.List;

import persistencia.AgendaDAO;
import persistencia.AgendaDAOException;
import persistencia.ContatoDTO;

public class AdaptadorNegocioPersistenciaAgenda {
	 private AgendaDAO dao;
	    
	    public AdaptadorNegocioPersistenciaAgenda(AgendaDAO dao){
	        this.dao = dao;
	    }
	    
	    public void inserir(Contato contato) throws AgendaDAOException{
	    	ContatoDTO dto = transformarparaDTO(contato);
	        dao.adicionar(dto);
	    }
	    
	    public List<Contato> buscarTodos() throws AgendaDAOException{
	        List<ContatoDTO> original = dao.buscarTodos();
	        List<Contato> transformado = new ArrayList<>();
	        for(ContatoDTO ed : original){
	            transformado.add(transformardeDTO(ed));
	        }
	        return transformado;
	    }
	    
	    private Contato transformardeDTO(ContatoDTO dto){
	        return new Contato(dto.getNome(), dto.getTelefone());
	    }
	    
	    private ContatoDTO transformarparaDTO(Contato c){
	        ContatoDTO dto = new ContatoDTO();
	        dto.setTelefone(c.getTelefone());
	        dto.setNome(c.getNome());
	        return dto;
	    }
}
