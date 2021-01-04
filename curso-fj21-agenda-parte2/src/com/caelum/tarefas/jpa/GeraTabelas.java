package com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.caelum.agenda.modelo.Tarefa;

public class GeraTabelas {
	public static void main(String[] args) {

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		

		factory.close();
		
	}

}
