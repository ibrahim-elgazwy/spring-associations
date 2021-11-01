package com.spring.association.springAssociations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.association.springAssociations.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
