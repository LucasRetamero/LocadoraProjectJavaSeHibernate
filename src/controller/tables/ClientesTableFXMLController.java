/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import controller.AluguelFXMLController;
import controller.ClienteController;
import controller.ClienteTableController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import tables.Cliente;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class ClientesTableFXMLController implements Initializable {
    
    //Id do filme
    private String idCliente;
    
    @FXML
    private TextField txtBuscarCliente;
    @FXML
    private TableView<ClienteTableController> tbCliente;
    @FXML
    private TableColumn<ClienteTableController, Integer> idCol;
    @FXML
    private TableColumn<ClienteTableController,String> nomeCol;
    @FXML
    private TableColumn<ClienteTableController,String> enderecoCol;
    
    @FXML
    private void consultarNomeClienteKey(KeyEvent event){
    if(txtBuscarCliente.getText().isEmpty())
     tbCliente.setItems(listarClientes(1));
    else
     tbCliente.setItems(listarClientes(2));
    }
    
    @FXML
    private void pegarClienteTabela(MouseEvent event){
     ClienteTableController clienteList = tbCliente.getSelectionModel().getSelectedItem();
     if(clienteList != null){
     this.setIdCliente(clienteList.getId().toString());
     ((Node)(event.getSource())).getScene().getWindow().hide();
     }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //definindo a ClienteTableController class
      idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
      nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
      enderecoCol.setCellValueFactory(new PropertyValueFactory<>("endereco"));
     //add info na tabela da interface
     tbCliente.setItems(listarClientes(1));
    }    
    
   //Dados para tabela da interface
   private ObservableList<ClienteTableController> listarClientes(int id){
    ObservableList<ClienteTableController>  objList =  FXCollections.observableArrayList();
    ClienteController  clienteController = new  ClienteController();
    List<Cliente> listaCliente = new ArrayList(); 
    switch(id){
        case 1: //Todos os clientes
         listaCliente = clienteController.getAllClienteController();
         break;
        case 2: //Todoso os cliente pelo nome
         listaCliente = clienteController.getAllByNameClienteController(txtBuscarCliente.getText());
         break;
     }
    for(Cliente cliente : listaCliente){
    objList.add(new ClienteTableController(cliente.getIdCliente(),cliente.getNome(),cliente.getEndereco()));
    }
   return objList;
  }   

    /**
     * @return the idFilme
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idFilme the idFilme to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
}
