/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author aluno.saolucas
 */
public class Cliente {
    
    private int pkUsuario;
    private String nome, email;
    private Date dataNasc;

    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Cliente(int pkUsuario, String nome, String email, Date dataNasc) {
        this.pkUsuario = pkUsuario;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public Cliente() {
    }
    
    
}
