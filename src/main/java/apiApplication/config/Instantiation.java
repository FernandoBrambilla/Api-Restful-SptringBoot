package apiApplication.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import apiApplication.domain.User;
import apiApplication.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new  User(null, "Maria Siva", "maria@email.com");
		User jose = new  User(null, "José Siva", "jose@email.com");
		User marta = new  User(null, "Marta Siva", "marta@email.com");
		
		userRepository.saveAll(Arrays.asList(maria, jose, marta));
		
	}
	
	

}
