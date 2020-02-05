/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Su
 */
public class ClienteTableController {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome,endereco;
    
    public ClienteTableController(Integer id, String nome,String endereco){
    this.id = new SimpleIntegerProperty(id);
    this.nome = new SimpleStringProperty(nome);
    this.endereco = new SimpleStringProperty(endereco);
    }
    
    //ID
    public Integer getId(){
    return id.get(); 
    }
    
    public SimpleIntegerProperty idProperty(){
    return id;
    }
    
    public void setId(Integer id){
    this.id.set(id);
    }
    
    //NOME
    public String getNome(){
    return nome.get();
    }
    
    public SimpleStringProperty nomeProperty(){
    return nome;
    }
    
    public void setNome(String nome){
    this.nome.set(nome);
    }
    
    //ENDERECO
    public String getEndereco(){
    return endereco.get();
    }
    
    public SimpleStringProperty enderecoProperty(){
    return endereco;
    }
    
    public void setEndereco(String endereco){
    this.endereco.set(endereco);
    }
}
