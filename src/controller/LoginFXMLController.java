/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import tables.Login;
import controller.DefaultFunctionsController;

/**
 * FXML Controller class
 *
 * @author Su
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private void callHomeFXML(ActionEvent event){
     switch(verificaLogin()){
      case 1: //Login não existe ou campo vazio
      new DefaultFunctionsController().mensagem("Falha ao acessar o sistema", "Usuario e senha invalido ou não cadastrado !", "Antes de prosseguir verifique se os campos estão preenchidos corretamente!", 1);
      break;
      default: //login existente chama janela principal
      new DefaultFunctionsController().mensagem("Operação realizada com sucesso !", "Login realizado com sucesso !", "", 4);
      new DefaultFunctionsController().callWindow("/view/HomeFXML.fxml", "Home", 535,510,event);
      break;
      }
    }
    
    @FXML
    private void closeApp(ActionEvent event){
    Platform.exit();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Verificar caso possua login
    private int verificaLogin(){
    Login objLogin = getDados();
    LoginController objLoginController = new LoginController();
    List<Login> objListaLogin = objLoginController.getUsuarioSenha(objLogin.getLogin(), objLogin.getSenha());
    if(objListaLogin.isEmpty() || new DefaultFunctionsController().isNullOrEmpty(txtLogin.getText(),txtSenha.getText())) 
    return 1;
    else
    return 0;
    }
   
    //Pegar dados da interface
    private Login getDados(){
    Login objLogin = new Login();
    objLogin.setLogin(txtLogin.getText());
    objLogin.setSenha(txtSenha.getText());
    return objLogin;
    }
}
