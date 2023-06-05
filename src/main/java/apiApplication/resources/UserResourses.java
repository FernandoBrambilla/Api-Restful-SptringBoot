package apiApplication.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apiApplication.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResourses {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Salete", "maria@email.com");	
		User rafael = new User("2", "Rafael Silva", "rafael@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, rafael));
		return ResponseEntity.ok().body(list);
	}

}
