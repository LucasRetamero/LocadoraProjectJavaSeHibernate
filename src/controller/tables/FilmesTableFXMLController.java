/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import controller.ClienteController;
import controller.ClienteTableController;
import controller.FilmeController;
import controller.FilmeTableController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import tables.Cliente;
import tables.Filme;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class FilmesTableFXMLController implements Initializable {
   
    //Id do filme
    private String idFilme;
    @FXML
    private TextField txtBuscarNome;
    @FXML
    private TableView<FilmeTableController> tbFilmes;
    @FXML
    private TableColumn<FilmeTableController, Integer> id_FilmeCol;
    @FXML
    private TableColumn<FilmeTableController,String> tituloCol;
    @FXML
    private TableColumn<FilmeTableController,String> generoCol;
    
    @FXML
    private void pegarFilmeTabela(MouseEvent event){
     FilmeTableController filmeList = tbFilmes.getSelectionModel().getSelectedItem();
     if(filmeList != null){
     this.setIdFilme(filmeList.getId_Filme().toString());
     ((Node)(event.getSource())).getScene().getWindow().hide();
     }
    }
    
    @FXML
    private void consultarTituloFilmeKey(KeyEvent event){
    if(txtBuscarNome.getText().isEmpty())
     tbFilmes.setItems(listarFilmes(1));
    else
     tbFilmes.setItems(listarFilmes(2));
    }
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //definindo a FilmeTableController class
      id_FilmeCol.setCellValueFactory(new PropertyValueFactory<>("id_Filme"));
      tituloCol.setCellValueFactory(new PropertyValueFactory<>("titulo"));
      generoCol.setCellValueFactory(new PropertyValueFactory<>("genero"));
      //add info na tabela da interface
      tbFilmes.setItems(listarFilmes(1));
    }
    
   //Dados para tabela da interface
    private ObservableList<FilmeTableController> listarFilmes(int id){
    ObservableList<FilmeTableController>  objList =  FXCollections.observableArrayList();
    FilmeController  filmeController = new  FilmeController();
    List<Filme> listaFilme = new ArrayList(); 
    switch(id){
        case 1: //Todos os clientes
         listaFilme = filmeController.getAllFilmeController();
         break;
        case 2: //Todoso os cliente pelo nome
         listaFilme = filmeController.getAllByTitleFilmeController(txtBuscarNome.getText());
         break;
     }
    for(Filme filme : listaFilme){
    objList.add(new FilmeTableController(filme.getId_filme(),filme.getTitulo(),filme.getGenero()));
    }
   return objList;
  }
    
    /**
     * @return the idFilme
     */
    public String getIdFilme() {
        return idFilme;
    }

    /**
     * @param idFilme the idFilme to set
     */
    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    
    
}
