package com.ruben.portfolio.controllers;

import java.util.List;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.service.PostService;
import com.ruben.portfolio.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    
    @Autowired
    private PostService pService;


    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("projects", projectService.findAll());
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Post> posts = pService.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }
    @GetMapping("/blog/{slug}")
    public String post(@PathVariable("slug") String slug,Model model){
        Post post = pService.findBySlug(slug);
        if(post==null){
            return "redirect:/404";
        }
        model.addAttribute("post", post);
        return "post";
    }
    

}
