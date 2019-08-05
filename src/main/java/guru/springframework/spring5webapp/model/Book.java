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
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String isbn;
	@OneToOne
	private Publisher publisher;
	
	
	@ManyToMany
	@JoinTable(name = "author_book",joinColumns=@JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();
	
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String isbn,Publisher publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher=publisher;
		
	}
	
	

	public Book(Long id, String title, String isbn, Publisher publisher, Set<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublishers() {
		return publisher;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
	
	
	
}
