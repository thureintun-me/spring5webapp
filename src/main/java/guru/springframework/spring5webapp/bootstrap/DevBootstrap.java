package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	
	private void initData() {
		Publisher dddpPublisher = new Publisher("Harper Collins","New York");
		Publisher noEjbPublisher = new Publisher("Warx","DC");
		publisherRepository.save(dddpPublisher);
		publisherRepository.save(noEjbPublisher);
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234",dddpPublisher);
		
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "1235",noEjbPublisher);
		
		rod.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		
	}

	
	
}
