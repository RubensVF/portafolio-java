package com.ruben.portfolio.seed;

import java.util.Calendar;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostSeed implements CommandLineRunner {
    
    @Autowired
    private PostService pService;

    @Override
    public void run(String... args) throws Exception {

        String content = " <h2 class=\"mb-3\">It is a long established fact a reader be distracted</h2>"+
        "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis, eius mollitia suscipit, quisquam doloremque distinctio perferendis et doloribus unde architecto optio laboriosam porro adipisci sapiente officiis nemo accusamus ad praesentium? Esse minima nisi et. Dolore perferendis, enim praesentium omnis, iste doloremque quia officia optio deserunt molestiae voluptates soluta architecto tempora.</p>";
       

        Post postUno = new Post("Docker y SpringBoot", content,"Como correr un proyecto de Spring Boot en docker con mysql.","/images/docker.jpg","docker-y-springboot",Calendar.getInstance());
        postUno = pService.save(postUno);     
        
    }


}
