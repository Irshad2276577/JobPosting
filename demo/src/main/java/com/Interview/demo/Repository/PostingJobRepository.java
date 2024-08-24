package com.Interview.demo.Repository;

import com.Interview.demo.Entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingJobRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContainingOrLocationContaining(String title, String location);
}
