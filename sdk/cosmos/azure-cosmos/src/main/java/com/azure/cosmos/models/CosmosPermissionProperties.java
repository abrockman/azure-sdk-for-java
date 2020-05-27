// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.models;

import com.azure.cosmos.implementation.Permission;
import com.azure.cosmos.implementation.Resource;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Cosmos permission properties.
 */
public final class CosmosPermissionProperties {

    private Permission permission;
    static List<CosmosPermissionProperties> getFromV2Results(List<Permission> results) {
        return results.stream().map(permission -> new CosmosPermissionProperties(permission.toJson()))
                   .collect(Collectors.toList());
    }

    /**
     * Initialize a permission object.
     */
    public CosmosPermissionProperties() {
        this.permission = new Permission();
    }

    /**
     * Sets the id
     *
     * @param id the name of the resource.
     * @return the current {@link CosmosPermissionProperties} object
     */
    public CosmosPermissionProperties setId(String id) {
        permission.setId(id);
        return this;
    }

    /**
     * Initialize a permission object from json string.
     *
     * @param jsonString the json string that represents the getPermission.
     */
    CosmosPermissionProperties(String jsonString) {
        this.permission = new Permission(jsonString);
    }

    /**
     * Gets the self-link of resource to which the permission applies.
     *
     * @return the resource link.
     */
    public String getResourceLink() {
        return this.permission.getResourceLink();
    }

    /**
     * Sets the self-link of resource to which the permission applies.
     *
     * @param resourceLink the resource link.
     * @return the current {@link CosmosPermissionProperties} object
     */
    public CosmosPermissionProperties setResourceLink(String resourceLink) {
        this.permission.setResourceLink(resourceLink);
        return this;
    }

    /**
     * Gets the permission mode.
     *
     * @return the permission mode.
     */
    public PermissionMode getPermissionMode() {
        return this.permission.getPermissionMode();
    }

    /**
     * Sets the permission mode.
     *
     * @param permissionMode the permission mode.
     * @return the current {@link CosmosPermissionProperties} object
     */
    public CosmosPermissionProperties setPermissionMode(PermissionMode permissionMode) {
        this.permission.setPermissionMode(permissionMode);
        return this;
    }

    /**
     * Gets the resource partition key associated with this permission object.
     *
     * @return the partition key.
     */
    public PartitionKey getResourcePartitionKey() {
        return this.permission.getResourcePartitionKey();
    }

    /**
     * Sets the resource partition key associated with this permission object.
     *
     * @param partitionKey the partition key.
     * @return the current {@link CosmosPermissionProperties} object
     */
    public CosmosPermissionProperties setResourcePartitionKey(PartitionKey partitionKey) {
        this.permission.setResourcePartitionKey(partitionKey);
        return this;
    }

    Resource getResource() {
        return this.permission;
    }

    /**
     * Gets the name of the resource.
     *
     * @return the name of the resource.
     */
    public String getId() {
        return this.permission.getId();
    }

    /**
     * Gets the ID associated with the resource.
     *
     * @return the ID associated with the resource.
     */
    public String getResourceId() {
        return this.permission.getResourceId();
    }

    /**
     * Get the last modified timestamp associated with the resource.
     *
     * @return the timestamp.
     */
    public OffsetDateTime getTimestamp() {
        return this.permission.getTimestamp();
    }

    /**
     * Get the entity tag associated with the resource.
     *
     * @return the e tag.
     */
    public String getETag() {
        return this.permission.getETag();
    }

    Permission getV2Permissions() {
        return new Permission(this.permission.toJson());
    }
}