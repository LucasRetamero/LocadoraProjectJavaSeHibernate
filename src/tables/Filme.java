/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity( name = "Filme")
@Table( name = "tbl_filme")
public class Filme {
    
    @Id
    @GeneratedValue
    @Column( name = "id_filme")
    private int id_filme;
    
    @Column( name = "titulo")
    private String titulo;
    
    @Column( name = "genero")
    private String genero;

    public Filme(){
    
    }
    
    public Filme(String titulo, String genero){
    this.titulo = titulo;
    this.genero = genero;
    }
    
    /**
     * @return the id_filme
     */
    public int getId_filme() {
        return id_filme;
    }

    /**
     * @param id_filme the id_filme to set
     */
    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
