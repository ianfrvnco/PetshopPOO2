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
public class Venda {
    private Date dataVenda;
    private double valorTotal;
    private int pkVenda, fk_pkCliente;
    private String emailCliente;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getFk_pkCliente() {
        return fk_pkCliente;
    }

    public void setFk_pkCliente(int fk_pkCliente) {
        this.fk_pkCliente = fk_pkCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getPkVenda() {
        return pkVenda;
    }

    public void setPkVenda(int pkVenda) {
        this.pkVenda = pkVenda;
    }
    

    public Venda() {
    }

    public Venda(Date dataVenda, double valorTotal, String emailCliente, int pkVenda) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.emailCliente = emailCliente;
        this.pkVenda = pkVenda;
    }

    public Venda(Date dataVenda, double valorTotal, int pkVenda, int fk_pkCliente, String emailCliente) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.pkVenda = pkVenda;
        this.fk_pkCliente = fk_pkCliente;
        this.emailCliente = emailCliente;
    }
    
    
    
    public String toString(){
        return emailCliente;
        
    }
    
    
    
}
