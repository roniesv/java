package com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.caleum.jdbc.ConnectionFactory;
import com.caleum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection con;
	
	public ContatoDao(){
		this.con=new ConnectionFactory().getConnection();
	}
	
	public void inserir(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco,datanascimento)"+
	                  "values (?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getEndereco());
			pstm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			pstm.execute();
			pstm.close();
			con.close();
			
		} catch (SQLException e) {
			new RuntimeException(e);
		}
		
		
		
	}
	public void PesquisarContatos() {
		String sql = "select * from contatos";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nome")+"__"+rs.getString("email"));
				
				
			}
		    rs.close();
		    pstm.close();
		    con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
