package com.Interview.demo.Service;

import com.Interview.demo.Entity.JobPosting;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobPostingService {

    JobPosting createJobPosting(JobPosting jobPosting);

    JobPosting getJobPostingById(Long id);

    JobPosting updateJobPosting(Long id, JobPosting jobPosting);

    void deleteJobPosting(Long id);

    List<JobPosting> searchJobPostings(String keyword, String location);
}