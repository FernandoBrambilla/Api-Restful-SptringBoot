package apiApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import apiApplication.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}