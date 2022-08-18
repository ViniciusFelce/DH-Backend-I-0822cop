package dao.impl;

import dao.IDao;
import dao.config.ConfigJDBC;
import entities.Paciente;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfigJDBC configJDBC;

    public PacienteDaoH2(ConfigJDBC configJDBC) {
        this.configJDBC = configJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {

        Connection connection = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "INSERT INTO pacientes " +
                        "(nome, sobrenome, rg, datacadastro, endereco) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
                paciente.getDatacadastro(),
                paciente.getEndereco()
        );

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection conexao = configJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT * FROM pacientes";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                pacientes.add(criarObjetoPaciente(result));
            }
            stmt.close();
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }

    private Paciente criarObjetoPaciente(ResultSet resultado) throws SQLException {
        Integer id = resultado.getInt(1);
        String nome = resultado.getString(2);
        String sobrenome = resultado.getString(3);
        String rg = resultado.getString(4);
        Date datacadastro = resultado.getDate(5);
        String endereco = resultado.getString(6);
        return new Paciente(id, nome, sobrenome, rg, datacadastro, endereco);
    }

}
