package teste;

import java.util.List;

import org.junit.Test;

import br.com.ifpe.uevents.Dao.UsuarioDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Usuario;
/*
 * @author Edmarcos Lima
 */
public class TesteUsuario {

	@Test
	public void testInserirUsuario(){
		Usuario usu = new Usuario();
		usu.setCpf("123123123123");
		usu.setIdTipoUsuario(1);//convidado
		usu.setEmail("ed@gmail.com");
		usu.setNome("Edbolado");
		usu.setSenha("1212");
		
		new UsuarioDao().cadastrar(usu);
	}
	
	@Test
	public void testAlterarUsuario(){
		Usuario usu = new Usuario();
		usu.setId(7);
		usu.setCpf("123123123123");
		usu.setIdTipoUsuario(1);//convidado
		usu.setEmail("edmarcos@gmail.com");
		usu.setNome("Edbolado - TESTE");
		usu.setSenha("1234");
		
		new UsuarioDao().alterar(usu);
	}
	
	@Test
	public void testeListarAtvs(){
		Usuario usu = new Usuario();
		usu.setId(2);
		
		List<Atividade> listaAtvs = new UsuarioDao().listarAtvs(usu);
		for (Atividade atv : listaAtvs) {
			System.out.println(atv.getNome());
			System.out.println(atv.getData());
			System.out.println(atv.getHoraInicio().substring(0, 5));
		}
	}
	
	@Test
	public void testeParticiparAtvs(){
		Usuario usu = new Usuario();
		usu.setId(2);
		
		Atividade atv = new Atividade();
		atv.setId(1);
		
		new UsuarioDao().participarAtividade(usu, atv);

	}
}
