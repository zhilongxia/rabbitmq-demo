package com.produce;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class RPCServer {

	public static final String RPC_QUEUE_NAME = "rpc_queue";

	public static String sayHello(String name) {
		return "hello " + name;
	}

	public static void main(String[] args)
			throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException, TimeoutException {

		ConnectionFactory connFac = new ConnectionFactory();
		connFac.setHost("localhost");
		Connection conn = connFac.newConnection();
		Channel channel = conn.createChannel();
		channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

		while (true) {
			System.out.println("����˵ȴ�������Ϣ..");
			Delivery deliver = consumer.nextDelivery();
			System.out.println("����˳ɹ��յ���Ϣ..");
			BasicProperties props = deliver.getProperties();

			String message = new String(deliver.getBody(), "UTF-8");

			String responseMessage = sayHello(message);

			BasicProperties responseProps = new BasicProperties.Builder().correlationId(props.getCorrelationId())
					.build();

			// ��������ص��ͻ���Queue
			channel.basicPublish("", props.getReplyTo(), responseProps, responseMessage.getBytes("UTF-8"));

			// ��ͻ���ȷ����Ϣ
			channel.basicAck(deliver.getEnvelope().getDeliveryTag(), false);
			System.out.println("����˷�����Ϣ���..");
		}

	}

}
