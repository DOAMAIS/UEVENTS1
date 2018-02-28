package br.com.ifpe.uevents.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Dao.UsuarioDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;
import br.com.ifpe.uevents.Model.Usuario;
import br.com.ifpe.uevents.util.Mensagens;

@Controller
public class UsuarioController {
	
	@RequestMapping("/cadasUsuario")
	public String cadastro(){
		return "telas/cadasUsuario";
	}
	@RequestMapping("inserirUsuario")
	public String inserirUser(Usuario usuario){
		UsuarioDao dao = new UsuarioDao();
		dao.cadastrar(usuario);
		model.addAttribute("qtdEventos",Mensagens.UsuarioCadastradoSucesso);
		model.addAttribute("listaEventos", listaEventos);
		return "telas/cadasUsuario";
	}
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		if (usuarioLogado != null) {
			//usuarioLogado.setAtividades(dao.listarAtvs(usuario));
			List<Evento> listaEventos = new EventoDao().listar();
			model.addAttribute("qtdEventos", listaEventos.size());
			model.addAttribute("listaEventos", listaEventos);
			List<Atividade> atvsUsuarioLogado = new UsuarioDao().listarAtvs(usuarioLogado);
			model.addAttribute("atvsUsuarioLogado", atvsUsuarioLogado);
			List<Atividade> listaAtividades = new AtividadeDao().listar();
			model.addAttribute("listaAtividades", listaAtividades);
			session.setAttribute("usuarioLogado", usuarioLogado);
		    return "telas/inicialEvento";
		}
		model.addAttribute("msg", "Login e/ou senha inválidos.");
		return "telas/index";
	}
	
	@RequestMapping("confirmarParticipacao")
	public String participar(Atividade atividade, HttpSession session, Model model){
		Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
		model.addAttribute("atvEscolhida", atvEscolhida);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		UsuarioDao dao = new UsuarioDao();
		dao.participarAtividade(usuarioLogado, atividade);
		return "telas/confirmarParticipacao";
	}
	 @RequestMapping("logout")
	 public String logout(HttpSession session) {
	    session.invalidate();
	    return "telas/index";
	 }

}
