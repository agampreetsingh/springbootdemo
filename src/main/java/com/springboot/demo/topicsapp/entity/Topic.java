package com.springboot.demo.topicsapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TOPIC")
public class Topic implements Serializable {

	private static final long serialVersionUID = -3398822340306424287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany
	private List<SubTopic> subTopics;
	
	@ManyToMany
	private List<Topic> linkedTopics;

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

	public List<SubTopic> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(List<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}

	public List<Topic> getLinkedTopics() {
		return linkedTopics;
	}

	public void setLinkedTopics(List<Topic> linkedTopics) {
		this.linkedTopics = linkedTopics;
	}
	
}
