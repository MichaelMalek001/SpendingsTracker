package com.mickey.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mickey.demo.model.Category;
import com.mickey.demo.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public Collection<Category> categories(){
		return categoryRepository.findAll();
	}
	
	@GetMapping("/category/{id}")
	public Optional<Category> getCategory(@PathVariable long id) {
		return categoryRepository.findById(id);
	}
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException{
		Category result = categoryRepository.save(category);
		return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> putCategory(@Validated @RequestBody Category category){
		Category result = categoryRepository.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id){
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}





