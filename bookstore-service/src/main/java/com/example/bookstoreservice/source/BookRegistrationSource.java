package com.example.bookstoreservice.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookRegistrationSource {

    @Output("bookRegistrationChannel")
    public MessageChannel registerNewBook();

}
