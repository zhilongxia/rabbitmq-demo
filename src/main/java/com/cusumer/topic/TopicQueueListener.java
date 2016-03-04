package com.cusumer.topic;

public class TopicQueueListener {

	public void listentopicOne(Object foo) {
		System.out.println("listentopic============ one======================");
		System.out.println("接收到的消息： " + foo);
	}

	public void listentopicTwo(Object foo) {
		System.out.println("listentopic==============two====================");
		System.out.println("接收到的消息： " + foo);
	}
}