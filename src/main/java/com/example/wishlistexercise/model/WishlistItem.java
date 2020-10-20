package com.example.wishlistexercise.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class WishlistItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String comments;

	@Enumerated(EnumType.STRING)
	private Priority priority;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public WishlistItem(Integer id, String name, String comments, Priority priority, User user) {
		this.id = id;
		this.name = name;
		this.comments = comments;
		this.priority = priority;
		this.user = user;
	}
}
