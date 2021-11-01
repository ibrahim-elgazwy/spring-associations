package com.spring.association.springAssociations.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.spring.association.springAssociations.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@EntityGraph(value = "book.reviews", type = EntityGraphType.FETCH)
	public Page<Book> findAll(Pageable pageable);
}
