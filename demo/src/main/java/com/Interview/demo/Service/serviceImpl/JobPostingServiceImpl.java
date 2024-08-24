package com.Interview.demo.Service.serviceImpl;

import com.Interview.demo.Entity.JobPosting;
import com.Interview.demo.Repository.PostingJobRepository;
import com.Interview.demo.Service.JobPostingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private PostingJobRepository jobPostingRepository;

    @Override
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

        @Override
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job posting not found with id " + id));
    }

    @Override
    public JobPosting updateJobPosting(Long id, JobPosting jobPosting) {
        JobPosting existingJobPosting = getJobPostingById(id);

        existingJobPosting.setTitle(jobPosting.getTitle());
        existingJobPosting.setDescription(jobPosting.getDescription());
        existingJobPosting.setLocation(jobPosting.getLocation());
        existingJobPosting.setCompany(jobPosting.getCompany());
        existingJobPosting.setSalary(jobPosting.getSalary());
        existingJobPosting.setRange(jobPosting.getRange());
        existingJobPosting.setRequiredSkills(jobPosting.getRequiredSkills());
        existingJobPosting.setApplicationDeadline(jobPosting.getApplicationDeadline());

        return jobPostingRepository.save(existingJobPosting);
    }

    @Override
    public void deleteJobPosting(Long id) {
        JobPosting existingJobPosting = getJobPostingById(id);
        jobPostingRepository.delete(existingJobPosting);
    }

    @Override
    public List<JobPosting> searchJobPostings(String keyword, String location) {
        return jobPostingRepository.findByTitleContainingOrLocationContaining(keyword, location);
    }
    }
