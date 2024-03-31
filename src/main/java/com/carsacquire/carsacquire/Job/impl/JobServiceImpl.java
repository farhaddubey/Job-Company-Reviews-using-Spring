package com.carsacquire.carsacquire.Job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carsacquire.carsacquire.Job.Job;
import com.carsacquire.carsacquire.Job.JobRepository;
import com.carsacquire.carsacquire.Job.JobService;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;
    

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        // return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        // jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        // for(Job job: jobs){
        //     if(job.getId().equals(id)){
        //         return job;
        //     }
        // }
        // return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        // Iterator<Job> iterator = jobs.iterator();
        // while (iterator.hasNext()) {
        //     Job job = iterator.next();
        //     if(job.getId().equals(id)){
        //         iterator.remove();
        //         return true;
        //     }
        // }
        // return false;
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
    // for (Job job:jobs){
    //     if(job.getId().equals(id)){
    //         job.setTitle(updatedJob.getTitle());
    //         job.setDescription(updatedJob.getDescription());
    //         job.setMinSalary(updatedJob.getMinSalary());
    //         job.setMaxSalary(updatedJob.getMaxSalary());
    //         return true;
    //     }
    // }
    Optional<Job> jobOptional =jobRepository.findById(id);
    if(jobOptional.isPresent()){
        Job job = jobOptional.get();
        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setMinSalary(updatedJob.getMinSalary());
        job.setMaxSalary(updatedJob.getMaxSalary());
        job.setLocation(updatedJob.getLocation());
        jobRepository.save(job);
        return true;
    }
    return false;
    }
    

     
}