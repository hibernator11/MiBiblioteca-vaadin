package es.ua.vaadin;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	
	private List<Book> libros;
	
	public BookRepository() {
		libros = new ArrayList<Book>();
		libros.add(new Book("1605", "El ingenioso hidalgo Don Quijote de la Mancha", "Miguel de Cervantes Saavedra"));
		libros.add(new Book("1554", "Lazarillo de Tormes", "Anonimo"));
		libros.add(new Book("1514", "La Celestina o Tragicomedia de Calisto y Melibea", "Fernando de Rojas"));
		libros.add(new Book("1619", "Fuenteovejuna", "Lope de Vega"));
		libros.add(new Book("1635", "La vida es sueño", "Lope de Vega"));
	} 
	
	List<Book> findAll(){
		return libros;
	}
	
	List<Book> findByTitle(String text){
		List<Book> resultado = new ArrayList<Book>();
		for(int i=0;i< libros.size();i++) {
	    	if(libros.get(i).getTitle().contains(text))
	    		resultado.add(libros.get(i));
	    }
		return resultado;
	}
}
