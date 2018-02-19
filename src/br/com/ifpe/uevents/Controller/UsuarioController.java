package br.com.ifpe.uevents.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.uevents.Dao.UsuarioDao;
import br.com.ifpe.uevents.Model.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping("exibirLogin")
        public String exibirLogin(){ 
		return "index.jsp";
	}
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
	   return "telas/inicialEvento";
	}
	   model.addAttribute("msg", "Não foi encontrado um usuário com o login e senha informados.");
			   return "index";
	}
	@RequestMapping("exibirCadastro")
		public String exibirCadastro(){
		return "telas/cadasUsuario";
	}
}
