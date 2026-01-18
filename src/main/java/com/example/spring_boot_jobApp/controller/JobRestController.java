package com.example.spring_boot_jobApp.controller;

import com.example.spring_boot_jobApp.model.JobPost;
import com.example.spring_boot_jobApp.service.CacheInspectionService;
import com.example.spring_boot_jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService service;

    @Autowired
    private CacheInspectionService cacheInspectionService;

    @GetMapping("/jobPosts")
    @PreAuthorize("hasAuthority('DEMO_READ')")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    @PreAuthorize("hasAuthority('DEMO_READ')")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    @PreAuthorize("hasAuthority('DEMO_READ')")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return service.searchByKeyword(keyword);
    }

    @PostMapping("/jobPost")
    @PreAuthorize("hasAuthority('DEMO_WRITE')")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("/jobPost")
    @PreAuthorize("hasAuthority('DEMO_WRITE')")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return service.updateJob(jobPost);
//        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    @PreAuthorize("hasAuthority('DEMO_DELETE')")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return  "Deleted";
    }

    @GetMapping("/cacheData")
    public void getCacheData() {
        cacheInspectionService.printCacheContents("post");
    }

    // this method is for load the initial data
    @GetMapping("/load")
    public String loadData() {
        service.load();
        return "Success";
    }
}
