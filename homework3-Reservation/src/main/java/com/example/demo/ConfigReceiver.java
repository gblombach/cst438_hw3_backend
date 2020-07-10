/**
 * File: 		ConfigReceiver.java
 * Description: class that configures a message query and binds it to the “city-reservation” exchange
 * Bugs: 		none known
 * Purpose:		CST438 Homework 3
 * @author		George Blombach
 * @version     1.0
 * @see also
 */

package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReceiver {
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("city-reservation");
	}
	@Bean
	public Queue queue1() {
		return new Queue("city-reservation-q1");
	}
	@Bean
	public Binding binding1(FanoutExchange fanout, Queue queue1) {
		return BindingBuilder.bind(queue1).to(fanout);
	}
	@Bean
	public ReservationEventHandler receiver() {
		return new ReservationEventHandler();
	}
}
