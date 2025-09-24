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
public class Consulta {
    private int pkConsulta, fk_pkPet, fk_pkFuncionario;
    private String nomePet, emailFuncionario;

    public int getPkConsulta() {
        return pkConsulta;
    }

    public void setPkConsulta(int pkConsulta) {
        this.pkConsulta = pkConsulta;
    }

    public int getFk_pkPet() {
        return fk_pkPet;
    }

    public void setFk_pkPet(int fk_pkPet) {
        this.fk_pkPet = fk_pkPet;
    }

    public int getFk_pkFuncionario() {
        return fk_pkFuncionario;
    }

    public void setFk_pkFuncionario(int fk_pkFuncionario) {
        this.fk_pkFuncionario = fk_pkFuncionario;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }
    
    

    public Consulta() {
    }

    public Consulta(int pkConsulta, int fk_pkPet, int fk_pkFuncionario, String nomePet, String emailFuncionario) {
        this.pkConsulta = pkConsulta;
        this.fk_pkPet = fk_pkPet;
        this.fk_pkFuncionario = fk_pkFuncionario;
        this.nomePet = nomePet;
        this.emailFuncionario = emailFuncionario;
    }
    
    

    public Consulta(int pkConsulta, int fk_pkPet, int fk_pkFuncionario) {
        this.pkConsulta = pkConsulta;
        this.fk_pkPet = fk_pkPet;
        this.fk_pkFuncionario = fk_pkFuncionario;
    }
    
    
}
