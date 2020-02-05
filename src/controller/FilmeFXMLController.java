/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import dao.GeneroDAO;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tables.Genero;
import tables.Filme;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class FilmeFXMLController implements Initializable {

    @FXML
    private TextField txtIdFilme;
    @FXML
    private TextField txtNomeFilme;
    @FXML
    private TextField txtBuscarNome;
    @FXML
    private ComboBox cbGeneros;
    @FXML
    private TableView<FilmeTableController> tbFilmes;
    @FXML
    private TableColumn<FilmeTableController, Integer> id_FilmeCol;
    @FXML
    private TableColumn<FilmeTableController, String> tituloCol;
    @FXML
    private TableColumn<FilmeTableController, String> generoCol;

    @FXML
    public void cadastrarFilme(ActionEvent event) {
        if (new DefaultFunctionsController().isNullOrEmpty(txtNomeFilme.getText()) || cbGeneros.getSelectionModel().getSelectedIndex() == 0) {
            new DefaultFunctionsController().mensagem("Aviso", "Verique se os campos estão preenchidos !", "Antes de prosseguir verifique todos os campos!", 1);
        } else {
            executeQuery(1);
        }
    }

    @FXML
    public void editarFilme(ActionEvent event) {
        if (new DefaultFunctionsController().isNullOrEmpty(txtIdFilme.getText(), txtNomeFilme.getText()) || cbGeneros.getSelectionModel().getSelectedIndex() == 0) {
            new DefaultFunctionsController().mensagem("Aviso", "Verique se os campos estão preenchidos !", "Antes de prosseguir verifique todos os campos!", 1);
        } else {
            executeQuery(2);
        }
    }

    @FXML
    public void removerFilme(ActionEvent event) {
        if (new DefaultFunctionsController().isNullOrEmpty(txtIdFilme.getText(), txtNomeFilme.getText()) || cbGeneros.getSelectionModel().getSelectedIndex() == 0) {
            new DefaultFunctionsController().mensagem("Aviso", "Verique se os campos estão preenchidos !", "Antes de prosseguir verifique todos os campos!", 1);
        } else {
            executeQuery(3);
        }
    }

    @FXML
    private void pegarFilmeTabela(MouseEvent event) {
        FilmeTableController filmeList = tbFilmes.getSelectionModel().getSelectedItem();
        if (filmeList != null) {
            txtIdFilme.setText(filmeList.getId_Filme().toString());
            txtNomeFilme.setText(filmeList.getTitulo());
            cbGeneros.getSelectionModel().select(filmeList.getGenero());
        }
    }

    @FXML
    private void consultarTituloFilmeKey(KeyEvent event) {
        if (txtBuscarNome.getText().isEmpty()) {
            tbFilmes.setItems(listarFilmes(1));
        } else {
            tbFilmes.setItems(listarFilmes(2));
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inserindo generos na comboBox
        cbGeneros.getItems().removeAll(cbGeneros.getItems());
        for (Genero genero : new GeneroDAO().getAllGeneroDAO()) {
            cbGeneros.getItems().addAll(genero.getNome());
        }
        cbGeneros.getSelectionModel().select("Selecionar genero");
        //definindo a FilmeTableController class
        id_FilmeCol.setCellValueFactory(new PropertyValueFactory<>("id_Filme"));
        tituloCol.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        generoCol.setCellValueFactory(new PropertyValueFactory<>("genero"));
        //add info na tabela da interface
        tbFilmes.setItems(listarFilmes(1));
    }

    //Executar Querys
    private void executeQuery(int id) {
        Filme objFilme = getDadosFilmes();
        switch (id) {
            case 1: //Cadastrar
                new FilmeController().saveFilmeController(objFilme);
                break;
            case 2: //Editar
                new FilmeController().editFilmeController(objFilme);
                break;
            case 3: //Removar
                new FilmeController().removeFilmeController(objFilme);
                break;
        }
        new DefaultFunctionsController().mensagem("Confirmação!", "Operação realizada com sucesso!", "", 4);
        new DefaultFunctionsController().clearTextFields(txtIdFilme, txtNomeFilme);
        cbGeneros.getSelectionModel().select("Selecionar genero");
        tbFilmes.setItems(listarFilmes(1));
    }

    //Dados para tabela da interface
    private ObservableList<FilmeTableController> listarFilmes(int id) {
        ObservableList<FilmeTableController> objList = FXCollections.observableArrayList();
        FilmeController filmeController = new FilmeController();
        List<Filme> listaFilme = new ArrayList();
        switch (id) {
            case 1: //Todos os clientes
                listaFilme = filmeController.getAllFilmeController();
                break;
            case 2: //Todoso os cliente pelo nome
                listaFilme = filmeController.getAllByTitleFilmeController(txtBuscarNome.getText());
                break;
        }
        for (Filme filme : listaFilme) {
            objList.add(new FilmeTableController(filme.getId_filme(), filme.getTitulo(), filme.getGenero()));
        }
        return objList;
    }

    //Pegar dados da interface
    private Filme getDadosFilmes() {
        Filme objFilme = new Filme();
        objFilme.setId_filme((txtIdFilme.getText().isEmpty()) ? 0 : Integer.parseInt(txtIdFilme.getText()));
        objFilme.setTitulo(txtNomeFilme.getText());
        objFilme.setGenero(cbGeneros.getSelectionModel().getSelectedItem().toString());
        return objFilme;
    }
}
