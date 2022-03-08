package com.ruben.portfolio.service;

import java.util.List;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository pRepository;

    public List<Post> findAll(){
        return (List<Post>) pRepository.findAll();
    }

    public Post findBySlug(String slug){
        return pRepository.findBySlug(slug);
    }

    public Post findById(Long id){
        return pRepository.findById(id).orElse(null);
    }

    public Post save(Post post){
        return pRepository.save(post);
    }

    public void deleteById(Long id){
        pRepository.deleteById(id);
        return;
    }
}
