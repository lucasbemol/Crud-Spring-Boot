package br.com.teste.netshoes.utils;

import org.apache.commons.lang3.StringUtils;

import br.com.teste.netshoes.exceptions.EnderecoException;


public class Util {
	public static boolean validar(String cep) throws EnderecoException {
		if (StringUtils.isBlank(cep)) {
			throw new EnderecoException("CEP invalido");
		}

		if ("00000000".equals(cep)) {
			throw new EnderecoException("CEP invalido");
		}

		if (cep.contains("-")) {
			throw new EnderecoException("CEP invalido");
		}

		if (!cep.matches("\\d{8}")) {
			throw new EnderecoException("CEP invalido");
		}
		return true;
	}
}
