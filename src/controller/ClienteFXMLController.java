/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * base ; https://medium.com/@antonio.gabriel/javafx-trabalhando-com-tableview-5cc1065babab 
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tables.Cliente;
import controller.DefaultFunctionsController;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class ClienteFXMLController implements Initializable {
    
    @FXML
    private TextField txtId,txtNome,txtEndereco,txtBuscarNome;
    @FXML
    private TableView<ClienteTableController> tbCliente;
    @FXML
    private TableColumn<ClienteTableController, Integer> idCol;
    @FXML
    private TableColumn<ClienteTableController,String> nomeCol;
    @FXML
    private TableColumn<ClienteTableController,String> enderecoCol;
    
    @FXML
    private void saveDataCliente(ActionEvent event){
    if(new DefaultFunctionsController().isNullOrEmpty(txtNome.getText(),txtEndereco.getText()))
    new DefaultFunctionsController().mensagem("Campos vazios!", "Preencha todos os campos !", "Antes de prosseguir verifique se os campos estão preenchidos!", 1);
    else
    executeQuery(1);
    }
    
    @FXML
    private void editDataCliente(ActionEvent event){
    if(new DefaultFunctionsController().isNullOrEmpty(txtId.getText(),txtNome.getText(),txtEndereco.getText()))
    new DefaultFunctionsController().mensagem("Campos vazios!", "Preencha todos os campos !", "Antes de prosseguir verifique se os campos estão preenchidos!", 1);
    else
    executeQuery(2);
    }
    
    @FXML
    private void removeDataCliente(ActionEvent event){
    if(new DefaultFunctionsController().isNullOrEmpty(txtId.getText(),txtNome.getText(),txtEndereco.getText()))
    new DefaultFunctionsController().mensagem("Campos vazios!", "Preencha todos os campos !", "Antes de prosseguir verifique se os campos estão preenchidos!", 1);
    else
    executeQuery(3);
    }
    
    @FXML
    private void consultarNomeClienteKey(KeyEvent event){
    if(txtBuscarNome.getText().isEmpty())
     tbCliente.setItems(listarClientes(1));
    else
     tbCliente.setItems(listarClientes(2));
    }
    
    @FXML
    private void pegarClienteTabela(MouseEvent event){
     ClienteTableController clienteList = tbCliente.getSelectionModel().getSelectedItem();
     if(clienteList != null){
     txtId.setText(clienteList.getId().toString());
     txtNome.setText(clienteList.getNome());
     txtEndereco.setText(clienteList.getEndereco());
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
         listaCliente = clienteController.getAllByNameClienteController(txtBuscarNome.getText());
         break;
     }
    for(Cliente cliente : listaCliente){
    objList.add(new ClienteTableController(cliente.getIdCliente(),cliente.getNome(),cliente.getEndereco()));
    }
   return objList;
  }
     
   //Executar Querys
   private void executeQuery(int id){
    ClienteController objClienteController = new ClienteController();
    Cliente objCliente = this.getDataCliente();
     switch(id){
     case 1: //Salvar
     objClienteController.saveClienteController(objCliente);
     break;
     case 2: //Editar
     objClienteController.updateClienteController(objCliente);
     break;
     case 3: //Remover
     objClienteController.removeClienteController(objCliente);
     break;
     }
    tbCliente.setItems(listarClientes(1));
    new DefaultFunctionsController().clearTextFields(txtId,txtNome,txtEndereco,txtBuscarNome);
    new DefaultFunctionsController().mensagem("Operação realizada!", "Operação realizada com sucesso !", "", 4);
   }
   
   //Pegar dados da interface
   private Cliente getDataCliente(){
     Cliente objCliente = new Cliente();
     objCliente.setIdCliente((txtId.getText().isEmpty()) ? 0 : Integer.parseInt(txtId.getText())); 
     objCliente.setNome(txtNome.getText());
     objCliente.setEndereco(txtEndereco.getText());
     return objCliente;
    }
 
     //Lista de todos os cliente do banco
     private void getAllCliente(){
     ClienteController  clienteController = new  ClienteController();
     List<Cliente> listaCliente = new ArrayList();
     listaCliente = clienteController.getAllClienteController();
     for(Cliente cliente : listaCliente){
      System.out.println(cliente);
      }
     }    
    
}
