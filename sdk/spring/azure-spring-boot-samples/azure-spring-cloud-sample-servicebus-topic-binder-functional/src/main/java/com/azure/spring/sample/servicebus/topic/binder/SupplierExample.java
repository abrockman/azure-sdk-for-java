// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.sample.servicebus.topic.binder;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;


/**
 * @author Andrew Brockman
 */
@RestController
public class SupplierExample implements Supplier<Flux<Message<String>>> {

    private final EmitterProcessor<Message<String>> emitterProcessor;

    public SupplierExample(EmitterProcessor<Message<String>> emitterProcessor) {
        this.emitterProcessor = emitterProcessor;
    }

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        this.emitterProcessor.onNext(new GenericMessage<>(message));
        return message;
    }


    @Override
    public Flux<Message<String>> get() {
        return emitterProcessor;
    }
}
