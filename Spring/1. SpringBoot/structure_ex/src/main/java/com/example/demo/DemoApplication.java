package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	// log
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// hello
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "hello" + name;
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args -> {
			repository.save(new Customer("leo", "aa"));
			repository.save(new Customer("you", "bb"));
			repository.save(new Customer("jun", "cc"));
			repository.save(new Customer("leo2", "aa"));


			log.info("FindAll---------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			log.info("FindById--------------------");
			Customer customer = repository.findById(1L);
			log.info(customer.toString());
			log.info("");

			log.info("FindByLastName--------------");
			repository.findByLastName("aa").forEach(customer1 -> {log.info(customer1.toString());});
			log.info("");
		};
	}
}
