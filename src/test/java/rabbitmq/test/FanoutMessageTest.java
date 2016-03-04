package rabbitmq.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.produce.funout.FanoutMessageProducer;

public class FanoutMessageTest {

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {

		FanoutMessageProducer messageProducer = (FanoutMessageProducer) context.getBean("fanoutMessageProducer");
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
