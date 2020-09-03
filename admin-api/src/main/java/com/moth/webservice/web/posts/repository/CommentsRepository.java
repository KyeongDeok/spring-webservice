package com.moth.webservice.web.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
}
