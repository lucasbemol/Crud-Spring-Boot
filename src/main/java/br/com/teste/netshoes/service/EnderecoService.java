package br.com.teste.netshoes.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.teste.netshoes.vo.EnderecoVo;

@Service
public class EnderecoService {
	
	private final Logger logger = Logger.getLogger(EnderecoService.class);
	
	public EnderecoVo buscarCep(String cep){
		EnderecoVo result = new EnderecoVo();
		int count = cep.length();
		StringBuilder cepBuilder = new StringBuilder(cep);
		String uri = "http://api.postmon.com.br/v1/cep/{cep}";
		RestTemplate restTemplate = new RestTemplate();
		
		while (result.getCep() == null) {
			if(count == 0){
				break;
			}
			logger.info("Buscando Cep: " + cepBuilder.toString());
			Map<String, String> params = new HashMap<String, String>();
		    params.put("cep", cepBuilder.toString());
		    try{
		    	result = restTemplate.getForObject(uri, EnderecoVo.class, params);
		    }catch (HttpClientErrorException error){
		    	if(error.getStatusCode().equals(HttpStatus.NOT_FOUND)){
		    		logger.error("Cep não encontrado!");
		    		cepBuilder.setCharAt(--count, '0');
		    	}
		    }
		}
	    
	    return result;
	}
}
