package com.ruben.portfolio.controllers;

import java.util.Calendar;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.model.Project;
import com.ruben.portfolio.service.PostService;
import com.ruben.portfolio.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {


    @Autowired
    private PostService pService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/admin")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("/admin/posts")
    public String posts(Model model){
        model.addAttribute("posts", pService.findAll());
        return "admin/blog/posts";
    }

    @GetMapping("/admin/newpost")
    public String newPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/blog/newpost";
    }

    @PostMapping("/admin/newpost")
    public String newpost(@ModelAttribute("post") Post post){
        post.setDate(Calendar.getInstance());
       pService.save(post);
        return "redirect:/admin/posts";
    }

    @GetMapping("admin/delete")
    public String deleteNote(@RequestParam(name = "id") Long id){
        pService.deleteById(id);
        return "redirect:/admin/posts";
    }

    @GetMapping("/admin/edit")
    public String editPost(@RequestParam("id") Long id,Model model){
        Post post = pService.findById(id);

        if(post==null){
            return "redirect:/404";
        }
        model.addAttribute("post", post);
        return "admin/blog/editpost";
    }

    @GetMapping("/admin/projects")
    public String projects(Model model){
        model.addAttribute("posts", projectService.findAll());
        return "admin/projects/projects";
    }

    @GetMapping("/admin/newproject")
    public String newProject(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "admin/projects/newproject";
    }


    @PostMapping("/admin/newproject")
    public String newproject(@ModelAttribute("post") Project project){
       projectService.save(project);
        return "redirect:/admin/projects";
    }

    @GetMapping("admin/deleteproject")
    public String deleteProjevt(@RequestParam(name = "id") Long id){
        projectService.deleteById(id);
        return "redirect:/admin/projects";
    }


    @GetMapping("/admin/editproject")
    public String editProject(@RequestParam("id") Long id,Model model){
        Project project = projectService.findById(id);
        if(project==null){
            return "redirect:/404";
        }

        model.addAttribute("project",project);
        return "admin/projects/editproject";
    }
    
}
