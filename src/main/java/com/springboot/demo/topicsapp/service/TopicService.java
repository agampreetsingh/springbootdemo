package com.springboot.demo.topicsapp.service;

import com.springboot.demo.topicsapp.entity.Topic;

public interface TopicService {

	Topic getTopicByid(long id) throws Exception;
}
