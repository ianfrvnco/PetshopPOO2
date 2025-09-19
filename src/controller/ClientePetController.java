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
import model.Pet;

/**
 *
 * @author aluno.saolucas
 */
public class ClientePetController {
    
    public List<Pet> consultar(String idCliente) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT p.* FROM PET p INNER JOIN relacao r on r.fkPet = p.pkPet WHERE fkCliente= "+idCliente;

        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários, vazia ainda
        List<Pet> lista = new ArrayList<>();

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha
            //caso consiga retorna true
            while (resultado.next()) {
                Pet pe = new Pet();

                pe.setPkPet(resultado.getInt("pkPet"));
                pe.setNome(resultado.getString("Nome"));
                pe.setTipo(resultado.getString("Tipo"));
                pe.setPelagem(resultado.getString("Pelagem"));
                pe.setIdade(resultado.getInt("Idade"));

                lista.add(pe);
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
}
