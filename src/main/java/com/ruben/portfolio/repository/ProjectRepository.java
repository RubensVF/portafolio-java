package com.ruben.portfolio.repository;

import com.ruben.portfolio.model.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long>{
    
}
