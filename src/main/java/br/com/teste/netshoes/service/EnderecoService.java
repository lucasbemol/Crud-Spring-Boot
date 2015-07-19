package br.com.teste.netshoes.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.teste.netshoes.entity.Endereco;
import br.com.teste.netshoes.exceptions.CampoObrigatorioException;
import br.com.teste.netshoes.exceptions.EnderecoException;
import br.com.teste.netshoes.repository.EnderecoRepository;

@Service
public class EnderecoService implements EnderecoServiceInterface{
	
	private final Logger logger = Logger.getLogger(EnderecoService.class);
	@Autowired
	EnderecoRepository repository;
	
	public Endereco buscarCep(String cep) throws EnderecoException{
		Endereco result = new Endereco();
		int count = cep.length();
		StringBuilder cepBuilder = new StringBuilder(cep);
		String uri = "http://api.postmon.com.br/v1/cep/{cep}";
		RestTemplate restTemplate = new RestTemplate();
		
		while (result.getCep() == null) {
			if(count == 0){
				throw new EnderecoException("CEP nao encontrado!");
			}
			logger.info("Buscando Cep: " + cepBuilder.toString());
			Map<String, String> params = new HashMap<String, String>();
		    params.put("cep", cepBuilder.toString());
		    try{
		    	result = restTemplate.getForObject(uri, Endereco.class, params);
		    }catch (HttpClientErrorException error){
		    	if(error.getStatusCode().equals(HttpStatus.NOT_FOUND)){
		    		logger.error("Cep não encontrado!");
		    		cepBuilder.setCharAt(--count, '0');
		    	}
		    }
		}
	    
	    return result;
	}
	
	@Override
	public Endereco consultar(Long id) throws CampoObrigatorioException {
		logger.info("Consultando endereco...");
		Endereco result = repository.findById(id);
		if(result == null){
			logger.error("Erro ao consultar Endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado!");
		}
		return repository.findById(id);
	}
	@Override
	public void incluir(Endereco endereco) throws EnderecoException {
		logger.info("Incluindo endereco...");
		/* Pega o CEP elaborado na função buscaCep,
		 * caso o CEP não seja encontrado de primeira
		 * ira atribuir o primeiro CEP encontrado no algorítimo.
		 */
		Endereco buscaCep = buscarCep(endereco.getCep());
		endereco.setCep(buscaCep.getCep());
		repository.save(endereco);
	}
	@Override
	public void atualizar(Endereco endereco) throws CampoObrigatorioException, EnderecoException {
		logger.info("Atualizando endereco...");
		/* Pega o CEP elaborado na função buscaCep,
		 * caso o CEP não seja encontrado de primeira
		 * ira atribuir o primeiro CEP encontrado no algorítimo.
		 */
		Endereco buscaCep = buscarCep(endereco.getCep());
		endereco.setCep(buscaCep.getCep());
		Endereco result = repository.findOne(endereco.getId());
		if(result == null){
			logger.error("Erro ao atualizar endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado para ser atualizado!");
		}
		repository.save(result);
	}
	@Override
	public void deletar(Long id) throws CampoObrigatorioException {
		logger.info("Deletando endereco...");
		Endereco result = repository.findOne(id);
		if(result == null){
			logger.error("Erro ao deletar Endereco!");
			throw new CampoObrigatorioException("Endereco Nao encontrado para ser excluido!");
		}
		repository.delete(id);
	}
}
