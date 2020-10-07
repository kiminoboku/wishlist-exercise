package com.example.wishlistexercise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WishlistItem {

	@Id
	private Integer id;

	private String name;

	private String comments;

	private Priority priority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public WishlistItem() {
	}

	public WishlistItem(Integer id, String name, String comments, Priority priority) {
		this.id = id;
		this.name = name;
		this.comments = comments;
		this.priority = priority;
	}
}
