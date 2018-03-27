package br.com.ifpe.uevents.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;
import br.com.ifpe.uevents.util.Mensagens;

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
	public String cadastroEvento(Atividade atv, Model model){

		AtividadeDao dao = new AtividadeDao();
		dao.cadastrar(atv);
		
		model.addAttribute("msg", "Atividade Cadastrada Com Sucesso!");
		return "forward:cadasAtividade";
	}

	@RequestMapping("alterarAtividade")
	public String exibirAlterar(Atividade atv, Model model){
		
		Atividade atividade = new AtividadeDao().buscarPorId(atv);
		model.addAttribute("atividade", atividade);
		List<Evento> listaEventos = new EventoDao().listar();
		model.addAttribute("lista", listaEventos);
		
		System.out.println("Alterar Atividade");
		return "telas/alterarAtividade";
	}
	
	@RequestMapping("alteracaoEfetuada")
	public String altaAtividade(Atividade atv, Model model){

		AtividadeDao dao = new AtividadeDao();
		dao.alterar(atv);
		model.addAttribute("msg", Mensagens.AtvAlteradoSucesso);
		return "forward:paginaInicial";
	}
	
	@RequestMapping("/removerAtividade")
	public String removerAtividade(Atividade atv, Model model){
		new AtividadeDao().remover(atv);
		model.addAttribute("msg", Mensagens.AtvExcluidoSucesso);
		
		return "forward:paginaInicial";
	}
}
