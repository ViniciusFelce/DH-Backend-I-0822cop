import org.apache.log4j.Logger;

import java.sql.*;

public class Programa {
    private static final Logger logger = Logger.getLogger(Programa.class);

    // Instrução para apagar a tabela usuario, caso já exista, criar a tabela usuario
    private static final String sqlCreateTable = "DROP TABLE IF EXISTS figuraGeomet; CREATE TABLE figuraGeomet "
            + "("
            + " id INT PRIMARY KEY,"
            + " figura varchar(100) NOT NULL, "
            + " cor varchar(100) NOT NULL "
            + ")";

    // Instruções para inserir dados na tabela figuraGeomet
    private static final String sqlInsert1 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (1, 'circulo', 'verde')";
    private static final String sqlInsert2 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (2, 'circulo', 'vermelho')";
    private static final String sqlInsert3 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (3, 'circulo', 'roxo')";
    private static final String sqlInsert4 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (4, 'quadrado', 'amarelo')";
    private static final String sqlInsert5 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (5, 'quadrado', 'azul')";
    private static final String sqlInsert6 = "INSERT INTO figuraGeomet (id, figura, cor) VALUES (6, 'triangulo', 'rosa')";

    String sqlQuery = "SELECT * FROM figuraGeomet";

    // Instrução para excluir um registro da tabela figuraGeomet
    private static final String sqlDelete = "DELETE FROM figuraGeomet WHERE id=3";

    //private static final String sqlSelect = "SELECT * FROM 'figuraGeomet' WHERE 'figura' = 'circulo' AND 'cor' = 'vermelho'";

    public static void main(String[] args) throws SQLException {

        Connection minhaConexao = null;

        try {
            logger.info("Conectando com o banco de dados H2...");
            minhaConexao = conectarBD();
            logger.info("Preparando o statement...");
            Statement statement = minhaConexao.createStatement();

            // Executa a instrução de criação de tabela no banco de dados
            logger.info("Enviando para o H2 o script de criação da tabela figuraGeomet.");
            statement.execute(sqlCreateTable);

            // Executa as instruções para inserir os dados na tabela
            logger.info("Inserindo 3 figuraGeomet na tabela figuraGeomet.");
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);
            statement.execute(sqlInsert6);
          //statement.execute(sqlDelete);
            System.out.println("-------- Lista Anterior! ----------------");

            logger.info("Mostrar figuraGeomet antes da deleção.");
            listarTodos(minhaConexao);

            System.out.println(" ");
            System.out.println("-------- Lista Atualizado! ----------------");

            // Executa a instrução para excluir um registro na tabela
            logger.info("Excluíndo o figuraGeomet com o id 2");
            statement.execute(sqlDelete);

            //logger.info("Excluíndo o figuraGeomet com o id 2");
            //statement.execute(sqlSelect);

            logger.info("Mostrar figuraGeomet depois da deleção.");
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
        return DriverManager.getConnection("jdbc:h2:~/figGeo", "vini", "");
    }

    private static void listarTodos(Connection connection) throws SQLException {
        String sqlQuery = "SELECT * FROM figuraGeomet ";
        Statement preparaConsulta = connection.createStatement();
        ResultSet rs = preparaConsulta.executeQuery(sqlQuery);

        while (rs.next()) {
            System.out.println(
                              "ID: " + rs.getInt(1) + " - "
                            + "Figura Geometrica: " + rs.getString(2) + " - "
                            + "Cor: " + rs.getString(3));
        }
    }
}
