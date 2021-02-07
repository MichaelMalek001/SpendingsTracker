package com.mickey.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mickey.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findByName(String name);
}
