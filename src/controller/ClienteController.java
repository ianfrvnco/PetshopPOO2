/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import utils.Util;

public class ClienteController {

    public boolean inserir(Cliente c) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO CLIENTE(nome, email, datanasc) VALUES (?,?,?)";

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável (?) pela posição em que aparecem
            comando.setString(1, c.getNome());
            comando.setString(2, c.getEmail());
            comando.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            comando.executeUpdate();
            return true;

        } catch (SQLException e) {

            //caso ocorra um erro relacio0nado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }

        return false;

    }

    public List<Cliente> consultar(String filtro) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "";

        if (filtro.equals("")) {
            sql = "SELECT * FROM CLIENTE;";
        } else {
            sql = "SELECT * FROM CLIENTE WHERE pkCliente= " + filtro;
        }

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários, vazia ainda
        List<Cliente> lista = new ArrayList<>();

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha
            //caso consiga retorna true
            while (resultado.next()) {
                Cliente cl = new Cliente();

                cl.setPkCliente(resultado.getInt("pkCliente"));
                cl.setNome(resultado.getString("nome"));
                cl.setEmail(resultado.getString("email"));
                cl.setDataNasc(resultado.getDate("dataNasc"));

                lista.add(cl);
            }
        } catch (SQLException e) {

            //caso ocorra um erro relacio0nado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;

    }

    public boolean alterar(Cliente c) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE CLIENTE SET "
                + " nome = ?, " 
                + " email = ?, " 
                + " datanasc = ?, "
                + " WHERE pkCliente = ? ";


        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável(?) pela posição em que aparece no sql
            comando.setString(1, c.getNome());
            comando.setString(2, c.getEmail());
            comando.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));

            comando.setInt(4, c.getPkCliente());

            //executa o comando 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}
