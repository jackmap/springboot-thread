package com.example.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	/**
	 * @Description 用处：将路由键和某模式进行匹配。
	 * 此时队列需要绑定要一个模式上。
	 * 符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。
	 * 因此“audit.#”能够匹配到“audit.irs.corporate”，
	 * 但是“audit.*” 只会匹配到“audit.irs”。
	 * @author作者：mp
	 * @date 2019年5月31日
	 */
	public void send() {
		String context = "hi, i am message ";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
	}

	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}

	/**
	 * @Description 用处：topic.messages
	 * @author作者：mp
	 * @date 2019年5月31日
	 */
	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

}