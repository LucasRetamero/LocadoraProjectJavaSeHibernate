/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Su
 */
@Entity(name = "genero")
@Table(name = "tbl_genero")
public class Genero {
    
    @Id
    @GeneratedValue
    @Column(name = "id_genero")
    private int id_genero;
    
    @Column(name = "nome")
    private String nome;
    
    public Genero(){
    
    }
    
    public Genero(String nome){
    this.nome = nome;
    }

    /**
     * @return the id_genero
     */
    public int getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
            
    
}
