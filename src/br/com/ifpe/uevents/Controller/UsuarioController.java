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
	
		@RequestMapping("cadasUsuario")
		public String cadastro(){
			return "telas/cadasUsuario";
		}
		@RequestMapping("inserirUsuario")
		public String inserirUser(Usuario usuario, Model model){
			UsuarioDao dao = new UsuarioDao();
			dao.cadastrar(usuario);
			
		model.addAttribute("msg", Mensagens.UsuarioCadastradoSucesso);

			return "telas/cadasUsuario";
		}
		
		@RequestMapping("/home")
		public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
			UsuarioDao dao = new UsuarioDao();
			Usuario usuarioLogado = dao.buscarUsuario(usuario);
			if (usuarioLogado != null) {
				//Lista de Eventos
				List<Evento> listaEventos = new EventoDao().listar();
				model.addAttribute("listaEventos", listaEventos);
				//Lista de Atividades
				List<Atividade> listaAtividades = new AtividadeDao().listarAtividadeUsuario(usuarioLogado);
				model.addAttribute("listaAtividades", listaAtividades);
				//Lista de Atividades do Usuario
				List<Atividade> atvsUsuarioLogado = new UsuarioDao().listarAtvs(usuarioLogado);
				model.addAttribute("atvsUsuarioLogado", atvsUsuarioLogado);
	
				session.setAttribute("usuarioLogado", usuarioLogado);
			    return "telas/inicialEvento";
			}
			model.addAttribute("msg", Mensagens.UsuarioSenhaInvalido);
			return "telas/index";
		}

		@RequestMapping("/participarAtividade")
		public String participarK(Atividade atividade, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			return "telas/confirmarParticicacao";
		}
		
		@RequestMapping("/participacaoConfirmada")
		public String participar(Atividade atividade, HttpSession session, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			UsuarioDao dao = new UsuarioDao();
			dao.participarAtividade(usuarioLogado, atividade);
			model.addAttribute("msg", Mensagens.ParticipacaoConfirmada);
			
			//Lista de Eventos
			List<Evento> listaEventos = new EventoDao().listar();
			model.addAttribute("listaEventos", listaEventos);
			//Lista de Atividades
			List<Atividade> listaAtividades = new AtividadeDao().listarAtividadeUsuario(usuarioLogado);
			model.addAttribute("listaAtividades", listaAtividades);
			//Lista de Atividades do Usuário
			List<Atividade> atvsUsuarioLogado = new UsuarioDao().listarAtvs(usuarioLogado);
			model.addAttribute("atvsUsuarioLogado", atvsUsuarioLogado);
	
			return "telas/inicialEvento";
		}
		
		@RequestMapping("/desistirParticipacao")
		public String cancelar(Atividade atividade, HttpSession session, Model model){

			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
			model.addAttribute("msg", Mensagens.ParticipacaoCancelada);
			
			//Lista de Eventos
			List<Evento> listaEventos = new EventoDao().listar();
			model.addAttribute("listaEventos", listaEventos);
			//Lista de Atividades
			List<Atividade> listaAtividades = new AtividadeDao().listarAtividadeUsuario(usuarioLogado);
			model.addAttribute("listaAtividades", listaAtividades);
			//Lista de Atividades do Usuário
			List<Atividade> atvsUsuarioLogado = new UsuarioDao().listarAtvs(usuarioLogado);
			model.addAttribute("atvsUsuarioLogado", atvsUsuarioLogado);
	
			return "telas/inicialEvento";
		}
		
		 @RequestMapping("/logout")
		 public String logout(HttpSession session) {
		    session.invalidate();
		    return "telas/index";
		 }

}
