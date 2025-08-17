package com.hems.SpringBootRest;

import com.hems.SpringBootRest.model.JobPost;
import com.hems.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping("jobPosts")
   // @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    //@ResponseBody
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
    }
    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }
    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchKeyword(@PathVariable String keyword){
        return service.searchKeyword(keyword);
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }
}
