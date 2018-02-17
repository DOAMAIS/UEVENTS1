package br.com.ifpe.uevents.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;

@Controller
public class AtividadeController {
	
	@RequestMapping("cadasAtividade")
	public String exibir(Model model){
		
		EventoDao dao = new EventoDao();
		List<Evento> listaEventos = dao.listar();
		model.addAttribute("lista", listaEventos);
		
		System.out.println("Cadastro Atividade");
		return "telas/cadasAtividade";
	}
	@RequestMapping("inserirAtividade")
	public String cadastroEvento(Atividade evento){

		AtividadeDao dao = new AtividadeDao();
		dao.cadastrar(evento);
		
		return "forward:cadasAtividade";
	}

}
