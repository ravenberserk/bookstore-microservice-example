package com.example.logservice.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class LogConsumer {

    @StreamListener(target = Sink.INPUT)
    public void logProcess(String process) {
	System.out.println(process);
    }

}
