package testJava.ordemservico.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class alteracaoOS implements Serializable  {
    
    private static final long serialVersionUID = 1L;

    @Id  
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private int num_alteracao;
    private String descricao;
    private String funcionario;
    private Date data_alt;
    public Date getData_alt() {
        return data_alt;
    }

    public void setData_alt(Date data_alt) {
        this.data_alt = data_alt;
    }

    private String status_os;

    public alteracaoOS(){}

    public alteracaoOS(int codigo, int num_alteração,  String descricao, String funcionario,
        Date data, String status_os){

        this.codigo = codigo;
        this.num_alteracao = num_alteração;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.data_alt = data;
        this.status_os = status_os;
    }
    
   

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    

    /**
     * @return int return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    
    /**
     * @return String return the status_os
     */
    public String getStatus_os() {
        return status_os;
    }

    /**
     * @param status_os the status_os to set
     */
    public void setStatus_os(String status_os) {
        this.status_os = status_os;
    }


    /**
     * @return int return the num_alteração
     */
    public int getNum_alteracao() {
        return num_alteracao;
    }

    /**
     * @param num_alteração the num_alteração to set
     */
    public void setNum_alteracao(int num_alteração) {
        this.num_alteracao = num_alteração;
    }

}