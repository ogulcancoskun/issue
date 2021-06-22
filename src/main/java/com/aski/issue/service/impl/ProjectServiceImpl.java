package com.aski.issue.service.impl;
import com.aski.issue.dto.ProjectDto;
import com.aski.issue.service.ProjectService;
import com.aski.issue.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by temelt on 4.02.2019.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public ProjectDto save(ProjectDto project) {
        return null;
    }

    @Override
    public ProjectDto getById(Long id) {
        return null;
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
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        return null;
    }
}
