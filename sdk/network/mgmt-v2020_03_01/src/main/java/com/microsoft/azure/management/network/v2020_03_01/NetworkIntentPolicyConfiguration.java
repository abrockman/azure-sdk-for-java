/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_03_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details of NetworkIntentPolicyConfiguration for
 * PrepareNetworkPoliciesRequest.
 */
public class NetworkIntentPolicyConfiguration {
    /**
     * The name of the Network Intent Policy for storing in target
     * subscription.
     */
    @JsonProperty(value = "networkIntentPolicyName")
    private String networkIntentPolicyName;

    /**
     * Source network intent policy.
     */
    @JsonProperty(value = "sourceNetworkIntentPolicy")
    private NetworkIntentPolicy sourceNetworkIntentPolicy;

    /**
     * Get the name of the Network Intent Policy for storing in target subscription.
     *
     * @return the networkIntentPolicyName value
     */
    public String networkIntentPolicyName() {
        return this.networkIntentPolicyName;
    }

    /**
     * Set the name of the Network Intent Policy for storing in target subscription.
     *
     * @param networkIntentPolicyName the networkIntentPolicyName value to set
     * @return the NetworkIntentPolicyConfiguration object itself.
     */
    public NetworkIntentPolicyConfiguration withNetworkIntentPolicyName(String networkIntentPolicyName) {
        this.networkIntentPolicyName = networkIntentPolicyName;
        return this;
    }

    /**
     * Get source network intent policy.
     *
     * @return the sourceNetworkIntentPolicy value
     */
    public NetworkIntentPolicy sourceNetworkIntentPolicy() {
        return this.sourceNetworkIntentPolicy;
    }

    /**
     * Set source network intent policy.
     *
     * @param sourceNetworkIntentPolicy the sourceNetworkIntentPolicy value to set
     * @return the NetworkIntentPolicyConfiguration object itself.
     */
    public NetworkIntentPolicyConfiguration withSourceNetworkIntentPolicy(NetworkIntentPolicy sourceNetworkIntentPolicy) {
        this.sourceNetworkIntentPolicy = sourceNetworkIntentPolicy;
        return this;
    }

}
