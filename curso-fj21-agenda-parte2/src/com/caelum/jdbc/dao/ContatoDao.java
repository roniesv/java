package com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.caelum.jdbc.exception.DaoException;
import com.caleum.jdbc.ConnectionFactory;
import com.caleum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection con;

	public ContatoDao() throws ClassNotFoundException {
		this.con = new ConnectionFactory().getConnection();
	}

	public void inserir(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco,datanascimento)" + "values (?,?,?,?)";
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

	public List<Contato> getLista() {

		try {

			List<Contato> contatos = new ArrayList<Contato>();
			String sql = "select * from contatos";
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			pstm.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Contato> getListaPorLetra(String letra) {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.con.prepareStatement("Select * from contatos where nome like ?");
			stmt.setString(1, letra + '%');
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);

			}
			rs.close();
			stmt.close();

			return contatos;

		} catch (SQLException e) {
			throw new DaoException("Não foi possível realizar a busca em contatos " + e);
		}
	}

	public Contato localizaIntId(long id) {
		try {
			PreparedStatement stmt = this.con.prepareStatement("Select * from contatos where id" + id);
			ResultSet rs = stmt.executeQuery();
			Contato contato = new Contato();
			while (rs.next()) {

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

			}
			stmt.close();
			rs.close();
			con.close();
			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, "
				+ "dataNascimento=? where id=?";
		try {
			PreparedStatement pstmt = this.con.prepareStatement(sql);
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getEmail());
			pstmt.setString(3,contato.getEndereco());
			pstmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			pstmt.setLong(5,contato.getId());

			//esse volta um long, que pode ser usada em um sql.date
			//pstmt.setDate(4, (Date) contato.getDataNascimento().getTime()); esse volta uma util.data erro

			//pstm.setLong(5, contato.getId();
			pstmt.execute();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			throw new DaoException("Falha na alteração do contato",e);
		}
		
		
	}
	public void remove(Contato contato) {
		try {
			PreparedStatement pstmt = this.con.prepareStatement("delete from contatos where id=?");
			pstmt.setLong(1, contato.getId());
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			throw new DaoException("Erro na remoção ",e);
		}
		
	}
	

}
