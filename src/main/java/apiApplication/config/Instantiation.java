package apiApplication.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import apiApplication.domain.Post;
import apiApplication.domain.User;
import apiApplication.dto.AuthorDto;
import apiApplication.dto.CommentDto;
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
		
		User maria = new  User(null, "Maria Silva", "maria@email.com");
		User jose = new  User(null, "José Silva", "jose@email.com");
		User marta = new  User(null, "Marta Silva", "marta@email.com");
		userRepository.saveAll(Arrays.asList(maria, jose, marta));
		
		Post post1 = new Post(null, sdf.parse("12/06/2023"), "Partiu Viagem!!!", "Viajando para a praia", new AuthorDto(maria));
		Post  post2 = new Post(null, sdf.parse("12/06/2023"), "Bom dia!!!", "Que belo dia hoje", new AuthorDto(maria) );
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		CommentDto comment1 = new CommentDto("Boa viagem!", sdf.parse("13/06/2023"), new AuthorDto(jose));
		CommentDto comment2 = new CommentDto("Aproveite bem!", sdf.parse("13/06/2023"), new AuthorDto(marta));
		CommentDto comment3 = new CommentDto("Tenha um ótimo dia", sdf.parse("13/06/2023"), new AuthorDto(jose));
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
	
	

}
