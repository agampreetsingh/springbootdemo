package com.springboot.demo.topicsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.topicsapp.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
