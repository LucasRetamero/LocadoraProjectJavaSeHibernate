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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import controller.tables.ClientesTableFXMLController;
import controller.tables.FilmesTableFXMLController;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tables.Aluguel;
import tables.Cliente;
import tables.Filme;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class AluguelFXMLController implements Initializable {

    @FXML
    private TextField txtIdAluguel;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private DatePicker dtBuscarDataAluguel;
    @FXML
    private DatePicker dtBuscarDataDevolucao;
    @FXML
    private DatePicker dtAluguel;
    @FXML
    private DatePicker dtDevolucao;
    @FXML
    private TextField txtIdFilme;
    @FXML
    private ComboBox cbClientes;
    @FXML
    private ComboBox cbFilmes;
    @FXML
    private TableView<AluguelTableController> tbAluguel;
    @FXML
    private TableColumn<AluguelTableController, Integer> id_aluguelCol;
    @FXML
    private TableColumn<AluguelTableController, String> data_aluguelCol;
    @FXML
    private TableColumn<AluguelTableController, String> data_devolucaoCol;
    @FXML
    private TableColumn<AluguelTableController, Integer> clienteCol;
    @FXML
    private TableColumn<AluguelTableController, Integer> filmeCol;

    @FXML
    private void actionExeQuerys(ActionEvent event) throws ParseException {
        Button scButton = (Button) event.getSource();
        this.executeQuerys(scButton.getText());
        this.resetTxtFields(txtIdAluguel, txtIdCliente, txtIdFilme);
        this.resetDtFields(dtAluguel, dtDevolucao);
        tbAluguel.setItems(listarAlugueis(1, 0));
    }

    @FXML
    private void getCliente(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/tables/ClientesTableFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 590, 430);
            Stage stage = new Stage();
            stage.setTitle("Home - Selecionar Cliente");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
            ClientesTableFXMLController objCliente = fxmlLoader.getController();
            txtIdCliente.setText(objCliente.getIdCliente());
            stage.close();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    private void getFilme(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/tables/FilmesTableFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 585, 390);
            Stage stage = new Stage();
            stage.setTitle("Home - Selecionar Filme");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
            FilmesTableFXMLController objFilme = fxmlLoader.getController();
            txtIdFilme.setText(objFilme.getIdFilme());
            stage.close();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

    @FXML
    public void coletarDadoTabela(MouseEvent event) {
        AluguelTableController tb = tbAluguel.getSelectionModel().getSelectedItem();
        if (tb != null) {
            txtIdAluguel.setText(tb.getId_aluguel().toString());
            dtAluguel.setValue(new DefaultFunctionsController().LOCAL_DATE(tb.getData_aluguel()));
            dtDevolucao.setValue(new DefaultFunctionsController().LOCAL_DATE(tb.getData_devolucao()));
            txtIdCliente.setText(tb.getFk_idCliente().toString());
            txtIdFilme.setText(tb.getFk_idFilme().toString());
        }
    }

    @FXML
    private void cbClienteQuery(ActionEvent event) throws ParseException {
        if(cbClientes.getSelectionModel().getSelectedItem().equals("Selecionar Cliente"))
        tbAluguel.setItems(listarAlugueis(1, 0));
        else
        this.getListaAlugueisWithFkCliente();
    }
    
    @FXML
    private void cbFilmeQuery(ActionEvent event) throws ParseException {
        if(cbFilmes.getSelectionModel().getSelectedItem().equals("Selecionar Filme"))
        tbAluguel.setItems(listarAlugueis(1, 0));
        else
        this.getListaAlugueisWithFkFilme();
    }
    
    @FXML
    private void dtAluguelQuery(ActionEvent event) throws ParseException{
     if(verifyDtFields(dtBuscarDataAluguel))
      tbAluguel.setItems(listarAlugueis(1, 0));
     else
      tbAluguel.setItems(listarAlugueis(4, 0));
    }
    
    @FXML
    private void dtDevoluvaoQuery(ActionEvent event) throws ParseException{
     if(verifyDtFields(dtBuscarDataDevolucao))
      tbAluguel.setItems(listarAlugueis(1, 0));
     else
      tbAluguel.setItems(listarAlugueis(5, 0));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //definindo a FilmeTableController class
        id_aluguelCol.setCellValueFactory(new PropertyValueFactory<>("id_aluguel"));
        data_aluguelCol.setCellValueFactory(new PropertyValueFactory<>("data_aluguel"));
        data_devolucaoCol.setCellValueFactory(new PropertyValueFactory<>("data_devolucao"));
        clienteCol.setCellValueFactory(new PropertyValueFactory<>("fk_idCliente"));
        filmeCol.setCellValueFactory(new PropertyValueFactory<>("fk_idFilme"));
        try {
            //add info na tabela da interface
            tbAluguel.setItems(listarAlugueis(1, 0));
        } catch (ParseException ex) {
            Logger.getLogger(AluguelFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addClienteFilmeCB();
    }

    //Enviar dados para tabela da interface
    private ObservableList<AluguelTableController> listarAlugueis(int idParam, int fkParam) throws ParseException {
        ObservableList<AluguelTableController> objList = FXCollections.observableArrayList();
        List<Aluguel> listaAluguel = new ArrayList();
        DefaultFunctionsController defaultFunctions = new DefaultFunctionsController();
        listaAluguel = this.listQueryTbAlugueis(idParam,fkParam);
        for (Aluguel aluguel : listaAluguel) {
            objList.add(new AluguelTableController(aluguel.getId_aluguel(), defaultFunctions.formatDate(aluguel.getData_aluguel(), 1), defaultFunctions.formatDate(aluguel.getData_devolucao(), 1), aluguel.getFk_id_cliente(), aluguel.getFk_id_filme()));
        }
        return objList;
    }

    //Lista de query para pegar lista de alugueis
    private List<Aluguel> listQueryTbAlugueis(int idParam, int fkParam) {
        List<Aluguel> listaAluguel = new ArrayList();
        AluguelController aluguelController = new AluguelController();
        switch (idParam) {
            case 1: //Todos os alugueis
                listaAluguel = aluguelController.getAllAlugueisController();
                break;
            case 2: //Todoso os alugueis pelo chave estrangeira do cliente
                listaAluguel = aluguelController.getAllByFkClienteController(fkParam);
                break;
            case 3: //Todoso os alugueis pelo chave estrangeira do filme
                listaAluguel = aluguelController.getAllByFkFilmeController(fkParam);
                break;
            case 4: //Todoso os alugueis pela data do aluguel
                listaAluguel = aluguelController.getAllByDataAluguelController(localDataToSqlDate(dtBuscarDataAluguel.getValue()));
                break;
            case 5: //Todos os alugueis pela data da devolucao
                listaAluguel = aluguelController.getAllByDataDevolucaoController(localDataToSqlDate(dtBuscarDataDevolucao.getValue()));
                break;
        }
        return listaAluguel;
    }
    
    //Pegar dados da interface
    private Aluguel getDadosInterface() throws ParseException {
        Aluguel aluguel = new Aluguel();
        aluguel.setId_aluguel((txtIdAluguel.getText().isEmpty()) ? 0 : Integer.parseInt(txtIdAluguel.getText()));
        aluguel.setData_aluguel(localDataToSqlDate(dtAluguel.getValue()));
        aluguel.setData_devolucao(localDataToSqlDate(dtDevolucao.getValue()));
        aluguel.setFk_id_cliente(Integer.parseInt(txtIdCliente.getText()));
        aluguel.setFk_id_filme(Integer.parseInt(txtIdFilme.getText()));
        return aluguel;
    }

    //Converter saida do campo DataPicke para sql.date
    private java.sql.Date localDataToSqlDate(LocalDate dateParam) {
        Date out = Date.from(dateParam.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date objDate = new java.sql.Date(out.getTime());
        return objDate;
    }

    //Executar querys
    private void executeQuerys(String btnCallParam) throws ParseException {
        Aluguel aluguel = null;
        switch (btnCallParam) {
            case "Cadastrar":
                if (verifyTxtFields(txtIdCliente, txtIdFilme) && verifyDtFields(dtAluguel, dtDevolucao)) {
                    new DefaultFunctionsController().mensagem("Campos vazios!", "Verifique todos os campos antes de prosseguir !", "Tenha certeza que os campos estão todos preenchidos !", 1);
                } else {
                    aluguel = this.getDadosInterface();
                    new AluguelController().executeQueryAluguelController(aluguel, 1);
                    new DefaultFunctionsController().mensagem("Operação realizada !", "Dados cadastrados com sucesso !", "", 4);
                }
                break;
            case "Editar":
                if (verifyTxtFields(txtIdAluguel, txtIdCliente, txtIdFilme) && verifyDtFields(dtAluguel, dtDevolucao)) {
                    new DefaultFunctionsController().mensagem("Campos vazios!", "Verifique todos os campos antes de prosseguir !", "Tenha certeza que os campos estão todos preenchidos !", 1);
                } else {
                    aluguel = this.getDadosInterface();
                    new AluguelController().executeQueryAluguelController(aluguel, 2);
                    new DefaultFunctionsController().mensagem("Operação realizada !", "Dados alterado com sucesso !", "", 4);

                }
                break;
            case "Remover":
                if (verifyTxtFields(txtIdAluguel, txtIdCliente, txtIdFilme) && verifyDtFields(dtAluguel, dtDevolucao)) {
                    new DefaultFunctionsController().mensagem("Campos vazios!", "Verifique todos os campos antes de prosseguir !", "Tenha certeza que os campos estão todos preenchidos !", 1);
                } else {
                    aluguel = this.getDadosInterface();
                    new AluguelController().executeQueryAluguelController(aluguel, 3);
                    new DefaultFunctionsController().mensagem("Operação realizada !", "Dados alterado com sucesso !", "", 4);
                }
                break;
        }
    }

    //Verificar se os campos de texto estão vazios ou não
    private static Boolean verifyTxtFields(TextField... txts) {
        for (TextField txt : txts) {
            if (txt.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    //Verificar se os campos da data contem valores
    private static Boolean verifyDtFields(DatePicker... dts) {
        for (DatePicker dt : dts) {
            if (dt.getValue() == null) {
                return true;
            }
        }
        return false;
    }

    //Resetar campos de texto
    private void resetTxtFields(TextField... txts) {
        for (TextField txt : txts) {
            txt.setText("");
        }
    }

    //Resetar campos de data
    private void resetDtFields(DatePicker... dts) {
        for (DatePicker dt : dts) {
            dt.setValue(null);
        }
    }

    //Adicionar filmes e cliente nos combobox
    private void addClienteFilmeCB() {
        //ComboBox clientes
        cbClientes.getItems().removeAll(cbClientes.getItems());
        cbClientes.getItems().addAll("Selecionar Cliente");
        for (Cliente cliente : new ClienteController().getAllClienteController()) {
            cbClientes.getItems().addAll(cliente.getNome());
        }
        cbClientes.getSelectionModel().select("Selecionar Cliente");
        //ComboBox filmes-
        cbFilmes.getItems().removeAll(cbFilmes.getItems());
        cbFilmes.getItems().addAll("Selecionar Filme");
        for (Filme filme : new FilmeController().getAllFilmeController()) {
            cbFilmes.getItems().addAll(filme.getTitulo());
        }
        cbFilmes.getSelectionModel().select("Selecionar Filme");
    }

    //Pegar id do cliente usando o nome da cbCliente e gerar lista de alugueis
    private void getListaAlugueisWithFkCliente() throws ParseException {
        List<Cliente> listaCliente = new ArrayList();
        listaCliente = new ClienteController().getAllByNameFullClienteDAO(cbClientes.getSelectionModel().getSelectedItem().toString());
        for (Cliente cliente : listaCliente) {
            tbAluguel.setItems(listarAlugueis(2, cliente.getIdCliente()));
        }
    }
    
    //Pegar id do filme usando o titulo da cbFilme e gerar lista de alugueis
    private void getListaAlugueisWithFkFilme() throws ParseException {
        List<Filme> listaFilme = new ArrayList();
        listaFilme = new FilmeController().getAllByTitleFullFilmeDAO(cbFilmes.getSelectionModel().getSelectedItem().toString());
        for (Filme filme : listaFilme) {
            tbAluguel.setItems(listarAlugueis(3, filme.getId_filme()));
        }
    }
   

}
