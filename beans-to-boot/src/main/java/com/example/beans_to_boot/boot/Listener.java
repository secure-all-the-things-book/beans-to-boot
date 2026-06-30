package com.example.beans_to_boot.boot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

class Listener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		IO.println("got [" + event.getClass().getName() + "]");
		if (event instanceof ContextRefreshedEvent contextRefreshedEvent) {
			IO.println("got contextRefreshedEvent [" + contextRefreshedEvent + "]");
		}
	}

	@EventListener
	void onClose(ContextClosedEvent contextClosedEvent) {
		IO.println("context closed event [" + contextClosedEvent.getTimestamp() + "]");
	}

}
