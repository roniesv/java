package com.caelum.agenda.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caelum.agenda.exception.DaoException;
import com.caelum.agenda.jdbc.ConnectionFactory;
import com.caelum.agenda.modelo.Tarefa;
@Repository
public class JdbcTarefaDao {
	private Connection con;
    @Autowired
	public JdbcTarefaDao(DataSource dataSource) throws ClassNotFoundException{
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void inserir(Tarefa tarefa) {
		String sql = "insert into tarefas (descricao)" + "values (?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, tarefa.getDescricao());
			
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			new RuntimeException(e);
		}

	}

   public List<Tarefa> getLista() {

	try {
				List<Tarefa> tarefas = new ArrayList<Tarefa>();
				String sql = "select * from tarefas";
				PreparedStatement pstm = con.prepareStatement(sql);
	
				ResultSet rs = pstm.executeQuery();
	
				while (rs.next()) {
	
					Tarefa tarefa = new Tarefa();
					tarefa.setId(rs.getLong("id"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setFinalizado(rs.getBoolean("finalizado"));
								
					Calendar data = Calendar.getInstance(); 
					
					if(rs.getDate("dataFinalizacao")==null) {
						data.getTimeInMillis();
					}else {
						data.setTime(rs.getDate("dataFinalizacao"));	
					}
					tarefa.setDataFinalizacao(data);
					
					tarefas.add(tarefa);
			}
				rs.close();
				pstm.close();
				return tarefas;
	
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

	}
   public void remove(Tarefa tarefa) {
	try {
     	PreparedStatement pstmt = this.con.prepareStatement("delete from tarefas where id=?");
	 	pstmt.setLong(1, tarefa.getId());
	 	pstmt.execute();
	 	pstmt.close();
	 } catch (SQLException e) {
	 	throw new DaoException("Erro na remo��o ",e);
	 }
   }
   
   public void remove1(Long id) {
		try {
	     	PreparedStatement pstmt = this.con.prepareStatement("delete from tarefas where id=?");
		 	pstmt.setLong(1, id);
		 	pstmt.execute();
		 	pstmt.close();
		 } catch (SQLException e) {
		 	throw new DaoException("Erro na remo��o ",e);
		 }
	   }
   
   
   public Tarefa buscarPorId(long id) {
    try {
 	PreparedStatement stmt = this.con.prepareStatement("Select * from tarefas where id=" + id);
 	ResultSet rs = stmt.executeQuery();
 	Tarefa tarefa = new Tarefa();
 	while (rs.next()) {
 
 		tarefa.setId(rs.getLong("id"));
 		tarefa.setDescricao(rs.getString("descricao"));
 		tarefa.setFinalizado(rs.getBoolean("finalizado"));
 		
 		Calendar data = Calendar.getInstance(); 
		
		if(rs.getDate("dataFinalizacao")==null) {
			data.getTimeInMillis();
		}else {
			data.setTime(rs.getDate("dataFinalizacao"));	
		}
 		tarefa.setDataFinalizacao(data);
 
 	
 	}
 	stmt.close();
 	rs.close();
 	return tarefa;
 
 } catch (SQLException e) {
 	throw new RuntimeException(e);
 }}
    public void altera(Tarefa tarefa) {
    	String sql = "update tarefas set descricao=?, finalizado=?, datafinalizacao=? "
    			+ " where id=?";
    	try {
    		PreparedStatement pstmt = this.con.prepareStatement(sql);
    		pstmt.setString(1, tarefa.getDescricao());
    		pstmt.setBoolean(2, tarefa.isFinalizado());
    		pstmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
    		pstmt.setLong(4, tarefa.getId());
    	
    		pstmt.execute();
    		pstmt.close();
	
           } catch (SQLException e) {
    		throw new DaoException("Falha na altera��o do contato",e);
    	}


	

} 

	public void finaliza(Long id) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setFinalizado(true);
		Calendar date = Calendar.getInstance();  
		
		tarefa.setDataFinalizacao(date);
		String sql = "update tarefas set finalizado=?, datafinalizacao=? "+ " where id=?";
		try {
			PreparedStatement pstmt = this.con.prepareStatement(sql);
			pstmt.setBoolean(1, tarefa.isFinalizado());
    		pstmt.setDate(2, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
    		pstmt.setLong(3, id);
    		pstmt.execute();
    		pstmt.close();
		}catch(SQLException e){
    		throw new DaoException("Falha na altera��o da tarefa",e);
    	}
		
		
	}}


