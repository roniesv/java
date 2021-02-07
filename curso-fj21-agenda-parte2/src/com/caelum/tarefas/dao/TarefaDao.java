package com.caelum.tarefas.dao;

import java.util.List;

import com.caelum.agenda.modelo.Tarefa;

public interface TarefaDao {
	
	Tarefa buscarPorId(Long id);
	List<Tarefa>lista();
	void adiciona(Tarefa t);
	void altera(Tarefa t);
	void remove(Tarefa t);
	void finaliza(Long id);

}
