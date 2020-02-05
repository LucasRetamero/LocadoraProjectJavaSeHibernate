/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import tables.Aluguel;
import dao.AluguelDAO;
import javafx.collections.ObservableList;
/**
 *
 * @author Su
 */
public class AluguelController {
    
    private final AluguelDAO ALUGUEL_DAO = new AluguelDAO();

    //Executar querys 
    public Boolean executeQueryAluguelController(Aluguel aluguelParam, int typeParam) {
        return ALUGUEL_DAO.executeQueryAluguelDAO(aluguelParam, typeParam);
    }

    //Pegar lista da entidade tbl_aluguel
    public List<Aluguel> getAllAlugueisController() {
        return ALUGUEL_DAO.getAllAlugueisDAO();
    }

    //Pegar alugueis pela chave estrangeira cliente
    public List<Aluguel> getAllByFkClienteController(int fkClienteParam) {
        return ALUGUEL_DAO.getAllByFkClienteDAO(fkClienteParam);
    }
    
    //Pegar aluguel pela chave estrangeira filme
    public List<Aluguel> getAllByFkFilmeController(int fkFilmeParam) {
        return ALUGUEL_DAO.getAllByFkFilmeDAO(fkFilmeParam);
    }
    
    //Pegar aluguel pela data do aluguel
    public List<Aluguel> getAllByDataAluguelController(java.sql.Date dtParam) {
        return ALUGUEL_DAO.getAllByDataAluguelDAO(dtParam);
    }
    
    //Pegar aluguel pela data da devolução
    public List<Aluguel> getAllByDataDevolucaoController(java.sql.Date dtParam) {
        return ALUGUEL_DAO.getAllByDataDevolucaoDAO(dtParam);
    }
    
    
}
