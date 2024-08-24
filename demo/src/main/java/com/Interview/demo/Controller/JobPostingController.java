package com.Interview.demo.Controller;

import com.Interview.demo.Entity.JobPosting;
import com.Interview.demo.Service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting created = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
        return ResponseEntity.ok(jobPosting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPosting) {
        JobPosting updated = jobPostingService.updateJobPosting(id, jobPosting);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPosting>> searchJobPostings(@RequestParam String keyword, @RequestParam String location) {
        List<JobPosting> results = jobPostingService.searchJobPostings(keyword, location);
        return ResponseEntity.ok(results);
    }
}
