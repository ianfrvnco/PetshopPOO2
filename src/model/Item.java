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
public class Item {
    private int pkItem, quantidade;
    private String nome;
    private double preco;
    private boolean disponivel;

    public int getPkItem() {
        return pkItem;
    }

    public void setPkItem(int pkItem) {
        this.pkItem = pkItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Item() {
    }

    public Item(int pkItem, int quantidade, boolean disponivel, String nome, double preco) {
        this.pkItem = pkItem;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.nome = nome;
        this.preco = preco;
    }
    
    public String toString(){
        return nome;
    }
    
    
}
