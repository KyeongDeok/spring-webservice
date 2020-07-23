package com.moth.webservice.web.posts.model;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<PostsEntity,Long>{
	
	@Query("SELECT p "+
					"FROM PostsEntity p "+
						"ORDER BY p.id DESC")
	Stream<PostsEntity>findAllDesc();
}
