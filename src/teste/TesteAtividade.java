package teste;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Model.Atividade;

/*
 * @author Edmarcos Lima
 */

public class TesteAtividade {

	//Testes de Atividade
	@Test
	public void testeInserirAtividade() {
		Atividade ev = new Atividade();
		ev.setNome("Atividade - Teste");
		ev.setDescricao("Hoje");
		ev.setData(new Date());
		ev.setHoraInicio("12:00");
		ev.setHoraTermino("12:30");
		ev.setOrientador("Minha pica");
		ev.setLocal("Sala TESTE");
		ev.setLimite(10);
		ev.setId_evento(2);
		ev.setObservacao("minha pica");
		
		AtividadeDao d = new AtividadeDao();
		d.cadastrar(ev);
		System.out.println("Inserindo Atividade");
	}
	@Test
	public void testeAlterarAtividade() {
		Atividade ev = new Atividade();
		ev.setId(2);
		ev.setNome("Atividade - Teste");
		ev.setDescricao("Amanhã");
		ev.setData(new Date());
		ev.setHoraTermino("12:00");
		ev.setHoraInicio("11:00");
		ev.setObservacao("kkk");
		ev.setOrientador("Ed");
		ev.setLocal("Sala 2");
		ev.setLimite(45);
		ev.setId_evento(1);
				
		AtividadeDao d = new AtividadeDao();
		d.alterar(ev);
		System.out.println("Alterando Atividade");
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
			System.out.println(evento.getLocal());
			System.out.println(evento.getObservacao());
			System.out.println(evento.getLimite());
		}
		
	}
	
	@Test
	public void testBuscarATV(){
		Atividade atv = new Atividade();
		atv.setId(2);
		
		atv = new AtividadeDao().buscarPorId(atv);
		
		System.out.println("--------------");
		System.out.println(atv.getId());
		System.out.println(atv.getId_evento());
		System.out.println(atv.getNome());
		System.out.println(atv.getData());
		System.out.println(atv.getHoraInicio());
		System.out.println(atv.getHoraTermino());
		System.out.println(atv.getDescricao());
		System.out.println(atv.getOrientador());
		System.out.println(atv.getLocal());
		System.out.println(atv.getObservacao());
		System.out.println(atv.getLimite());
		System.out.println("--------------");
	}
}
