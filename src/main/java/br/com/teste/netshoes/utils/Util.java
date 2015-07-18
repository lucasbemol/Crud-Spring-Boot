package br.com.teste.netshoes.utils;

import org.apache.commons.lang3.StringUtils;


public class Util {
	public static boolean validar(String cep) {
		boolean valid = true;
		
		if (StringUtils.isBlank(cep)) {
			valid = false;
		}

		if ("00000000".equals(cep)) {
			valid = false;
		}

		if (cep.contains("-")) {
			valid = false;
		}

		if (!cep.matches("\\d{8}")) {
			valid = false;
		}
		return valid;
	}
}
