// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.sample.servicebus.topic.binder;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Andrew Brockman
 */
@Component
public class ConsumerExample implements Consumer<String> {

    public void accept(String message) {
        System.out.println(String.format("New message received: '%s'", message));
    }
}
