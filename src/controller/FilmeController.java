/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FilmeDAO;
import java.util.List;
import tables.Filme;

/**
 *
 * @author Su
 */
public class FilmeController {

    private FilmeDAO FILME_DAO = new FilmeDAO();

    //Salvar filme
    public int saveFilmeController(Filme objFilme) {
        return FILME_DAO.saveFilmeDAO(objFilme);
    }

    //Editar Filme
    public Boolean editFilmeController(Filme objFilme) {
        return FILME_DAO.editFilmeDAO(objFilme);
    }

    //Removar Filme
    public Boolean removeFilmeController(Filme objFilme) {
        return FILME_DAO.removeFilmeDAO(objFilme);
    }

    //Lista de filmes
    public List<Filme> getAllFilmeController() {
        return FILME_DAO.getAllFilmeDAO();
    }

    //Lista de filmes pelo nome
    public List<Filme> getAllByTitleFilmeController(String txtPesquisa) {
        return FILME_DAO.getAllByTitleFilmeDAO(txtPesquisa);
    }
    
    //Pegar info do filme pelo titulo completo
    public List<Filme> getAllByTitleFullFilmeDAO(String txtPesquisaParam) {
        return FILME_DAO.getAllByTitleFullFilmeDAO(txtPesquisaParam);
    }
}
