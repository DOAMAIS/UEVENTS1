package br.com.ifpe.uevents.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;
import br.com.ifpe.uevents.util.Mensagens;
import br.com.ifpe.uevents.util.Util;

@Controller
public class EventoController {

	@RequestMapping("cadasEvento")
	public String exibir(){
		System.out.println("Cadastro Evento");
		return "telas/cadasEvento";
	}
	
	@RequestMapping("inserirEvento")
	public String cadastroEvento(Evento evento, @RequestParam("file") MultipartFile imagem){

		if(Util.fazerUpload(imagem)){
			evento.setFoto(Util.geraSalt() + "-" + imagem.getOriginalFilename());
		}

		EventoDao dao = new EventoDao();
		dao.cadastrar(evento);

		return "telas/cadasEvento";
	}

	@RequestMapping("visualizarEventos")
	public String visualizar(Model model){
		EventoDao dao = new EventoDao();
		List<Evento> listaEventos = dao.listar();
		model.addAttribute("listaEventos", listaEventos);
		List<Atividade> listaAtividades = new AtividadeDao().listar();
		model.addAttribute("listaAtividades", listaAtividades);
		System.out.println("visualizar");
		return "telas/visualizarEvento";
	}

	@RequestMapping("/removerEvento")
	public String removerEventos(Evento evento, Model model) {

		EventoDao dao = new EventoDao();
		dao.remover(evento);
		model.addAttribute(Mensagens.EvExcluidoSucesso);

		return "telas/InicialEvento";
	}

	@RequestMapping("/alterarEvento")
    public String exibirAlterarEvento(Evento evento, Model model) {

		EventoDao dao = new EventoDao();
		Evento eventoCompleto = dao.buscarPorId(evento.getId());
		model.addAttribute("evento", eventoCompleto);
	
		return "telas/alterarEvento";
    }

    @RequestMapping("/eventoAlterado")
    public String alterarEvento(Evento evento, Model model) {

		EventoDao dao = new EventoDao();
		dao.alterar(evento);
		model.addAttribute("msg", Mensagens.EvAlteradoSucesso);
	

		return "forward:paginaInicial";
    }
}
