import org.apache.log4j.Logger;

import java.sql.*;

public class Programa {

    private static final Logger logger = Logger.getLogger(Programa.class);

    // Instrução para apagar a tabela usuario, caso já exista, criar a tabela usuario
    private static final String sqlCreateTable = "DROP TABLE IF EXISTS usuario; CREATE TABLE usuario "
            + "("
            + " id INT PRIMARY KEY,"
            + " primeiro_nome varchar(100) NOT NULL, "
            + " apelido varchar(100) NOT NULL, "
            + " idade INT NOT NULL "
            + ")";

    // Instruções para inserir dados na tabela usuario
    private static final String sqlInsert1 = "INSERT INTO usuario (id, primeiro_nome, apelido, idade) VALUES (1, 'Maria', 'Mary', 50)";
    private static final String sqlInsert2 = "INSERT INTO usuario (id, primeiro_nome, apelido, idade) VALUES (2, 'José', 'Ze', 18)";
    private static final String sqlInsert3 = "INSERT INTO usuario (id, primeiro_nome, apelido, idade) VALUES (3, 'Felipe', 'Fê', 25)";

    String sqlQuery = "SELECT * FROM usuario";

    // Instrução para excluir um registro da tabela usuario
    private static final String sqlDelete = "DELETE FROM usuario WHERE id=2";

    public static void main(String[] args) throws SQLException {

        Connection minhaConexao = null;

        try {
            logger.info("Conectando com o banco de dados H2...");
            minhaConexao = conectarBD();
            logger.info("Preparando o statement...");
            Statement statement = minhaConexao.createStatement();

            // Executa a instrução de criação de tabela no banco de dados
            logger.info("Enviando para o H2 o script de criação da tabela usuario.");
            statement.execute(sqlCreateTable);

            // Executa as instruções para inserir os dados na tabela

            logger.info("Inserindo 3 usuários na tabela usuario.");
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);

            logger.info("Mostrar usuários antes da deleção.");
            listarTodos(minhaConexao);

            // Executa a instrução para excluir um registro na tabela do BD.
            logger.info("Excluíndo o usuário com o id 2");
            statement.execute(sqlDelete);

            logger.info("Mostrar usuários depois da deleção.");
            listarTodos(minhaConexao);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (minhaConexao == null)
                return;

            minhaConexao.close();
        }
    }

    public static Connection conectarBD() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/a12", "sa", "");
    }

    private static void listarTodos(Connection connection) throws SQLException {
        String sqlQuery = "SELECT * FROM usuario";
        Statement preparaConsulta = connection.createStatement();
        ResultSet rs = preparaConsulta.executeQuery(sqlQuery);

        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt(1) + " - "
                    + "Primeiro nome: " + rs.getString(2) + " - "
                    + "Apelido: " + rs.getString(3) + " - "
                    + "Idade: " + rs.getInt(4));
        }
    }
}