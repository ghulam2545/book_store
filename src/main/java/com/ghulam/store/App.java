package com.ghulam.store;

import com.ghulam.store.enums.Genre;
import com.ghulam.store.enums.Role;
import com.ghulam.store.enums.State;
import com.ghulam.store.models.Address;
import com.ghulam.store.models.Book;
import com.ghulam.store.models.Customer;
import com.ghulam.store.repositories.BookRepository;
import com.ghulam.store.repositories.CustomerRepository;
import com.ghulam.store.utils.IdGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@SpringBootApplication
public class App implements ApplicationRunner {

	private final CustomerRepository customerRepo;
	private final BookRepository bookRepo;
	private final PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {

		List<Book> books = List.of(
				// Sports
				new Book(IdGenerator.next(), "Shoe Dog", Set.of("Phil Knight"), "The founder of Nike's story", Genre.SPORT, "978-0-609-88761-7", "Penguin Random House", 1999),
				new Book(IdGenerator.next(), "Open", Set.of("Andre Agassi"), "A tennis legend's candid memoir", Genre.SPORT, "978-0-312-35240-5", "Alfred A. Knopf", 1799),
				new Book(IdGenerator.next(), "Moneyball", Set.of("Michael Lewis"), "Defying baseball's wisdom", Genre.SPORT, "978-0-385-73407-5", "W. W. Norton & Company", 1499),

				// Education
				new Book(IdGenerator.next(), "Outliers", Set.of("Malcolm Gladwell"), "Success factors explored", Genre.EDUCATION, "978-0-316-16530-6", "Little, Brown and Company", 2299),
				new Book(IdGenerator.next(), "Sapiens: A Brief History of Humankind", Set.of("Yuval Noah Harari"), "Humankind's sweeping history", Genre.EDUCATION, "978-0-345-45550-9", "HarperCollins", 2999),
				new Book(IdGenerator.next(), "A Short History of Nearly Everything", Set.of("Bill Bryson"), "Humorous science journey", Genre.EDUCATION, "978-0-06-093433-5", "Broadway Books", 1899),

				// Health
				new Book(IdGenerator.next(), "Eat This Much: The Simple Meal Planner for Healthy Cooking", Set.of("Leanne Brown"), "Personalized healthy meal plans", Genre.HEALTH, "978-1-4262-1523-3", "Simon & Schuster", 1699),
				new Book(IdGenerator.next(), "The Power of Habit", Set.of("Charles Duhigg"), "Shaping lives through habits", Genre.HEALTH, "978-1-4391-6034-6", "Random House", 1999),
				new Book(IdGenerator.next(), "Mindfulness in Plain English", Set.of("Bhante Gunaratana"), "Practical mindfulness guide", Genre.HEALTH, "978-0-8069-2500-5", "Wisdom Publications", 1499),

				// Politics
				new Book(IdGenerator.next(), "Factfulness", Set.of("Hans Rosling"), "Challenging negative world views", Genre.POLITICS, "978-0-14-312930-0", "Flatiron Books", 2499),
				new Book(IdGenerator.next(), "How Democracies Die", Set.of("Steven Levitsky", "Daniel Ziblatt"), "Protecting democratic institutions", Genre.POLITICS, "978-0-14-310350-5", "Crown Books", 2299),
				new Book(IdGenerator.next(), "On Tyranny", Set.of("Timothy Snyder"), "Twenty lessons against tyranny", Genre.POLITICS, "978-0-465-09103-7", "Basic Books", 1799),

				// Technology
				new Book(IdGenerator.next(), "Coders: The Making of a New World", Set.of("Margaret Levi"), "Computer programming's history", Genre.TECHNOLOGY, "978-0-14-313232-0", "Viking", 2999),
				new Book(IdGenerator.next(), "The Singularity is Near", Set.of("Ray Kurzweil"), "AI surpassing human intelligence", Genre.TECHNOLOGY, "978-0-14-303782-4", "Viking", 1899),
				new Book(IdGenerator.next(), "Homo Deus: A Brief History of Tomorrow", Set.of("Yuval Noah Harari"), "AI's impact on humanity", Genre.TECHNOLOGY, "978-0-06-230206-5", "HarperCollins", 2799)
		);


		List<Customer> customers = List.of(

				new Customer(IdGenerator.next(), "Alice", "Smith", "alice.smith@example.com", "alicesmith", encoder.encode("password1"), Set.of(Role.USER),
						new Address(IdGenerator.next(), "25A", "Park Lane", "Greenville", "New York", State.PUNJAB, "432156"),
						"1234567890"),
				new Customer(IdGenerator.next(), "Bob", "Johnson", "bob.johnson@example.com", "bjohnson", encoder.encode("password2"), Set.of(Role.USER, Role.ADMIN),
						new Address(IdGenerator.next(), "36B", "Main Street", "Springfield", "Chicago", State.UTTAR_PRADESH, "543216"),
						"9876543210"),
				new Customer(IdGenerator.next(), "Sarah", "Lee", "sarah.lee@example.com", "sly", encoder.encode("password3"), Set.of(Role.USER),
						new Address(IdGenerator.next(), "17C", "Sunset Boulevard", "Beverly Hills", "Los Angeles", State.MAHARASHTRA, "910112"),
						"5551234567"),

				new Customer(IdGenerator.next(), "David", "Garcia", "david.garcia@example.com", "daveG", encoder.encode("password4"), Set.of(Role.USER),
						new Address(IdGenerator.next(), "48D", "Queen Street", "Toronto", "Ontario", State.KARNATAKA, "222B2"),
						"4167890123"),

				new Customer(IdGenerator.next(), "Maria", "Rodriguez", "maria.rodriguez@example.com", "mrodriguez", encoder.encode("password5"), Set.of(Role.USER),
						new Address(IdGenerator.next(), "29E", "Bahnhofstrasse", "Zurich", "Switzerland", State.PUNJAB, "8001"),
						"+41 44 555 6667"),

				new Customer(IdGenerator.next(), "Ahmed", "Khan", "ahmed.khan@example.com", "akhan", encoder.encode("password6"), Set.of(Role.USER),
						new Address(IdGenerator.next(), "8F", "Sheikh Zayed Road", "Dubai", "United Arab Emirates", State.ANDHRA_PRADESH, "12345"),
						"+971 50 123 4567"),

				new Customer(IdGenerator.next(), "Elena", "Petrova", "elena.petrova@example.com", "elenaP", encoder.encode("password7"), Set.of(Role.USER, Role.ADMIN),
						new Address(IdGenerator.next(), "30G", "Nevsky Prospekt", "Saint Petersburg", "Russia", State.TAMIL_NADU, "191011"),
						"+7 812 123 4567")
		);

		customerRepo.saveAll(customers);
		bookRepo.saveAll(books);

	}
}
