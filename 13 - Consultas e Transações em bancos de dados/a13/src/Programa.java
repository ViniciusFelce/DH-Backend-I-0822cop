import entities.Conta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Programa {

    private static final Logger LOGGER = Logger.getLogger(Programa.class);

    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS conta; CREATE TABLE conta (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(64), numConta VARCHAR(16), saldoAtual DOUBLE)";

    private static final String INSERT_TABLE = "INSERT INTO conta (nome, numconta, saldoatual) VALUES (?, ?, ?)"; // 1 2 3

    private static final String UPDATE_TABLE = "UPDATE conta SET saldoAtual=? WHERE id=?";

    public static void main(String[] args) throws SQLException {

        Conta c1 = new Conta("Bill Gates", "5544-1", 0.0);

        Connection conexao = null;

        try {
            conexao = conectarBD();
            Statement statement = conexao.createStatement();
            LOGGER.info("Criando a tabela conta no banco de dados.");
            statement.execute(CREATE_TABLE);

            PreparedStatement inserirDados = conexao.prepareStatement(INSERT_TABLE);
            inserirDados.setString(1, c1.getNome());
            inserirDados.setString(2, c1.getNumconta());
            inserirDados.setDouble(3, c1.getSaldo());
            LOGGER.info("Inserindo o Bill Gates na conta corrente - Banco de Dados.");
            inserirDados.execute();
        }
        catch (Exception e) {
            LOGGER.error("Erro ao acessao o H2: ", e);
        }
        finally {
            if (conexao == null) {
                return; // Se entrar neste If não executa a linha do conexao.close();
            }
            conexao.close();
        }

    }

    // Aqui vamos criar um método para conectar com o banco de dados H2 (Fora do método mais)
    public static Connection conectarBD() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/aula13", "sa", "");
    }

}
