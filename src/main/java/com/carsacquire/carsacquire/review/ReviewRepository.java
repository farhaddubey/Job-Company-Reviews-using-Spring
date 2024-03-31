package com.carsacquire.carsacquire.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
} 
// Repository class is another java file of Repository interface which extends JpaRepository <arguments given here by comma separated>
