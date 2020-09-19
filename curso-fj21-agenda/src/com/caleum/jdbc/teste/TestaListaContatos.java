package com.caleum.jdbc.teste;

import java.util.ArrayList;
import java.util.List;

import com.caelum.jdbc.dao.ContatoDao;
import com.caleum.jdbc.modelo.Contato;

public class TestaListaContatos {
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		List<Contato>contatos = new ArrayList<Contato>();
		contatos = dao.getLista();
		for(Contato contato: contatos) {
			System.out.println("Nome: "+contato.getNome());
			System.out.println("Email: "+contato.getEmail());
			System.out.println("Endereço: "+contato.getEndereco());
			System.out.println("Nome: "+contato.getDataNascimento().getTime()+"\n");
			
		}
		
		System.out.println(" Fim da busca");
	}

}
