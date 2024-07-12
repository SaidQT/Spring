
package com.codingdojo.javaproj.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 200, message = "Pet name must be at least 2 characters")
	private String name;
	@NotNull
	@Size(min = 2, max = 200, message = "Pet type must be at least 2 characters")
	private String type;
	@NotNull
	@Size(min = 2, max = 200, message = "City name must be at least 2 characters")
	private String city;
	@NotNull(message = "Image URL is required")
	@Size(min = 2, message = "Image URL must be at least 2 characters")
	@Column(columnDefinition = "TEXT")
	private String imageUrl;
	@NotNull
	@Size(min = 5, message = "Description must be at least 5 characters")
	@Column(columnDefinition = "TEXT")
	private String description;
	@Size(min = 3)
	private String status;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "shop_id")
//	private Shop shop;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
 public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

@Column(updatable = false) @DateTimeFormat(pattern = "yyyy-MM-dd") private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")

	private User user;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pet() {

	}

}