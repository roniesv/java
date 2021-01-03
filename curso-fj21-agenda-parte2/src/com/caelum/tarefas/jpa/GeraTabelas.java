package com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.caelum.agenda.modelo.Tarefa;

public class GeraTabelas {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudando JPA");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Id da tarefa"+tarefa.getId());
		
		
		manager.close();
		factory.close();
		
	}

}
