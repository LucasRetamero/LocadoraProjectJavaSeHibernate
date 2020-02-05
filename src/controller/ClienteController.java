/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://www.youtube.com/watch?v=NSo0Y0VxCHI
 */
package controller;
import dao.ClienteDAO;
import java.util.List;
import tables.Cliente;
/**
 *
 * @author Su
 */
public class ClienteController {
    
    private final ClienteDAO CLIENTE_DAO = new ClienteDAO();

    public int saveClienteController(Cliente objCliente) {
        return CLIENTE_DAO.saveClienteDAO(objCliente);
    }

    public Boolean updateClienteController(Cliente objUpdate) {
        return CLIENTE_DAO.updateClienteDAO(objUpdate);
    }

    public Boolean removeClienteController(Cliente objCliente) {
        return CLIENTE_DAO.removeClienteDAO(objCliente);
    }

    public List<Cliente> getAllClienteController() {
        return CLIENTE_DAO.getAllClientesDAO();
    }

    public List<Cliente> getAllByNameClienteController(String txtPesquisa) {
        return CLIENTE_DAO.getAllByNameClienteDAO(txtPesquisa);
    }

    public List<Cliente> getAllByNameFullClienteDAO(String txtPesquisa) {
        return CLIENTE_DAO.getAllByNameFullClienteDAO(txtPesquisa);
    }
    
}
