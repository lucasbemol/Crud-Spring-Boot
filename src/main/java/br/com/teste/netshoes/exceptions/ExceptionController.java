package br.com.teste.netshoes.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(EnderecoException.class)
	public String handleCustomException(EnderecoException ex) {
 
		return "Cep Invalido!";
 
	}
}
