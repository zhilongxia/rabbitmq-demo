package rabbitmq.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.produce.direct.MessageProducer;

public class MessageTest {

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {
		MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
		int a = 10;
		while (a > 0) {
			messageProducer.sendMessage("Hello, I am amq sender num :" + a--);
			try {
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
