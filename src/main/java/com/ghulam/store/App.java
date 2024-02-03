package com.ghulam.store;

import com.ghulam.store.enums.Role;
import com.ghulam.store.enums.State;
import com.ghulam.store.models.Address;
import com.ghulam.store.models.Customer;
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
	private final PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {


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

	}
}
