package com.caleum.jdbc.teste;

import java.util.Calendar;

import com.caelum.jdbc.dao.ContatoDao;
import com.caleum.jdbc.modelo.Contato;

public class testaInseriContato {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setNome("Jack Hannaford");
		contato.setEmail("jhf@gmail.com");
		contato.setEndereco("West of England");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.inserir(contato);
	 
		
		System.out.println("Contato inserido com sucesso");
		
		
		
	}

}
