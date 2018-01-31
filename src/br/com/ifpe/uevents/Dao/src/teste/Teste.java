package teste;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Evento;

public class Teste {
	
	@Test
	public void testeCadastrarEvento() {
		Evento ev = new Evento();
		ev.setNome("Feijão");
		ev.setDescricao("Hoje");
		ev.setDataInicio(new Date());
		ev.setDataTermino(new Date());
		ev.setStatus("inativo");
		
		EventoDao d = new EventoDao();
		d.cadastrar(ev);
		System.out.println("Olá");
	}
	@Test
	public void testListarEventos() {
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
	
}
