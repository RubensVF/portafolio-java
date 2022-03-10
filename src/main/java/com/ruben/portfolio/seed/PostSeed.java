package com.ruben.portfolio.seed;

import com.ruben.portfolio.model.Post;
import com.ruben.portfolio.model.Project;
import com.ruben.portfolio.service.PostService;
import com.ruben.portfolio.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostSeed implements CommandLineRunner {
    
    @Autowired
    private PostService pService;

    @Autowired 
    private ProjectService projectService;

    @Override
    public void run(String... args) throws Exception {

       //String content = " <h2 class=\"mb-3\">It is a long established fact a reader be distracted</h2>"+
       // "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis, eius mollitia suscipit, quisquam doloremque distinctio perferendis et doloribus unde architecto optio laboriosam porro adipisci sapiente officiis nemo accusamus ad praesentium? Esse minima nisi et. Dolore perferendis, enim praesentium omnis, iste doloremque quia officia optio deserunt molestiae voluptates soluta architecto tempora.</p>";
       

        //Post postUno = new Post("Docker y SpringBoot", content,"Como correr un proyecto de Spring Boot en docker con mysql.","/images/docker.jpg","docker-y-springboot");
        // pService.save(postUno);
         //pService.save(postUno);
         //pService.save(postUno);   
    
        //Project project = new Project("/images/bg_1png", "/admin","/admin", "spring boot");

        //projectService.save(project);
        //projectService.save(project);
        //projectService.save(project);

    }


}
