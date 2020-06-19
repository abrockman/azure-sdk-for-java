// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.inner;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.network.models.ExpressRouteCircuitRoutesTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The ExpressRouteCircuitsRoutesTableListResult model. */
@Fluent
public final class ExpressRouteCircuitsRoutesTableListResultInner {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(ExpressRouteCircuitsRoutesTableListResultInner.class);

    /*
     * The list of routes table.
     */
    @JsonProperty(value = "value")
    private List<ExpressRouteCircuitRoutesTable> value;

    /*
     * The URL to get the next set of results.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: The list of routes table.
     *
     * @return the value value.
     */
    public List<ExpressRouteCircuitRoutesTable> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of routes table.
     *
     * @param value the value value to set.
     * @return the ExpressRouteCircuitsRoutesTableListResultInner object itself.
     */
    public ExpressRouteCircuitsRoutesTableListResultInner withValue(List<ExpressRouteCircuitRoutesTable> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to get the next set of results.
     *
     * @param nextLink the nextLink value to set.
     * @return the ExpressRouteCircuitsRoutesTableListResultInner object itself.
     */
    public ExpressRouteCircuitsRoutesTableListResultInner withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}