package br.org.icesamambaia.sit.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testa {
	public static void main(String[] args) throws ParseException{
		Cargo cargo = new Cargo("Diretor", 8);
		
		

		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = formata.parse("11/11/1988");
		Date dataIngresso = formata.parse("01/01/1994");

		Votante f1 = new Votante("Danilo", "Sousa de Oliveira", dataNascimento, dataIngresso, "danilo.av@gmail.com",
				"61 3359-3620", "61 9 8604-8660", "daniloav11", "senha01", cargo, "012.293.981-63");
		
		SimpleDateFormat formata2 = new SimpleDateFormat("MM/yyyy");
		Date comp = formata2.parse("10/2017");
		
		SimpleDateFormat formata3 = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formata3.parse("13/10/2017");
		
		
		Dizimo diz = new Dizimo(350.00,f1, comp, data);
		System.out.println(diz.toString());
		
		
		
		
		
		
		
	
	}
	
	
}
