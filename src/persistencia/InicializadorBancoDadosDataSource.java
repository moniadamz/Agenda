package persistencia;

	import java.sql.Connection;
	import java.sql.Statement;
	import javax.sql.DataSource;
	import org.apache.derby.jdbc.EmbeddedDataSource;

	/**
	 *
	 * @author Júlio
	 */
	public class InicializadorBancoDadosDataSource {

	    public static String DB_NAME = "cadastro";
	    public static String USER_NAME = "usuario";
	    public static String PASSWORD = "senha";
	    private static DataSource dataSource;

	    private static DataSource criarDataSource() throws Exception {
	        if (dataSource == null) {
	            EmbeddedDataSource ds = new EmbeddedDataSource();
	            ds.setDatabaseName(DB_NAME);
	            ds.setCreateDatabase("create");
	            ds.setUser(USER_NAME);
	            ds.setPassword(PASSWORD);
	            dataSource = ds;
	        }
	        return dataSource;
	    }

	    public static void criarBd() throws Exception {
	        try (Connection con = criarDataSource().getConnection();
	                Statement sta = con.createStatement()) {
	            String sqlContato = "CREATE TABLE CONTATO("
	                    + "NOME varchar(100) NOT NULL,"
	                    + "TELEFONE INT NOT NULL)";
	            sta.executeUpdate(sqlContato);	        }
	    }

	    public static Connection conectarBd() throws Exception {
	        return criarDataSource().getConnection();
	    }
	}
