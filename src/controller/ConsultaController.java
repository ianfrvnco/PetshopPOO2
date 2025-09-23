
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pet;


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
}
