package testJava.ordemservico.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdemServico implements Serializable  {
    
    private static final long serialVersionUID = 1L;

    @Id  
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String equipamento;
    private String descricao;
    private String funcionario;
    private Date data_inicio;
    private Date data_fim;
    private String status_os;

    public OrdemServico(){}

    public OrdemServico(String cpf, String nome, String endereco, String telefone, 
        String email, String equipamento, String descricao, String funcionario,
        Date data_inicio, Date data_fim, String status_os){

        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.equipamento = equipamento;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status_os = status_os;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
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
     * @return Date return the data_inicio
     */
    public Date getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return Date return the data_fim
     */
    public Date getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
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

}