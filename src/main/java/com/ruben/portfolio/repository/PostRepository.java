package com.ruben.portfolio.repository;

import com.ruben.portfolio.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
    public Post findBySlug(String slug);
}
