package com.ruben.portfolio.service;

import java.util.List;

import com.ruben.portfolio.model.Project;
import com.ruben.portfolio.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository pRepository;

    public List<Project> findAll(){
        return (List<Project>) pRepository.findAll();
    }

    public Project findById(Long id){
        return pRepository.findById(id).orElse(null);
    }

    public void save(Project project){
        pRepository.save(project);
    }

    public void deleteById(Long id){
        pRepository.deleteById(id);
    }
}
