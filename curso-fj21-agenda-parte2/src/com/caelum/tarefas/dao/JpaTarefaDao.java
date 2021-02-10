package com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.caelum.agenda.modelo.Tarefa;


@Repository
public class JpaTarefaDao implements TarefaDao{
	
	@PersistenceContext
	EntityManager manager;
	
	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
	}
	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}
	public List<Tarefa> lista(){
		return manager.createQuery("select t from Tarefa t").getResultList();
	}
	public Tarefa buscarPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}
	public void remove(Tarefa tarefa) {
		Tarefa tarefaARemover = buscarPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}
	public void finaliza(Long id) {
		Tarefa tarefa = buscarPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
	}
	

}
