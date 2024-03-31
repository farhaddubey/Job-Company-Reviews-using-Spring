package com.carsacquire.carsacquire.Job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    // object of job controller will be initialized during the runtime SPring boot takes care about that

    // @GetMapping("/jobs")
    // public List<Job> findAll(){
    //     return jobService.findAll();
    // }

    // @PostMapping("/jobs")
    // public String createJob(Job job){
    //     jobService.createJob(job);
    //     return "Job added successfully";
    // }

    // @GetMapping("/jobs")            After applying @RequestMapping at the base 
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        // return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
        return ResponseEntity.ok(jobService.findAll());
    }

    // @PostMapping("/jobs")            After applying @RequstMapping at the base("jobs")
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }


    // Defining the dyanmic part id basically the query part 

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
            // We are creating a reponse object here with  job object and with the status code 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted=jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    // @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT/GET/POST/UPDATE) ---------->Alternate method
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobById(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}


// GET /jobs: Get all jobs
// GET /jobs/{id}: Get a specific job by id 
// POST /jobs: Create a new job (request body should contain the job details) 
// DELETE /jobs/{id}:Delete a specific job by id 
// PUT /job/{id}: Update a specific job by ID

// Examples:
// GET {base_url}/jobs
// GET {base_url}/jobs/1
// POST {base_url}/jobs
// DELETE {base_url}/jobs/id
// PUT {base_url}/job/id


