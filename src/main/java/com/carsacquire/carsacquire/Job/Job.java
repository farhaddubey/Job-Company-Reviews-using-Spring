package com.carsacquire.carsacquire.Job;

import com.carsacquire.carsacquire.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
// @Table(name = "job_table")
public class Job {
    // @Entity tells spring boot class that that's entity that should be mapped with the database
    // Every mapping requires a unique Id so we need to annota the @Id bofore the id for the mapping to be successfull 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Now JBM will manage the id 
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    // JBM requires a default no argument constructor 
    // With the default constructor of class JBM wont be able to creat any instance of the class and hence mapping would be not possible 
    // Hence required to probide the default constructor

    @ManyToOne
    private Company company;
    // ManyToOne that means many jobs are related to 1 company, In both side we've to makee this relationship 

    public Job(){}

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the minSalary
     */
    public String getMinSalary() {
        return minSalary;
    }

    /**
     * @param minSalary the minSalary to set 
     */
    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    /**
     * @return String return the maxSalary
     */
    public String getMaxSalary() {
        return maxSalary;
    }

    /**
     * @param maxSalary the maxSalary to set
     */
    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }


    /**
     * @return Company return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

}
