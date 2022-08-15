import java.sql.*;

public class Programa {

    // Antes do método main, vamos criar as instruções (scripts) SQL para executar dentro do bloco Try / Catch.

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS animal; CREATE TABLE animal (id INT PRIMARY KEY, nome VARCHAR(64), tipo VARCHAR(32))";

    private static final String sqlInsert1 = "INSERT INTO animal (id, nome, tipo) VALUES (1, 'Meg', 'Cachorro')";

    private static final String sqlInsert2 = "INSERT INTO animal (id, nome, tipo) VALUES (2, 'Mingau', 'Gato')";

    private static final String sqlInsert3 = "INSERT INTO animal (id, nome, tipo) VALUES (3, 'Dumbo', 'Elefante')";

    private static final String sqlInsert4 = "INSERT INTO animal (id, nome, tipo) VALUES (4, 'Pup', 'Cachorro')";

    private static final String sqlInsert5 = "INSERT INTO animal (id, nome, tipo) VALUES (5, 'Pé de pano', 'Cavalo')";

    private static final String sqlDelete = "DELETE FROM animal WHERE id=2";

    public static void main(String[] args) throws SQLException {

        Connection minhaConexao = null;

        try {

            minhaConexao = conectarBD();
            //System.out.println("Conexão efetuada com sucesso ...");
            Statement preparacao = minhaConexao.createStatement();
            preparacao.execute(sqlCreateTable);
            preparacao.execute(sqlInsert1);
            preparacao.execute(sqlInsert2);
            preparacao.execute(sqlInsert3);
            preparacao.execute(sqlInsert4);
            preparacao.execute(sqlInsert5);
            listarTodos(minhaConexao);
            preparacao.execute(sqlDelete);
            listarTodos(minhaConexao);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Programa finalizado!");
            minhaConexao.close();
        }

    }

    // Aqui vamos criar um método para conectar com o banco de dados H2 (Fora do método mais)
    public static Connection conectarBD() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/aula11-animal", "sa", "");
    }

    // Aqui vamos criar um método para listar os registros do banco de dados H2
    public static void listarTodos(Connection minhaConexao) throws SQLException {

        String sqlQuery = "SELECT * FROM animal";
        Statement preparaConsulta = minhaConexao.createStatement();
        ResultSet rs = preparaConsulta.executeQuery(sqlQuery);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1) + " - "
                    + "Nome: " + rs.getString(2) + " - "
                    + "Tipo: " + rs.getString(3));
        }

//        while (rs.next()) {
//            System.out.println("ID: " + rs.getInt("id") + " - "
//            + "Nome: " + rs.getString("nome") + " - "
//            + "Tipo: " + rs.getString("tipo"));
//        }

    }


}
