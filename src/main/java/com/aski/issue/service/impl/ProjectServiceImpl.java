package com.aski.issue.service.impl;
import com.aski.issue.dto.ProjectDto;
import com.aski.issue.entity.Project;
import com.aski.issue.repository.ProjectRepository;
import com.aski.issue.service.ProjectService;
import com.aski.issue.util.TPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by temelt on 4.02.2019.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;

    }


    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;

    }

    public Boolean delete(Long id) {
        Project p = projectRepository.getOne(id);
        p.setDurum("0");
        projectRepository.save(p);

        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb= projectRepository.getOne(id);
        if(projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }
}
