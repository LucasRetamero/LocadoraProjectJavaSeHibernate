/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FilmeTableController {
    
    private SimpleIntegerProperty id_Filme;
    private SimpleStringProperty titulo;
    private SimpleStringProperty genero;
    
    public FilmeTableController(Integer id_Filme,String titulo,String genero){
    this.id_Filme = new SimpleIntegerProperty(id_Filme);
    this.titulo = new SimpleStringProperty(titulo);
    this.genero =  new SimpleStringProperty(genero);
    
    }
    
    //ID do filme
    public Integer getId_Filme(){
    return id_Filme.get(); 
    }
    
    public SimpleIntegerProperty id_FilmeProperty(){
    return id_Filme;
    }
    
    public void setId_Filme(Integer id_Filme){
    this.id_Filme.set(id_Filme);
    }
    
    //Titulo do filme
    public String getTitulo(){
    return titulo.get(); 
    }
    
    public SimpleStringProperty tituloProperty(){
    return titulo;
    }
    
    public void setTitulo(String titulo){
    this.titulo.set(titulo);
    }
    
    //Genero do filme
    public String getGenero(){
    return genero.get(); 
    }
    
    public SimpleStringProperty generoProperty(){
    return genero;
    }
    
    public void setGnero(String genero){
    this.genero.set(genero);
    }
    
}
