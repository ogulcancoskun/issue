package com.aski.issue.repository;

import com.aski.issue.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by temelt on 3.02.2019.
 */
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {


}
