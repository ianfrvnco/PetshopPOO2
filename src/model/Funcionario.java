/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno.saolucas
 */
public class Funcionario {
    
    private int pkFuncionario;
    private String nome, email, senha;
    private boolean ativo;

    public int getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(int pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    public String getAtivoString(){
        if(ativo){
            return "Ativo";
        } else {
            return "Inativo";
        }
    }

    public Funcionario(int pkFuncionario, String nome, String email, String senha, boolean ativo) {
        this.pkFuncionario = pkFuncionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Funcionario() {
    }
    
    public String toString(){
        return nome;
    }
}
