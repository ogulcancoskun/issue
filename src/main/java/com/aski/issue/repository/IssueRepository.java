package com.aski.issue.repository;

import com.aski.issue.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by temelt on 3.02.2019.
 */
public interface IssueRepository extends JpaRepository<Issue, Long> {

}
