package com.caleum.jdbc.teste;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.caelum.jdbc.dao.ContatoDao;
import com.caleum.jdbc.modelo.Contato;

public class TestaListaRefinada {
	public static void main(String[] args) {
		
		String letrasIniciaisNomes = "G";
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = new ArrayList();
		
		contatos = dao.getListaPorLetra(letrasIniciaisNomes);
		
		for (Contato contato : contatos) {
			System.out.println("Id:"+contato.getId());
			System.out.println("Nome: "+contato.getNome());
			System.out.println("Email: "+contato.getNome());
			System.out.println("Endereço: "+ contato.getEndereco());
			//System.out.println("Data de Nascimento: "+ contato.getDataNascimento().getTime());
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			String  dataFormatada = df.format(contato.getDataNascimento().getTime());
		    System.out.println(dataFormatada);
			
			
		}
		
		
//		
		
	}

}
