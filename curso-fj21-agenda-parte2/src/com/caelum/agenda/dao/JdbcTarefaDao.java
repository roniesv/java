package com.caelum.agenda.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.caelum.agenda.jdbc.ConnectionFactory;
import com.caelum.agenda.modelo.Tarefa;

public class JdbcTarefaDao {
	private Connection con;

	public JdbcTarefaDao() throws ClassNotFoundException {
		this.con = new ConnectionFactory().getConnection();
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

//	public List<Tarefa> getLista() {
//
//		try {
//
//			List<Tarefa> tarefas = new ArrayList<Tarefa>();
//			String sql = "select * from tarefa";
//			PreparedStatement pstm = con.prepareStatement(sql);
//
//			ResultSet rs = pstm.executeQuery();
//
//			while (rs.next()) {
//
//				Tarefa tarefa = new Tarefa();
//				tarefa.setId(rs.getLong("id"));
//				//tarefa.setDataFinalizacao(rs.getDate("dataFinalizacao"));
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("datanascimento"));
//				//contato.setDataNascimento(data);
//
//				//contatos.add(contato);
//			}
//			rs.close();
//			pstm.close();
//			//return contatos;
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//
//	}

//	public List<Contato> getListaPorLetra(String letra) {
//		try {
//			List<Contato> contatos = new ArrayList<Contato>();
//			PreparedStatement stmt = this.con.prepareStatement("Select * from contatos where nome like ?");
//			stmt.setString(1, letra + '%');
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Contato contato = new Contato();
//				contato.setId(rs.getLong("id"));
//				contato.setNome(rs.getString("nome"));
//				contato.setEmail(rs.getString("email"));
//				contato.setEndereco(rs.getString("endereco"));
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//
//				contatos.add(contato);
//
//			}
//			rs.close();
//			stmt.close();
//
//			return contatos;
//
//		} catch (SQLException e) {
//			throw new DaoException("Não foi possível realizar a busca em contatos " + e);
//		}
//	}
//
//	public Contato localizaIntId(long id) {
//		try {
//			PreparedStatement stmt = this.con.prepareStatement("Select * from contatos where id=" + id);
//			ResultSet rs = stmt.executeQuery();
//			Contato contato = new Contato();
//			while (rs.next()) {
//
//				contato.setId(rs.getLong("id"));
//				contato.setNome(rs.getString("nome"));
//				contato.setEmail(rs.getString("email"));
//				contato.setEndereco(rs.getString("endereco"));
//
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				contato.setDataNascimento(data);
//
//			}
//			stmt.close();
//			rs.close();
//			return contato;
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//
//	}
//	public void altera(Contato contato) {
//		String sql = "update contatos set nome=?, email=?, endereco=?, "
//				+ "dataNascimento=? where id=?";
//		try {
//			PreparedStatement pstmt = this.con.prepareStatement(sql);
//			pstmt.setString(1, contato.getNome());
//			pstmt.setString(2, contato.getEmail());
//			pstmt.setString(3,contato.getEndereco());
//			pstmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
//			pstmt.setLong(5,contato.getId());
//
//			//esse volta um long, que pode ser usada em um sql.date
//			//pstmt.setDate(4, (Date) contato.getDataNascimento().getTime()); esse volta uma util.data erro
//
//			//pstm.setLong(5, contato.getId();
//			pstmt.execute();
//			pstmt.close();
//			
//		} catch (SQLException e) {
//			throw new DaoException("Falha na alteração do contato",e);
//		}
//		
//		
//	}
//	public void remove(Contato contato) {
//		try {
//			PreparedStatement pstmt = this.con.prepareStatement("delete from contatos where id=?");
//			pstmt.setLong(1, contato.getId());
//			pstmt.execute();
//			pstmt.close();
//		} catch (SQLException e) {
//			throw new DaoException("Erro na remo��o ",e);
//		}
		
//	}
	

}

