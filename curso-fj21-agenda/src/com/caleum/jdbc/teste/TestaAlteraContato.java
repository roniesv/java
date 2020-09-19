package com.caleum.jdbc.teste;

import java.util.Calendar;

import com.caelum.jdbc.dao.ContatoDao;
import com.caleum.jdbc.modelo.Contato;

public class TestaAlteraContato {

	public static void main(String[] args) {
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		contato.setId((long)3);
		contato.setNome("Peter Aqui");
		contato.setEmail("perterjordan@gmail.com");
		contato.setEndereco("av. paulista");
		contato.setDataNascimento(Calendar.getInstance());
		dao.altera(contato);
		System.out.println("Alteração realizada com sucesso");
		
	}
	

}
