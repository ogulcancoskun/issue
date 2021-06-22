package com.aski.issue.service.impl;

import com.aski.issue.dto.IssueDto;
import com.aski.issue.service.IssueService;

import com.aski.issue.util.TPage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class IssueHistoryServiceImpI implements IssueService {


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
        return null;
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
