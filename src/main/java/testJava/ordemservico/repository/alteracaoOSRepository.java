package testJava.ordemservico.repository;

import org.springframework.data.repository.CrudRepository;

import testJava.ordemservico.models.alteracaoOS;

public interface alteracaoOSRepository extends CrudRepository<alteracaoOS, String> {
    alteracaoOS findByCodigo(Integer codigo);

    Iterable<alteracaoOS> findAllByCodigo(Integer codigo);  
}