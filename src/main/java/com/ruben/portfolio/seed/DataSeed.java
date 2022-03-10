package com.ruben.portfolio.seed;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.model.Project;
import com.ruben.portfolio.service.PostService;
import com.ruben.portfolio.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeed  implements CommandLineRunner{

    @Autowired
    private PostService postService;

    @Autowired 
    private ProjectService projectService;

    @Override
    public void run(String... args) throws Exception {
        
        Project project1 = new Project("https://res.cloudinary.com/rubs1999/image/upload/v1646878848/Blog/skateshop_wxkunw.png","https://github.com/RubensVF/skateshop","http://skateshop.rubenvelazquez.com/customize","Threejs & modelo 3d");
        projectService.save(project1);

        Project project2 = new Project("https://res.cloudinary.com/rubs1999/image/upload/v1646878841/Blog/notas-thymeleaf_gc93rq.png","https://github.com/RubensVF/notes-thymeleaf","http://notes.rubenvelazquez.com/customize","Java(Spring Boot), Bootsrap");
        projectService.save(project2);
        Project project3 = new Project("https://res.cloudinary.com/rubs1999/image/upload/v1646878842/Blog/inmobiliaria_lazjwk.png","https://github.com/RubensVF/inmobiliaria-client","https://www.youtube.com/watch?v=AqwEmR5z89c","Java(Spring Boot), ReactJS");
        projectService.save(project3);
        Project project4 = new Project("https://res.cloudinary.com/rubs1999/image/upload/v1646878842/Blog/blog_vo2qqh.png","https://github.com/RubensVF/blog","https://www.youtube.com/watch?v=pwctCzXzV1E","Java(Spring Boot), NextJs");
        projectService.save(project4);

        Post post = new Post("Docker y Spring Boot","<h2>Hol</h2","Como dockerizas una proyecto de spring boot con mysql paso a paso","https://res.cloudinary.com/rubs1999/image/upload/v1646878842/Blog/docker_e2ykql.jpg","docker-y-spring-boot");
        postService.save(post);

    }
    
}
