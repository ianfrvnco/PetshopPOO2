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
public class Pet {
    private int pkPet, idade;
    private String nome, tipo, pelagem;

    public int getPkPet() {
        return pkPet;
    }

    public void setPkPet(int pkPet) {
        this.pkPet = pkPet;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Pet() {
    }

    public Pet(int pkPet, int idade, String nome, String tipo, String pelagem) {
        this.pkPet = pkPet;
        this.idade = idade;
        this.nome = nome;
        this.tipo = tipo;
        this.pelagem = pelagem;
    }
    
    public String toString(){
        return nome;
    }
}
