package com.carsacquire.carsacquire.company;

import java.util.List;

import com.carsacquire.carsacquire.Job.Job;
// import com.carsacquire.carsacquire.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore // for avoiding the  recursion loop infinity problem
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;       



    public Company(){

    }
    public Company(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    
    //This means we're haivng a field "company" in the jobs table which is mapping to company 
    // That prevents from making extra table just for maintining the relationship
    // OneToMany that means 1 company can have list of jobs... 

    // Now another table is CREATED to maintain the relation ship between compnay and the job entities 
    // Now mappedBy = "company" indicates, that there's separate column in company table for mainting the relationship
    // Every company have list of jobs and every company have list of reviews 
    @JsonIgnore
    // @OneToMany(mappedBy = "company")
    // private List<Review> reviews;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        id = this.id;
    }
    // public List<Review> getReviews() {
    //     return reviews;
    // }
    // /**
    //  * @param reviews the reviews to set
    //  */
    // public void setReviews(List<Review> reviews) {
    //     this.reviews = reviews;
    // }

}
