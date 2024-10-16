package com.todo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Todo_List_Info")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", length = 100, nullable = false)
	@NotBlank(message = "Title can't be empty")
	private String title;

	@Column(name = "description", length = 250)
	private String description;

	@Column(name = "Is_Completed", nullable = false)
	private boolean isCompleted;

	@Column(name = "Created_At", nullable = false)
	private LocalDateTime createdAt;

	// Constructor
	public Todo() {
		super();
	}

	public Todo(String title, String description, boolean isCompleted) {
		super();
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
	}

	// To Print Current DateTime
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now(); // Set the current time
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getisCompleted() {
		return isCompleted;
	}

	public void setisCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
