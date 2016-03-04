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
		rabbitTemplate.convertAndSend("��" + i + "�� Hello, world");
		System.out.println("���͵�" + i + "����Ϣ�ɹ�������Ϊ��" + message);
	}

}
