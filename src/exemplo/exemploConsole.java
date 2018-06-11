package exemplo;


import java.util.List;

import negocio.AdaptadorNegocioPersistenciaAgenda;
import negocio.Contato;
import persistencia.AgendaDAO;
import persistencia.AgendaDAODTODerby;
import persistencia.InicializadorBancoDadosDataSource;

public class exemploConsole {

	public static void main(String[] args) throws Exception {
	
		System.out.println("Criando BD...");
        InicializadorBancoDadosDataSource.criarBd();
		
        //System.out.println("Conectando BD...");
        //InicializadorBancoDadosDataSource.conectarBd();
        
        AgendaDAO dao = new AgendaDAODTODerby();
        AdaptadorNegocioPersistenciaAgenda repositorio = new AdaptadorNegocioPersistenciaAgenda(dao);
        System.out.println("Inserir contatos...");
        repositorio.inserir(new Contato("Monica", 5864600));
        repositorio.inserir(new Contato("Pearson", 5451200));
        
        System.out.println("\nListando contatos...");
        List<Contato> contatos = repositorio.buscarTodos();
        for (Contato contato : contatos) {
            System.out.println(contato.getNome());
        }
	}
}
