package com.spring.association.springAssociations.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.association.springAssociations.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@EntityGraph(value = "author-books", type = EntityGraphType.FETCH)
	Optional<Author> findById(int id);
}
