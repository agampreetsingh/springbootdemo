package com.springboot.demo.topicsapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.topicsapp.entity.Topic;
import com.springboot.demo.topicsapp.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	@Override
	public Topic getTopicByid(long id) throws Exception {
		Optional<Topic> topicOptionalObject = topicRepository.findById(id); 
		if(topicRepository.findById(id).isPresent()) {
			return topicOptionalObject.get();
		}
		else {
			throw new Exception("Topic Not Found for Id: " + id);
		}
	}

}
