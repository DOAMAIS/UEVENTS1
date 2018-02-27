package teste;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Evento;

/*
 * @author Edmarcos Lima
 */

public class TesteEvento {
	
	@Test
	public void testeInserirEvento() {
		Evento ev = new Evento();
		ev.setNome("Evento - Teste");
		ev.setDescricao("Hoje");
		ev.setDataInicio(new Date());
		ev.setDataTermino(new Date());
		ev.setStatus("inativo");
		
		EventoDao d = new EventoDao();
		d.cadastrar(ev);
		System.out.println("Inserindo Evento");
	}
	
	@Test
	public void testeAlterarEvento() {
		Evento ev = new Evento();
		ev.setId(2);
		ev.setNome("Evento - Teste");
		ev.setDescricao("Hoje");
		ev.setDataInicio(new Date());
		ev.setDataTermino(new Date());
		ev.setStatus("inativo");
		
		EventoDao d = new EventoDao();
		d.alterar(ev);
		System.out.println("Alterando Evento");
	}
	@Test
	public void testeListarEvento() {
		EventoDao d = new EventoDao();
		List<Evento> lista = d.listar();
		
		for (Evento evento : lista) {
			System.out.println("--------------");
			System.out.println(evento.getId());
			System.out.println(evento.getNome());
			System.out.println(evento.getDataInicio());
			System.out.println(evento.getDataTermino());
			System.out.println(evento.getDescricao());
			System.out.println(evento.getStatus());
			System.out.println(evento.getFoto());
		}
		
	}
	
	//Comentário
}
