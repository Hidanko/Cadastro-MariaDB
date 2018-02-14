package backend;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private PreparedStatement command;
    private static ResultSet rs;
    private static DatabaseHandler INSTANCE;
    private boolean conectado;
    private StringBuilder birl;

    public static DatabaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHandler();
        }
        return INSTANCE;
    }

    public boolean conectar() {
        conectado = false;
        endereco = "jdbc:mariadb://localhost:3306/mariadb";
        try {
            connection = DriverManager.getConnection(endereco, "root", "");
            System.out.println("Conectado ao banco!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        conectado = true;
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

    public boolean conectado() {
        conectar();
        return conectado;
    }

    public void imprimir() {
        try {
            command = connection.prepareStatement("SELECT * FROM cadastros");
            rs = command.executeQuery();
            
            int contador = 0;
            while (new File ("banco"+contador+".txt").exists()){
                contador++;
            }
            String arquivoTxt = "banco"+contador+".txt";
            
            FileWriter fw = new FileWriter(arquivoTxt, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            while (rs.next()) {
                birl = new StringBuilder();
                birl.append(rs.getString("Nome"));
                birl.append('#');
                birl.append(rs.getString("CPF"));
                birl.append('#');
                birl.append(rs.getString("Telefone"));
                birl.append('#');
                birl.append(rs.getString("Email"));
                birl.append('#');
                birl.append(rs.getString("Logradouro"));
                birl.append('#');
                birl.append(rs.getString("Numero"));
                birl.append('#');
                birl.append(rs.getString("Complemento"));
                birl.append('#');
                birl.append(rs.getString("Bairro"));
                birl.append('#');
                birl.append(rs.getString("Localidade"));
                birl.append('#');
                birl.append(rs.getString("UF"));
                birl.append('#');
                birl.append(rs.getString("Obs"));
                
                pw.println(birl);
            }

            pw.close();
            
            Desktop.getDesktop().open(new File(arquivoTxt));
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO NO BANCO");
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO CRIANDO ARQUIVO TXT");
        }
    }
}
