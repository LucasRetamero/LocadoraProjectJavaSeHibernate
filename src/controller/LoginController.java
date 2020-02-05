/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDAO;
import java.util.List;
import tables.Login;
/**
 *
 * @author Su
 */
public class LoginController {
    
    private final LoginDAO  LOGIN_DAO = new LoginDAO();
    
    public List<Login> getUsuarioSenha(String usuario,String senha){
    return LOGIN_DAO.getUsuarioSenha(usuario, senha);
    }
}
