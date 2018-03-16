package br.com.ifpe.uevents.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.DocumentException;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Dao.UsuarioDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;
import br.com.ifpe.uevents.Model.Usuario;
import br.com.ifpe.uevents.util.HtmlToPdf;
import br.com.ifpe.uevents.util.Mensagens;
import br.com.ifpe.uevents.util.Util;

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
		
		@RequestMapping("cadasProf")
		public String cadastroa(){
			return "telas/cadasProf";
		}
		@RequestMapping("inserirProf")
		public String inserirUsera(Usuario usuario, Model model){
			UsuarioDao dao = new UsuarioDao();
			dao.cadastrar(usuario);
			model.addAttribute("msg", Mensagens.UsuarioCadastradoSucesso);

			return "telas/cadasProf";
		}

		@RequestMapping("/paginaInicial")
		public String homepage(HttpSession session, Model model){
			
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			
			usuarioLogado = new UsuarioDao().buscarPorId(usuarioLogado);
			
			//Lista de Eventos
			List<Evento> listaEventos = new EventoDao().listar();
			model.addAttribute("listaEventos", listaEventos);
			//Lista de Atividades
			List<Atividade> listaAtividades = new AtividadeDao().listarAtividadeUsuario(usuarioLogado);
			model.addAttribute("listaAtividades", listaAtividades);
			//Lista de Atividades do UsuÃ¡rio
			List<Atividade> atvsUsuarioLogado = new UsuarioDao().listarAtvs(usuarioLogado);
			model.addAttribute("atvsUsuarioLogado", atvsUsuarioLogado);
			
			session.setAttribute("usuarioLogado", usuarioLogado);
			
			if(usuarioLogado.getId() == 1){
				return "telas/inicialAdm";
			}
			
			return "telas/inicialEvento";
		}
		
		@RequestMapping("/home")
		public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
			UsuarioDao dao = new UsuarioDao();
			Usuario usuarioLogado = dao.buscarUsuario(usuario);
			if (usuarioLogado != null) {
				session.setAttribute("usuarioLogado", usuarioLogado);
			    return "forward:paginaInicial";
			}
			model.addAttribute("msg", "Login e/ou senha inválidos.");
			return "telas/index";
		}

		@RequestMapping("/participarAtividade")
		public String exibirParticiparAtividade(Atividade atividade, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			return "telas/confirmarParticicacao";
		}
		
		@RequestMapping("/cancelarAtividade")
		public String cancelar(Atividade atividade, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			return "telas/cancelarParticipacao";
		}
		
		@RequestMapping("/participacaoConfirmada")
		public String participar(Atividade atividade, HttpSession session, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			UsuarioDao dao = new UsuarioDao();
			dao.participarAtividade(usuarioLogado, atividade);
			model.addAttribute("msg", Mensagens.ParticipacaoConfirmada);
	
			return "forward:paginaInicial";
		}
		
		@RequestMapping("/cancelamentoConfirmado")
		public String cancelarAtividade(Atividade atividade, HttpSession session, Model model){
			Atividade atvEscolhida = new AtividadeDao().buscarPorId(atividade);
			model.addAttribute("atvEscolhida", atvEscolhida);
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			UsuarioDao dao = new UsuarioDao();
			dao.removerAtividade(usuarioLogado, atividade);
			model.addAttribute("msg", Mensagens.ParticipacaoCancelada);
	
			return "forward:paginaInicial";
		}
		
		@RequestMapping("/desistir")
		public String cancelar(Atividade atividade, HttpSession session, Model model){
			return "forward:paginaInicial";
		}

		@RequestMapping("/exibirAlterarUsuario")
	    public String exibirAlterarUsuario() {
			return "telas/alterarUsuario";
	    }
		@RequestMapping("/alterarUsuario")
	    public String alterarUsuario(Usuario Usuario, Model model) {	
			UsuarioDao dao = new UsuarioDao();
			dao.alterar(Usuario);
			model.addAttribute("msg", Mensagens.UsuarioAterado);
			return "forward:paginaInicial";
	    }
		
		@RequestMapping("/gerarAta")
	    public String gerarAta(Atividade atv, Model model) throws IOException, DocumentException {	
			String nomeAtv = new AtividadeDao().buscarPorId(atv).getNome();
			HtmlToPdf.createPdf(Util.geraSalt()+"ata_da_atv_"+nomeAtv, atv);
			
			model.addAttribute("msg", "Ata gerada com sucesso");
			return "forward:paginaInicial";
	    }
		
		 @RequestMapping("/logout")
		 public String logout(HttpSession session) {
		    session.invalidate();
		    return "telas/index";
		 }

}
