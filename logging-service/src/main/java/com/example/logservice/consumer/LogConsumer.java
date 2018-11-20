package com.example.logservice.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@Log4j2
public class LogConsumer {

    @StreamListener(target = Sink.INPUT)
    public void logProcess(String process) {
        log.info(process);
    }

}
