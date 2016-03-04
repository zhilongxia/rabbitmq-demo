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
		rabbitTemplate.convertAndSend("��" + i + "�� Hello, world");
		System.out.println("���͵�" + i + "����Ϣ�ɹ�������Ϊ��" + message);
	}

}
