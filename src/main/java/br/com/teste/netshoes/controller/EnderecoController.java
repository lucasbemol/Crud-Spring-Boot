package br.com.teste.netshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.netshoes.exceptions.EnderecoException;
import br.com.teste.netshoes.service.EnderecoService;
import br.com.teste.netshoes.utils.Util;
import br.com.teste.netshoes.vo.EnderecoVo;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	private EnderecoVo result;

	@RequestMapping("/buscarCep")
	public EnderecoVo index(@RequestParam(value = "cep", defaultValue = "09951380") String cep) throws EnderecoException{
		if (!Util.validar(cep)) {
			throw new EnderecoException("CEP invalido");
		}else{
			result = enderecoService.buscarCep(cep);
		}
		return result;
	}

	@RequestMapping(value = "/buscarCepJson")
	@ResponseBody
	public EnderecoVo buscarCep(@RequestBody EnderecoVo cep) throws EnderecoException {
		if (!Util.validar(cep.getCep())) {
			throw new EnderecoException("CEP invalido");
		}else{
			result = enderecoService.buscarCep(cep.getCep());
		}
		return result;
	}
}