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
public class AluguelTableController {
 
    private final SimpleIntegerProperty id_aluguel;
    private final SimpleStringProperty  data_aluguel;
    private final SimpleStringProperty  data_devolucao;
    private final SimpleIntegerProperty fk_idCliente;
    private final SimpleIntegerProperty fk_idFilme;
    
    
   public AluguelTableController(Integer id_aluguel, String data_aluguel, String data_devolucao, Integer fk_idCliente, Integer fk_idFilme){
    this.id_aluguel = new SimpleIntegerProperty(id_aluguel);
    this.data_aluguel = new SimpleStringProperty(data_aluguel);
    this.data_devolucao =  new SimpleStringProperty(data_devolucao);
    this.fk_idCliente = new SimpleIntegerProperty(fk_idCliente);
    this.fk_idFilme = new SimpleIntegerProperty(fk_idFilme);
    }
    
    //ID do aluguel
    public Integer getId_aluguel(){
    return id_aluguel.get(); 
    }
    
    public SimpleIntegerProperty id_aluguelProperty(){
    return id_aluguel;
    }
    
    public void setId_aluguel(Integer id_aluguel){
    this.id_aluguel.set(id_aluguel);
    }
    
    //Data_aluguel do aluguel
    public String getData_aluguel(){
    return data_aluguel.get(); 
    }
    
    public SimpleStringProperty data_aluguelProperty(){
    return data_aluguel;
    }
    
    public void setData_aluguel(String data_aluguel){
    this.data_aluguel.set(data_aluguel);
    }
    
    //Data_devolucao do aluguel
    public String getData_devolucao(){
    return data_devolucao.get(); 
    }
    
    public SimpleStringProperty data_devolucaoProperty(){
    return data_devolucao;
    }
    
    public void setData_devolucao(String data_devolucao){
    this.data_devolucao.set(data_devolucao);
    }
    
    //Fk_idCliente do aluguel
    public Integer getFk_idCliente(){
    return fk_idCliente.get(); 
    }
    
    public SimpleIntegerProperty fk_idClienteProperty(){
    return fk_idCliente;
    }
    
    public void setFk_idCliente(Integer fk_idCliente){
    this.fk_idCliente.set(fk_idCliente);
    }
    
    //Fk_idFilme do aluguel

    public Integer getFk_idFilme(){
    return fk_idFilme.get(); 
    }
    
    public SimpleIntegerProperty fk_idFilmeProperty(){
    return fk_idFilme;
    }
    
    public void setFk_idFilme(Integer fk_idFilme){
    this.fk_idFilme.set(fk_idFilme);
    }
    

    
}
