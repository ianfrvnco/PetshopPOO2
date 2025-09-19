/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author aluno.saolucas
 */
public class FuncionarioController {
    public boolean autenticar(String email, String senha) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from FUNCIONARIO WHERE email = ? and senha = ? and ativo = 1";

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável (?) pela posição em que aparecem
            comando.setString(1, email);
            comando.setString(2, senha);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha
            //caso consiga retorna true
            if (resultado.next()) {
                //Se conseguyiu acançar para a prox linha é porquê achou 
                return true;
            }
        } catch (SQLException e) {

            //caso ocorra um erro relacio0nado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }

        return false;

    }
    
    public boolean inserir(String nome, String email, String senha) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "INSERT INTO FUNCIONARIO (nome, email, senha, ativo) VALUES (?, ?, ?, 1)";

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável (?) pela posição em que aparecem
            comando.setString(1, nome);
            comando.setString(2, email);
            comando.setString(3, senha);

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
            gerenciador.fecharConexao(comando, resultado);
        }

        return false;

    }
    
    public List<Funcionario> consultar(String filtro) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "";
        
        if (filtro.equals("")) {
            sql = "SELECT * FROM FUNCIONARIO;";
        } else {
            sql = "SELECT * FROM FUNCIONARIO WHERE pkFuncionario= " + filtro;
        }

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários, vazia ainda
        List<Funcionario> lista = new ArrayList<>();

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha
            //caso consiga retorna true
            while (resultado.next()) {
                Funcionario fu = new Funcionario();

                fu.setPkFuncionario(resultado.getInt("pkFuncionario"));
                fu.setNome(resultado.getString("Nome"));
                fu.setEmail(resultado.getString("Email"));
                fu.setAtivo(resultado.getBoolean("Ativo"));
                fu.setSenha(resultado.getString("Senha"));

                lista.add(fu);
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
    
    public boolean alterar(Funcionario f) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE FUNCIONARIO SET "
                + " nome = ?, " 
                + " email = ?, " 
                + " senha = ?, "
                + " ativo = ?  " 
                + " WHERE pkFuncionario = ? ";


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
            //comando.setInt(1, c.getPkCliente());
            comando.setString(1, f.getNome());
            comando.setString(2, f.getEmail());
            comando.setString(3, f.getSenha());
            comando.setBoolean(4, f.isAtivo());
            comando.setInt(5, f.getPkFuncionario());

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
