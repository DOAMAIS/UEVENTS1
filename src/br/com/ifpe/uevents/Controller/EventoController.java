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
	@RequestMapping("inicialEvento")
	public String visualizar(){
	
		System.out.println("visualizar");
		return "telas/inicialEvento";
	}
	/*
	 * <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 * <c:forEach var="evento" items="${listaEventos}">
	 * 	 ${evento.atributos}
	 * </c:forEach>
	 * 		EventoDao dao = new EventoDao();
		List<Evento> listaEventos = dao.listar();
		model.addAttribute("listaEventos", listaEventos);
	 */
}
