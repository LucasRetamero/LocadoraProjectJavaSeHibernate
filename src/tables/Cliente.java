package tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity(name = "Cliente")
@Table(name = "tbl_cliente")
public class Cliente {
    
    @Id
    @GeneratedValue
    @Column(name = "id_cliente")
    private  int idCliente;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "nome")
    private String nome;
    
    public Cliente(){
    
    }
    
    public Cliente(String endereco,String nome){
    this.endereco = endereco;
    this.nome = nome;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
       
}
