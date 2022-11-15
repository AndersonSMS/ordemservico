package testJava.ordemservico.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    private String cpf_funcionario;

    private String nome;
    private String cargo;
    private String endereco;
    private String telefone;
    private String email;

    public Funcionario(){}

    public Funcionario(String cpf_funcionario, String nome, String cargo, String endereco, String telefone, String email){
        this.cpf_funcionario = cpf_funcionario;
        this.nome = nome;
        this.cargo = cargo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    
    /**
     * @return String return the nome
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


    /**
     * @return int return the cpf_funcionario
     */
    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    /**
     * @param cpf_funcionario the cpf_funcionario to set
     */
    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    /**
     * @return String return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return String return the endereco
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
     * @return String return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}