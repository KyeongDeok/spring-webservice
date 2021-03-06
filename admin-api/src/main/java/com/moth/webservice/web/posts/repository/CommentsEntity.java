package com.moth.webservice.web.posts.repository;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Builder
@Getter
public class CommentsEntity {

    @Id
    @GeneratedValue
    private Long id;

    Long postsId;

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer score;

    @NotEmpty
    private String comment;
}
