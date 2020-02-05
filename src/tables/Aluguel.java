package tables;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity( name="Aluguel")
@Table( name="tbl_aluguel")
public class Aluguel {
 
    @Id
    @GeneratedValue
    @Column(name = "id_aluguel")
    private int id_aluguel;
    
    @JoinColumn(name="tbl_cliente", referencedColumnName="id_cliente",foreignKey = @ForeignKey(name = "fk_id_cliente"))
    private int fk_id_cliente;
  
    @JoinColumn(name="tbl_filme", referencedColumnName="id_filme", foreignKey = @ForeignKey(name = "fk_id_filme"))
    private int fk_id_filme;
    
    @Column(name = "data_aluguel")
    private Date data_aluguel;
    
    @Column(name = "data_devolucao")
    private Date data_devolucao;
    
    public Aluguel(){
    }
    
    public Aluguel(Date data_aluguel, Date data_devolucao, int fk_id_cliente, int fk_id_filme){
    this.data_aluguel = data_aluguel;
    this.data_devolucao = data_devolucao;
    this.fk_id_cliente = fk_id_cliente;
    this.fk_id_filme = fk_id_filme;
    }

    /**
     * @return the id_aluguel
     */
    public int getId_aluguel() {
        return id_aluguel;
    }

    /**
     * @param id_aluguel the id_aluguel to set
     */
    public void setId_aluguel(int id_aluguel) {
        this.id_aluguel = id_aluguel;
    }

    /**
     * @return the fk_id_cliente
     */
    public int getFk_id_cliente() {
        return fk_id_cliente;
    }

    /**
     * @param fk_id_cliente the fk_id_cliente to set
     */
    public void setFk_id_cliente(int fk_id_cliente) {
        this.fk_id_cliente = fk_id_cliente;
    }

    /**
     * @return the fk_id_filme
     */
    public int getFk_id_filme() {
        return fk_id_filme;
    }

    /**
     * @param fk_id_filme the fk_id_filme to set
     */
    public void setFk_id_filme(int fk_id_filme) {
        this.fk_id_filme = fk_id_filme;
    }

    /**
     * @return the data_aluguel
     */
    public Date getData_aluguel() {
        return data_aluguel;
    }

    /**
     * @param data_aluguel the data_aluguel to set
     */
    public void setData_aluguel(Date data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    /**
     * @return the data_devolucao
     */
    public Date getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }


}
