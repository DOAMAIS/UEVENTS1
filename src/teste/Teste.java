package teste;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Dao.EventoDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Evento;

public class Teste {
	
	@Test
	public void testeInserirEvento() {
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
	@Test
	public void testeInserirAtividade() {
		Atividade ev = new Atividade();
		ev.setNome("Feijão");
		ev.setDescricao("Hoje");
		ev.setData(new Date());
		ev.setHoraInicio("12:00");
		ev.setHoraTermino("12:30");
		ev.setOrientador("Minha pica");
		ev.setLimite(10);
		ev.setId_evento(4);
		ev.setObservacao("minha pica");
		
		AtividadeDao d = new AtividadeDao();
		d.cadastrar(ev);
		System.out.println("Olá");
	}
	@Test
	public void testeListarAtividade() {
		AtividadeDao d = new AtividadeDao();
		List<Atividade> lista = d.listar();
		
		for (Atividade evento : lista) {
			System.out.println("--------------");
			System.out.println(evento.getId());
			System.out.println(evento.getId_evento());
			System.out.println(evento.getNome());
			System.out.println(evento.getData());
			System.out.println(evento.getHoraInicio());
			System.out.println(evento.getHoraTermino());
			System.out.println(evento.getDescricao());
			System.out.println(evento.getOrientador());
			System.out.println(evento.getObservacao());
			System.out.println(evento.getLimite());
		}
		
	}
	
	//Comentário
}
