package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import entities.Medicamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    // Injeções de dependências
    private ConfiguracaoJDBC configuracaoJDBC;

    // Construtor que recebe o Configuração JDBC
    public MedicamentoDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    // Este método recebe um medicamento e retorna o medicamento.
    @Override
    public Medicamento salvar(Medicamento medicamento) {

        Connection conexao = configuracaoJDBC.conectarComBandoDeDados();
        Statement statement = null;

        String queryInsert = String.format("INSERT INTO medicamentos (nome, laboratorio, quantidade, preco) VALUES ('%s', '%s', '%s', '%s')", medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());

        try {
            statement = conexao.createStatement();
            statement.executeUpdate(queryInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                medicamento.setId(rs.getInt(1));
            }
            statement.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return medicamento;
    }
}
