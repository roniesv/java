package com.caleum.jdbc.teste;

import com.caelum.jdbc.dao.ContatoDao;

public class TestaListaContatos {
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		dao.PesquisarContatos();
		System.out.println("Pesquisa finalizada");
	}

}
