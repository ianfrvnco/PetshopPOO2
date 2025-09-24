
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Funcionario;
import model.Pet;

// SELECT c.*, p.nome, f.nome FROM CONSULTAS C inner join pet p on c.fk_pkPet = p.pkPet inner join funcionario f on c.fk_pkFuncionario = f.pkFuncionario;

public class ConsultaController {
    
    public boolean inserir(Funcionario f, Pet p){
    //Montar o comando a ser executado
    //os ? são variáveis que são preenchidas mais adiante
    String sql = "INSERT INTO CONSULTAS (fk_pkFuncionario, fk_pkPet) "
               + " VALUES (?,?)";
    
    //Cria uma instância do gerenciador de conexão
    //(conexão com o banco de dados),
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    
    //Declara as variáveis como nulas antes do try 
    //para poder usar no finally
    PreparedStatement comando = null;
    
    try{
      //prepara o sql, analisando o formato e as váriaveis
      comando = gerenciador.prepararComando(sql);
      
      //define o valor de cada variável(?) pela posição em que aparece no sql
      comando.setInt(1, f.getPkFuncionario());
      comando.setInt(2, p.getPkPet());
      
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

    public List<Consulta> consultar() {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT c.*, p.nome, f.email FROM CONSULTAS C "
                + "inner join pet p on c.fk_pkPet = p.pkPet "
                + "inner join funcionario f on c.fk_pkFuncionario = f.pkFuncionario;";


        //Cria uma instância do gerenciador de conexão
        //Conexão com o banco de dados
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis com nulas antes do try
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a lista de usuários, vazia ainda
        List<Consulta> lista = new ArrayList<>();

        try {
            //prepara o sql, analisandoi o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha
            //caso consiga retorna true
            while (resultado.next()) {
                Consulta c = new Consulta();

                c.setPkConsulta(resultado.getInt("pkConsulta"));
                c.setNomePet(resultado.getString("nome"));
                c.setEmailFuncionario(resultado.getString("email"));
                

                lista.add(c);
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
