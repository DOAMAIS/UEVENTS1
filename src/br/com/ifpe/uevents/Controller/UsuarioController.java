package br.com.ifpe.uevents.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	public String efetuaLogin(Usuario usuario, HttpSession session) {
	if(new UsuarioDao().login(usuario)) {
	session.setAttribute("usuarioLogado", usuario);
	return "index.jsp";
	}
	return "redirect:";
	}
}
