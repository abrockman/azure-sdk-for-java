/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The network configuration for a pool.
 */
public class NetworkConfiguration {
    /**
     * The ARM resource identifier of the virtual network subnet which the
     * compute nodes of the pool will join.
     * This is of the form
     * /subscriptions/{subscription}/resourceGroups/{group}/providers/{provider}/virtualNetworks/{network}/subnets/{subnet}.
     * The virtual network must be in the same region and subscription as the
     * Azure Batch account. The specified subnet should have enough free IP
     * addresses to accommodate the number of nodes in the pool. If the subnet
     * doesn't have enough free IP addresses, the pool will partially allocate
     * compute nodes, and a resize error will occur. For pools created with
     * virtualMachineConfiguration only ARM virtual networks
     * ('Microsoft.Network/virtualNetworks') are supported, but for pools
     * created with cloudServiceConfiguration both ARM and classic virtual
     * networks are supported. For more details, see:
     * https://docs.microsoft.com/en-us/azure/batch/batch-api-basics#virtual-network-vnet-and-firewall-configuration.
     */
    @JsonProperty(value = "subnetId")
    private String subnetId;

    /**
     * The scope of dynamic vnet assignment.
     * Possible values include: 'none', 'job'.
     */
    @JsonProperty(value = "dynamicVNetAssignmentScope")
    private DynamicVNetAssignmentScope dynamicVNetAssignmentScope;

    /**
     * The configuration for endpoints on compute nodes in the Batch pool.
     * Pool endpoint configuration is only supported on pools with the
     * virtualMachineConfiguration property.
     */
    @JsonProperty(value = "endpointConfiguration")
    private PoolEndpointConfiguration endpointConfiguration;

    /**
     * Get this is of the form /subscriptions/{subscription}/resourceGroups/{group}/providers/{provider}/virtualNetworks/{network}/subnets/{subnet}. The virtual network must be in the same region and subscription as the Azure Batch account. The specified subnet should have enough free IP addresses to accommodate the number of nodes in the pool. If the subnet doesn't have enough free IP addresses, the pool will partially allocate compute nodes, and a resize error will occur. For pools created with virtualMachineConfiguration only ARM virtual networks ('Microsoft.Network/virtualNetworks') are supported, but for pools created with cloudServiceConfiguration both ARM and classic virtual networks are supported. For more details, see: https://docs.microsoft.com/en-us/azure/batch/batch-api-basics#virtual-network-vnet-and-firewall-configuration.
     *
     * @return the subnetId value
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set this is of the form /subscriptions/{subscription}/resourceGroups/{group}/providers/{provider}/virtualNetworks/{network}/subnets/{subnet}. The virtual network must be in the same region and subscription as the Azure Batch account. The specified subnet should have enough free IP addresses to accommodate the number of nodes in the pool. If the subnet doesn't have enough free IP addresses, the pool will partially allocate compute nodes, and a resize error will occur. For pools created with virtualMachineConfiguration only ARM virtual networks ('Microsoft.Network/virtualNetworks') are supported, but for pools created with cloudServiceConfiguration both ARM and classic virtual networks are supported. For more details, see: https://docs.microsoft.com/en-us/azure/batch/batch-api-basics#virtual-network-vnet-and-firewall-configuration.
     *
     * @param subnetId the subnetId value to set
     * @return the NetworkConfiguration object itself.
     */
    public NetworkConfiguration withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get possible values include: 'none', 'job'.
     *
     * @return the dynamicVNetAssignmentScope value
     */
    public DynamicVNetAssignmentScope dynamicVNetAssignmentScope() {
        return this.dynamicVNetAssignmentScope;
    }

    /**
     * Set possible values include: 'none', 'job'.
     *
     * @param dynamicVNetAssignmentScope the dynamicVNetAssignmentScope value to set
     * @return the NetworkConfiguration object itself.
     */
    public NetworkConfiguration withDynamicVNetAssignmentScope(DynamicVNetAssignmentScope dynamicVNetAssignmentScope) {
        this.dynamicVNetAssignmentScope = dynamicVNetAssignmentScope;
        return this;
    }

    /**
     * Get pool endpoint configuration is only supported on pools with the virtualMachineConfiguration property.
     *
     * @return the endpointConfiguration value
     */
    public PoolEndpointConfiguration endpointConfiguration() {
        return this.endpointConfiguration;
    }

    /**
     * Set pool endpoint configuration is only supported on pools with the virtualMachineConfiguration property.
     *
     * @param endpointConfiguration the endpointConfiguration value to set
     * @return the NetworkConfiguration object itself.
     */
    public NetworkConfiguration withEndpointConfiguration(PoolEndpointConfiguration endpointConfiguration) {
        this.endpointConfiguration = endpointConfiguration;
        return this;
    }

}
