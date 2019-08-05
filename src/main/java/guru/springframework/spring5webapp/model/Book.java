package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tilte;
	private String isbn;
	private String publiser;
	
	@ManyToMany
	@JoinTable(name = "author_book",joinColumns=@JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String tilte, String isbn, String publiser) {
		super();
		this.tilte = tilte;
		this.isbn = isbn;
		this.publiser = publiser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPubliser() {
		return publiser;
	}

	public void setPubliser(String publiser) {
		this.publiser = publiser;
	}
	
	
	
}
