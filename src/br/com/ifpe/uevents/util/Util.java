package br.com.ifpe.uevents.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class Util {

	public static boolean fazerUpload(MultipartFile imagem) {

		boolean sucesso = false;

		if (!imagem.isEmpty()) {
			String nomeArquivo = imagem.getOriginalFilename();
			try {
				// Criando o diret�rio para armazenar o arquivo
										//Alterar aqui quando for cadastrar imagens
				String workspaceProjeto = "C:/Users/Edmarcos/Desktop/uevents";
				File dir = new File(workspaceProjeto + "/WebContent/view/img/eventos");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Criando o arquivo no diret�rio
				File serverFile = new File((dir.getAbsolutePath() + File.separator + geraSalt() + "-" + nomeArquivo));
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(imagem.getBytes());
				stream.close();
				System.out.println("Arquivo armazenado em:" + serverFile.getAbsolutePath());
				System.out.println("Voc� fez o upload do arquivo " + nomeArquivo + " com sucesso");
				sucesso = true;
			} catch (Exception e) {
				System.out.println("Voc� falhou em carregar o arquivo " + nomeArquivo + " => " + e.getMessage());
			}
		} else {
			System.out.println("Voc� falhou em carregar o arquivo porque ele est� vazio ");
		}
		return sucesso;
	}

	public static String geraSalt() {

		Calendar c = Calendar.getInstance();
		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH);
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int minuto = c.get(Calendar.MINUTE);
		int segundo = c.get(Calendar.SECOND);
		
		return ano + "-" + mes + "-" + dia + "-" + hora + "-" + minuto + "-" + segundo;

	}
}
