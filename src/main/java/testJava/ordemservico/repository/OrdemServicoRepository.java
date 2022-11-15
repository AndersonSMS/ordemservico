package testJava.ordemservico.repository;

import org.springframework.data.repository.CrudRepository;

import testJava.ordemservico.models.Funcionario;
import testJava.ordemservico.models.OrdemServico;

public interface OrdemServicoRepository extends CrudRepository<OrdemServico, String> {

    OrdemServico findByCodigo(Integer codigo);    
}