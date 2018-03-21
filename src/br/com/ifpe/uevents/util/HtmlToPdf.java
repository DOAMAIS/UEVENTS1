package br.com.ifpe.uevents.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import br.com.ifpe.uevents.Dao.AtividadeDao;
import br.com.ifpe.uevents.Model.Atividade;
import br.com.ifpe.uevents.Model.Usuario;



public class HtmlToPdf {



	public static void main(String[] args) throws IOException, DocumentException {

		Atividade ae = new Atividade();
		
		ae.setId(1);
		createPdf(Util.geraSalt()+"ATA-DA-ATV.pdf", ae);

	}

	

	public static void createPdf(String dest, Atividade atv) throws IOException, DocumentException {

		Atividade atividade = new AtividadeDao().buscarPorId(atv);
		
		List<Usuario> usuariosParticipantes = new AtividadeDao().listarUsuariosParticipantes(atividade);
		
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("/home/gabriel/git/UEVENTS1/WebContent/view/pdf/"+dest));

        document.open();

        PdfPTable table;

        PdfPCell cell;

        

        Chunk glue = new Chunk(new VerticalPositionMark());

        Paragraph p = new Paragraph("Lista de participantes da atividade : "+ atividade.getNome());

        p.add(new Chunk(glue));

        DottedLineSeparator dottedline = new DottedLineSeparator();

        dottedline.setOffset(-2);

        dottedline.setGap(2f);

        p.add(dottedline);

        document.add(p);

        p = new Paragraph("    ");

        document.add(p);

        document.add(p);

        

        table = new PdfPTable(2);

        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        table.setWidthPercentage(100);

        table.setSpacingAfter(0);



        cell = new PdfPCell(new Phrase("Participantes  "));

        cell.setBorder(PdfPCell.LEFT | PdfPCell.TOP | PdfPCell.BOTTOM);

        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Assinatura"));

        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        cell.setBorder(PdfPCell.RIGHT | PdfPCell.TOP | PdfPCell.BOTTOM);

        table.addCell(cell);

       

        

        for (Usuario user : usuariosParticipantes){

        	table.setHorizontalAlignment(Element.ALIGN_LEFT);

	        table.setWidthPercentage(100);

	        table.setSpacingAfter(0);

	        cell = new PdfPCell(new Phrase(user.getNome()));

	        cell.setBorder(PdfPCell.LEFT | PdfPCell.TOP | PdfPCell.BOTTOM);

	        table.addCell(cell);

	        cell = new PdfPCell(new Phrase(""));

	        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

	        cell.setBorder(PdfPCell.RIGHT | PdfPCell.TOP | PdfPCell.BOTTOM);

	        table.addCell(cell);

        }

        

       

        document.add(table);

        p = new Paragraph("    ");

        document.add(p);

        document.add(p);

        p = new Paragraph(" Quantidade de participantes: "+usuariosParticipantes.size());

        document.add(p);

        document.close();
	
	//Abrir arquivo
	
	Desktop desktop = Desktop.getDesktop();

        File file = new File("/home/gabriel/git/UEVENTS1/WebContent/view/pdf/"+dest);

        desktop.open(file);

    }

	

	

	

}

