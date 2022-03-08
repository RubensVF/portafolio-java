package com.ruben.portfolio.controllers;

import java.util.Calendar;
import java.util.List;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @Autowired
    private PostService pService;

    @GetMapping("/")
    public String index(){
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

    @GetMapping("/admin")
    public String admin(Model model){
        List<Post> posts = pService.findAll();
        model.addAttribute("posts", posts);
        return "admin";
    }

    @GetMapping("/admin/edit")
    public String editPost(@RequestParam("id") Long id,Model model){
        Post post = pService.findById(id);

        if(post==null){
            return "redirect:/404";
        }
        model.addAttribute("post", post);
        return "editpost";
    }

    @PostMapping("/admin/editpost")
    public String editpost(Post post){
        post.setDate(Calendar.getInstance());
        pService.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/admin/newpost")
    public String newPost(Model model){
        Post post = new Post();

        model.addAttribute("post", post);
        return "newpost";
    }


    @PostMapping("/admin/newpost")
    public String newpost(@ModelAttribute("post") Post post){
        post.setDate(Calendar.getInstance());
       pService.save(post);
        return "redirect:/blog";
    }


    @GetMapping("admin/delete")
    public String deleteNote(@RequestParam(name = "id") Long id){
        pService.deleteById(id);
        return "redirect:/blog";
    }

}
