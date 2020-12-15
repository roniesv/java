package com.caelum.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("listaTarefas")
	public String lista(Model model) throws ClassNotFoundException{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.getLista();
		model.addAttribute("tarefas", tarefas);
		return "tarefas/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) throws ClassNotFoundException {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) throws ClassNotFoundException {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscarPorId(id));
		return "tarefas/mostra";
	}
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) throws ClassNotFoundException {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";
		
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws ClassNotFoundException {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscarPorId(id));
		return "tarefas/Finalizada";
	}
	@ResponseBody
	@RequestMapping("removeTarefa1")
	public void remove1(Long id) throws ClassNotFoundException{
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove1(id);
		
	}
	
	

}
