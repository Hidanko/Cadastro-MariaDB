package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    private static String endereco;
    private static Connection connection;
    private static Statement statement;
    private static Statement  command;
    private static ResultSet data;
    private static DatabaseHandler INSTANCE;
    
    
    public DatabaseHandler getInstance() {
        if (INSTANCE == null){
            INSTANCE = new DatabaseHandler();
        }
        return INSTANCE;
    }
    
    public boolean connectar () throws SQLException{
        endereco = "jdbc:mariadb://localhost:3306/mariadb" ;
        connection = DriverManager.getConnection(endereco);
        command = connection.createStatement();
        command.execute("INSERT INTO cadastros");
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
