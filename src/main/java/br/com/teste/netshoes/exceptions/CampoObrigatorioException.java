package br.com.teste.netshoes.exceptions;

import org.springframework.validation.BindingResult;

public class CampoObrigatorioException extends Exception {
	private static final long serialVersionUID = 1L;
	private static BindingResult bindingResult; 
	
	public CampoObrigatorioException() {
		super();
	}

	public CampoObrigatorioException(String pMensagem) {
		super(pMensagem);
	}
	
	public CampoObrigatorioException(BindingResult binding) {
		super("Campos Obrigatorios");		
		this.bindingResult = binding;
	}

	public CampoObrigatorioException(Throwable pException) {
		super(pException);
	}

	public CampoObrigatorioException(String pMensagem, Throwable pException) {
		super(pMensagem, pException);
	}
	
	public BindingResult getBindingResult() {
        return bindingResult;
    }
}
