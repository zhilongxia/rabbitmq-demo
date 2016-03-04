package rabbitmq.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.produce.topic.TopicMessageProducer;

public class TopicMessageTest {

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {

		TopicMessageProducer messageProducer = (TopicMessageProducer) context.getBean("topicMessageProducer");
		int a = 3;
		while (a > 0) {
			messageProducer.sendMessage(a);
			a--;
			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}