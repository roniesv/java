package com.caleum.jdbc.teste;

import com.caelum.jdbc.dao.ContatoDao;
import com.caleum.jdbc.modelo.Contato;

public class TestaRemoveContato {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		contato.setId((long) 27);
		
		dao.remove(contato);
		
		System.out.println("Sucesso, na remoção");
	}

}
