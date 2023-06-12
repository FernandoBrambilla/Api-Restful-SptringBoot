package apiApplication.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import apiApplication.domain.Post;
import apiApplication.domain.User;
import apiApplication.repository.PostRepository;
import apiApplication.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone (TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new  User(null, "Maria Siva", "maria@email.com");
		User jose = new  User(null, "José Siva", "jose@email.com");
		User marta = new  User(null, "Marta Siva", "marta@email.com");
		userRepository.saveAll(Arrays.asList(maria, jose, marta));
		
		Post post1 = new Post(null, sdf.parse("12/06/2023"), "Partiu Viagem!!!", "Viajando para a praia", maria);
		Post  post2 = new Post(null, sdf.parse("12/06/2023"), "Bom dia!!!", "Que belo dia hoje", maria );
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
	
	

}
