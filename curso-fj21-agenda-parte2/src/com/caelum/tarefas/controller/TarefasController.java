package com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caelum.agenda.dao.JdbcTarefaDao;
import com.caelum.agenda.modelo.Tarefa;

@Controller
public class TarefasController {
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefas/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) throws ClassNotFoundException {
		
		
		if(result.hasFieldErrors("descricao")) {
			return "tarefas/formulario";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.inserir(tarefa);
		return "tarefas/adicionada";
	}
	

}
