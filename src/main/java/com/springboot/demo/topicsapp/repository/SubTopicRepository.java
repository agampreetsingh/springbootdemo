package com.springboot.demo.topicsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.topicsapp.entity.SubTopic;

public interface SubTopicRepository extends JpaRepository<SubTopic, Long>{

}
