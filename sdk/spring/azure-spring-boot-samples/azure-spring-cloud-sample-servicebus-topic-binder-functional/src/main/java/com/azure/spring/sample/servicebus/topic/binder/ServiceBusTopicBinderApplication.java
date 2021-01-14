// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.sample.servicebus.topic.binder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;

/**
 * @author Andrew Brockman
 */
@SpringBootApplication
public class ServiceBusTopicBinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBusTopicBinderApplication.class, args);
    }

    @Bean
    public EmitterProcessor<Message<String>> exampleEmitter(){
        return EmitterProcessor.create();
    }
}
