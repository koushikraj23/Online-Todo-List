package com.activity.todo.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class TodoTask {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;

	@NotEmpty
	private String description;

	@Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private Timestamp lastUpdated;

	private boolean checked;
	@Column(nullable = false)
	private String userName;

	public TodoTask(Long id, String title, String description, Timestamp createdAt, Timestamp lastupdated,
			boolean checked, String userName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.lastUpdated = lastupdated;
		this.checked = checked;
		this.userName = userName;
	}

	public TodoTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TodoTask(String title, String description, Timestamp createdAt, Timestamp lastupdated, boolean checked,
			String userName) {
		super();
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.lastUpdated = lastupdated;
		this.checked = checked;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastupdated) {
		this.lastUpdated = lastupdated;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
