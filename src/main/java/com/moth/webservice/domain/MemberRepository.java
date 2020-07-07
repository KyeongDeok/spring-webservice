package com.moth.webservice.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	
	Optional<MemberEntity> findByEmail(String userEmail);
}
