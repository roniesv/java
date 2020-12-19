package com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.caelum.agenda.exception.DaoException;
import com.caelum.agenda.jdbc.ConnectionFactory;
import com.caelum.agenda.modelo.Usuario;

public class JdbcUsuarioDao {
	
	private Connection con;

	public JdbcUsuarioDao() throws ClassNotFoundException{
		this.con = new ConnectionFactory().getConnection();
	}

	public void inserir(Usuario Usuario) {
		String sql = "insert into Usuarios (login, senha)" + "values (?, ?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, Usuario.getLogin());
			pstm.setString(2, Usuario.getSenha());
			
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			new RuntimeException(e);
		}

	}
	public boolean existeUsuario(Usuario usuario) {
		if(buscarPorId(usuario)!=null){
			return true;
		}
		return false;
	}
	
	

      public void remove(Usuario Usuario) {
	try {
     	PreparedStatement pstmt = this.con.prepareStatement("delete from Usuarios where login=?");
	 	pstmt.setString(1, Usuario.getLogin());
	 	pstmt.execute();
	 	pstmt.close();
	 } catch (SQLException e) {
	 	throw new DaoException("Erro na remo��o ",e);
	 }
   }
   
      
   public Usuario buscarPorId(Usuario usuario) {
    try {
 	PreparedStatement stmt = this.con.prepareStatement("select * from usuarios where login=?" );
 	stmt.setString(1, usuario.getLogin());
    
 	ResultSet rs = stmt.executeQuery();
 	Usuario Usuario = null; 
 	while (rs.next()) {
 		 Usuario = new Usuario();
 		
 		Usuario.setLogin(rs.getString("login"));
 		Usuario.setSenha(rs.getString("senha"));
 		
 		 	
 	}
 	System.out.println(Usuario);
 	stmt.close();
 	rs.close();
 	return Usuario;
 
 } catch (SQLException e) {
 	throw new RuntimeException(e);
 }}
    public void altera(Usuario Usuario) {
    	String sql = "update Usuarios set senha=?"
    			+ " where login=?";
    	try {
    		PreparedStatement pstmt = this.con.prepareStatement(sql);
    		pstmt.setString(1, Usuario.getLogin());
    		
    		pstmt.execute();
    		pstmt.close();
	
           } catch (SQLException e) {
    		throw new DaoException("Falha na altera��o do contato",e);
    	}


	

} 






}
