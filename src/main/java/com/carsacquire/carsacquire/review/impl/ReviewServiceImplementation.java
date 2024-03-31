package com.carsacquire.carsacquire.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carsacquire.carsacquire.company.Company;
import com.carsacquire.carsacquire.company.CompanyService;
import com.carsacquire.carsacquire.review.Review;
import com.carsacquire.carsacquire.review.ReviewRepository;
import com.carsacquire.carsacquire.review.ReviewService;

@Service
public class ReviewServiceImplementation implements ReviewService {
    // Service Implemention class is the actual serice management class so to inform the system we annotate @Service 
    private  ReviewRepository reviewRepository;
    private  CompanyService companyService;
    // private  Review updatedReview;



    // public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService
    // , Review updatedReview){
    //     this.reviewRepository= reviewRepository;
    //     this.companyService = companyService;
    //     this.updatedReview = updatedReview;

    // }

    public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
        // this.updatedReview = updatedReview;
    }

    @Override
    public List<Review> getAllReviews(Long companyId){
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        // findById() is a predefined method that can be easily used 
        // But findByCompanyId is self defined method hence to use that we need to declare that in JpaRepository file 
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review -> review.getId()
                .equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    // @Override
    // public boolean updateReview(Long companyId, Long reviewId, Review review) {
    //     if(companyService.getCompanyById(companyId)!=null){
    //         updatedReview.setCompany(companyService.getCompanyById(companyId));
    //         updatedReview.setId(reviewId);
    //         reviewRepository.save(updatedReview);
    //         return true;
    //     }
    //     return false;
    // }

    // @Override
    // public boolean deleteReview(Long companyId, Long reviewId) {
    //     if(companyService.getCompanyById(reviewId) !=null && reviewRepository.existsById(reviewId)){
    //         Review review = reviewRepository.findById(reviewId).orElse(null);
    //         Company company = review.getCompany();
    //         company.getReviews().remove(review);
    //         review.setCompany(null);
    //         companyService.updateCompany(company, companyId);
    //         reviewRepository.deleteById(reviewId);
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
    
    
}
