package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cadastro;

public class DatabaseHandler {

    private static String endereco;
    private static Connection connection;
    private  PreparedStatement command;
    private static ResultSet data;
    private static DatabaseHandler INSTANCE;
    private boolean conectado;

    public static DatabaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHandler();
        }
        return INSTANCE;
    }

    public boolean connectar() {
        endereco = "jdbc:mariadb://localhost:3306/mariadb";
        try {
            connection = DriverManager.getConnection(endereco, "root", "");
            System.out.println("Conectado ao banco!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean inserir(Cadastro cadastro) {
        try {
            command = connection.prepareStatement("INSERT INTO cadastros (Nome, CPF, Telefone, Email, Logradouro, Numero, Complemento, Bairro, Localidade, UF, Obs) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            command.setString(1, cadastro.getNome());
            command.setString(2, cadastro.getCPF());
            command.setInt(3, cadastro.getTelefone());
            command.setString(4, cadastro.getEmail());
            command.setString(5, cadastro.getLogradouro());
            command.setInt(6, cadastro.getNumero());
            command.setString(7, cadastro.getComplemento());
            command.setString(8, cadastro.getBairro());
            command.setString(9, cadastro.getLocalidade());
            command.setString(10, cadastro.getUF());
            command.setString(11, cadastro.getObs());
            command.execute();
            command.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
