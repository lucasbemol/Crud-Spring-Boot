package br.com.teste.netshoes.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.netshoes.entity.Endereco;
import br.com.teste.netshoes.exceptions.CampoObrigatorioException;
import br.com.teste.netshoes.exceptions.EnderecoException;
import br.com.teste.netshoes.service.EnderecoService;
import br.com.teste.netshoes.utils.Util;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	private Endereco result;
	private final Logger logger = Logger.getLogger(EnderecoService.class);

	@RequestMapping("/buscarCep")
	public ResponseEntity<Endereco> index(@RequestParam(value = "cep", defaultValue = "09951380") String cep) throws EnderecoException{
		logger.info("Rest buscarCep por String");
		Util.validar(cep);
		result = enderecoService.buscarCep(cep);
		return new ResponseEntity<Endereco>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/buscarCepJson")
	@ResponseBody
	public ResponseEntity<Endereco> buscarCep(@RequestBody Endereco cep) throws EnderecoException {
		logger.info("Rest buscarCep por JSON");
		Util.validar(cep.getCep());
		result = enderecoService.buscarCep(cep.getCep());
		return new ResponseEntity<Endereco>(result, HttpStatus.OK);
	}
	
	@RequestMapping("/consultar")
	@ResponseBody
	public ResponseEntity<Endereco> consultar(@RequestBody Endereco endereco) throws EnderecoException, CampoObrigatorioException{
		logger.info("Rest consultar endereco");
		if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para consulta!");
		}
			Endereco resultX = enderecoService.consultar(endereco.getId());
		return new ResponseEntity<Endereco>(resultX, HttpStatus.OK);
	}
	
	@RequestMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Endereco> atualizar(@RequestBody @Valid Endereco endereco, BindingResult bindingResult) throws EnderecoException, CampoObrigatorioException{
		logger.info("Rest atualizar endereco");
		if(bindingResult.hasErrors()){
			throw new CampoObrigatorioException(bindingResult);
		}else if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para atualizar!");
		}
		Util.validar(endereco.getCep());
		enderecoService.atualizar(endereco);
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
	
	@RequestMapping("/deletar")
	@ResponseBody
	public ResponseEntity<Endereco> deletar(@RequestBody Endereco endereco) throws EnderecoException, CampoObrigatorioException{
		logger.info("Rest deletar endereco");
		if(endereco.getId() == null){
			throw new CampoObrigatorioException("Campo ID e obrigatorio para exclusao!");
		}
		enderecoService.deletar(endereco.getId());
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
	
	@RequestMapping("/incluir")
	@ResponseBody
	public ResponseEntity<Endereco> incluir(@RequestBody @Valid Endereco endereco, BindingResult bindingResult) throws EnderecoException, CampoObrigatorioException{
		logger.info("Rest incluir endereco");
		if(bindingResult.hasErrors()){
			throw new CampoObrigatorioException(bindingResult);
		}
		Util.validar(endereco.getCep());
		enderecoService.incluir(endereco);
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
}