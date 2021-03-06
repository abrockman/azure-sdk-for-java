/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.eventgrid.v2020_04_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.SystemTopicEventSubscriptions;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.EventSubscriptionFullUrl;
import com.microsoft.azure.management.eventgrid.v2020_04_01_preview.SystemTopicEventSubscription;

class SystemTopicEventSubscriptionsImpl extends WrapperImpl<SystemTopicEventSubscriptionsInner> implements SystemTopicEventSubscriptions {
    private final EventGridManager manager;

    SystemTopicEventSubscriptionsImpl(EventGridManager manager) {
        super(manager.inner().systemTopicEventSubscriptions());
        this.manager = manager;
    }

    public EventGridManager manager() {
        return this.manager;
    }

    @Override
    public SystemTopicEventSubscriptionImpl define(String name) {
        return wrapModel(name);
    }

    private SystemTopicEventSubscriptionImpl wrapModel(EventSubscriptionInner inner) {
        return  new SystemTopicEventSubscriptionImpl(inner, manager());
    }

    private SystemTopicEventSubscriptionImpl wrapModel(String name) {
        return new SystemTopicEventSubscriptionImpl(name, this.manager());
    }

    @Override
    public Observable<EventSubscriptionFullUrl> getFullUrlAsync(String resourceGroupName, String systemTopicName, String eventSubscriptionName) {
        SystemTopicEventSubscriptionsInner client = this.inner();
        return client.getFullUrlAsync(resourceGroupName, systemTopicName, eventSubscriptionName)
        .map(new Func1<EventSubscriptionFullUrlInner, EventSubscriptionFullUrl>() {
            @Override
            public EventSubscriptionFullUrl call(EventSubscriptionFullUrlInner inner) {
                return new EventSubscriptionFullUrlImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<SystemTopicEventSubscription> listBySystemTopicAsync(final String resourceGroupName, final String systemTopicName) {
        SystemTopicEventSubscriptionsInner client = this.inner();
        return client.listBySystemTopicAsync(resourceGroupName, systemTopicName)
        .flatMapIterable(new Func1<Page<EventSubscriptionInner>, Iterable<EventSubscriptionInner>>() {
            @Override
            public Iterable<EventSubscriptionInner> call(Page<EventSubscriptionInner> page) {
                return page.items();
            }
        })
        .map(new Func1<EventSubscriptionInner, SystemTopicEventSubscription>() {
            @Override
            public SystemTopicEventSubscription call(EventSubscriptionInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<SystemTopicEventSubscription> getAsync(String resourceGroupName, String systemTopicName, String eventSubscriptionName) {
        SystemTopicEventSubscriptionsInner client = this.inner();
        return client.getAsync(resourceGroupName, systemTopicName, eventSubscriptionName)
        .flatMap(new Func1<EventSubscriptionInner, Observable<SystemTopicEventSubscription>>() {
            @Override
            public Observable<SystemTopicEventSubscription> call(EventSubscriptionInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((SystemTopicEventSubscription)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String systemTopicName, String eventSubscriptionName) {
        SystemTopicEventSubscriptionsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, systemTopicName, eventSubscriptionName).toCompletable();
    }

}
