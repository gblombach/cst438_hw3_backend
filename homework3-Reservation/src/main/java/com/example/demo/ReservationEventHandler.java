/**
 * File: 		ReservationEventHandler.java
 * Description: event receiver class
 * Bugs: 		none known
 * Purpose:		CST438 Homework 3
 * @author		George Blombach
 * @version     1.0
 * @see also
 */

package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "city-reservation-q1")
public class ReservationEventHandler {

	private static final Logger log = LoggerFactory.getLogger(ReservationEventHandler.class);

	@RabbitHandler
	public void receive(String in) {
		System.out.println(in);
		log.info(" [ReservationEventHandler] Received '" + in + "'");
	}
}
