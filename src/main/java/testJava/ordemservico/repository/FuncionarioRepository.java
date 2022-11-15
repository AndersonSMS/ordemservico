package testJava.ordemservico.repository;

import org.springframework.data.repository.CrudRepository;

import testJava.ordemservico.models.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {
    
}