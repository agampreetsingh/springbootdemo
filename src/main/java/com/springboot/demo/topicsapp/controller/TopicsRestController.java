package com.springboot.demo.topicsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.topicsapp.entity.Topic;
import com.springboot.demo.topicsapp.service.TopicService;

@RestController
@RequestMapping("/api")
public class TopicsRestController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topic/{topicId}")
	public Topic getTopicById(@PathVariable Long topicId) throws Exception {
		return topicService.getTopicByid(topicId);
	}
}
