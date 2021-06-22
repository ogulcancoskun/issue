package com.aski.issue.service.impl;


import com.aski.issue.dto.IssueDto;
import com.aski.issue.entity.Issue;
import com.aski.issue.repository.IssueRepository;
import com.aski.issue.repository.ProjectRepository;
import com.aski.issue.repository.UserRepository;
import com.aski.issue.service.IssueHistoryService;
import com.aski.issue.service.IssueService;
import com.aski.issue.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by temelt on 4.02.2019.
 */
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final IssueHistoryService issueHistoryService;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, UserRepository userRepository, ProjectRepository projectRepository, IssueHistoryService issueHistoryService, ModelMapper modelMapper) {

        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.issueHistoryService = issueHistoryService;
        this.modelMapper = modelMapper;
    }
    @Override
    public IssueDto save(IssueDto issue) {
        return null;
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> respnose = new TPage<IssueDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(Long issue) {
        return null;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
