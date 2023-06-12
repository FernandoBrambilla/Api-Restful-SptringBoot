package apiApplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiApplication.domain.Post;
import apiApplication.domain.User;
import apiApplication.repository.PostRepository;
import apiApplication.services.exceptions.ObjectNotFoundException;



@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj= postRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	

}
