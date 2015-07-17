package br.com.teste.netshoes.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.teste.netshoes.vo.EnderecoVo;

@RestController
public class EnderecoController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/teste")
	public EnderecoVo index(
			@RequestParam(value = "cep", defaultValue = "09951380") String cep) {
		EnderecoVo endereco = new EnderecoVo();
		endereco.setCep(cep);
		
		String uri = "http://api.postmon.com.br/v1/cep/{cep}";
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("cep", cep);
	    EnderecoVo result = restTemplate.getForObject(uri, EnderecoVo.class, params);
		return result;
	}
	
	@RequestMapping(value = "/buscarCep", method = RequestMethod.GET)
	@ResponseBody
	public String buscarCep(@RequestBody EnderecoVo cep){
		String result = "bla";
		return result;
	}
}