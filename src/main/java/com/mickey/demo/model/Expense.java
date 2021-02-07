package com.mickey.demo.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
	@Id
	private long id;
	private Instant expenseDate;
	private String description;
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Instant getExpenseDate() {
		return expenseDate;
	}
	
	public void setExpenseDate(Instant expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseDate=" + expenseDate + ", description=" + description + ", category="
				+ category + ", user=" + user + "]";
	}
}
