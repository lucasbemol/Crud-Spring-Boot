package br.com.teste.netshoes.service;

import br.com.teste.netshoes.entity.Endereco;
import br.com.teste.netshoes.exceptions.CampoObrigatorioException;
import br.com.teste.netshoes.exceptions.EnderecoException;

public interface EnderecoServiceInterface {
	
	Endereco consultar(Long id) throws CampoObrigatorioException;
	void incluir(Endereco endereco) throws CampoObrigatorioException, EnderecoException;
	void atualizar(Endereco endereco) throws CampoObrigatorioException, EnderecoException;
	void deletar(Long id) throws CampoObrigatorioException;
	Endereco buscarCep(String cep) throws EnderecoException;
}
