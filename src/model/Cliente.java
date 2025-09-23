/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author aluno.saolucas
 */
public class Cliente {
    
    private int pkCliente;
    private String nome, email;
    private Date dataNasc;

    public int getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(int pkCliente) {
        this.pkCliente = pkCliente;
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

    public Cliente(int pkCliente, String nome, String email, Date dataNasc) {
        this.pkCliente = pkCliente;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public Cliente() {
    }
    
    public String toString(){
        return nome;
    }
    
    
}
