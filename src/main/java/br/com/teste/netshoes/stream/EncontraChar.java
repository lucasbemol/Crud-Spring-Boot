package br.com.teste.netshoes.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EncontraChar {
	public static char firstChar(Stream stream) {
		List<Character> listaAux = new ArrayList<Character>();
		Set<Character> set = new HashSet<Character>();
		
		while (stream.hasNext()) {
			Character current = stream.getNext();
			if (!set.add(current)) {
				listaAux.remove(current);
			} else {
				listaAux.add(current);
			}
		}
		return listaAux.isEmpty() ? ' ' : listaAux.get(0);
	}
}
