package com.produce.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(Integer i) {

		String message = " topic " + "; " + i;
		rabbitTemplate.convertAndSend("第" + i + "个 Hello, world");
		System.out.println("发送第" + i + "个消息成功！内容为：" + message);
	}

}
