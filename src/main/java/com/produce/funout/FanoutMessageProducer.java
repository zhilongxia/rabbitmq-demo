package com.produce.funout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanoutMessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(Integer i) {

		String message = " fanout " + "; " + i;
		rabbitTemplate.convertAndSend("第" + i + "个 Hello, world");
		System.out.println("发送第" + i + "个消息成功！内容为：" + message);
	}

}
