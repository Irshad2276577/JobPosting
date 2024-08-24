package com.Interview.demo;

import com.Interview.demo.Entity.JobPosting;
import com.Interview.demo.Repository.PostingJobRepository;
import com.Interview.demo.Service.JobPostingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobPostingServiceTests {

    @Autowired
    private JobPostingService jobPostingService;

    @MockBean
    private PostingJobRepository jobPostingRepository;

    @Test
    public void testCreateJobPosting() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setTitle("Java Developer");

        Mockito.when(jobPostingRepository.save(Mockito.any(JobPosting.class))).thenReturn(jobPosting);

        JobPosting created = jobPostingService.createJobPosting(jobPosting);

        Assertions.assertEquals("Java Developer", created.getTitle());
    }

}


