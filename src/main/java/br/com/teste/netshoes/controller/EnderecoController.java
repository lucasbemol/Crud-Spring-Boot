package br.com.teste.netshoes.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.netshoes.vo.EnderecoVo;

@RestController
public class EnderecoController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/teste")
	public EnderecoVo index(
			@RequestParam(value = "cep", defaultValue = "09951-380") String cep) {
		EnderecoVo endereco = new EnderecoVo();
		endereco.setCep(cep);
		return endereco;
	}
	
	@RequestMapping(value = "/buscarCep", method = RequestMethod.GET)
	@ResponseBody
	public String buscarCep(@RequestBody EnderecoVo cep){
		String result = "bla";
		return result;
	}
}