package br.com.teste.netshoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.netshoes.entity.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{
	public Endereco findById(Long id);
}
