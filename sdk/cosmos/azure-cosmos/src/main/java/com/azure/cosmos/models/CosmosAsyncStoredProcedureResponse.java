// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.models;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncStoredProcedure;
import com.azure.cosmos.implementation.ResourceResponse;
import com.azure.cosmos.implementation.StoredProcedure;
import com.azure.cosmos.implementation.StoredProcedureResponse;
import com.azure.cosmos.implementation.apachecommons.lang.StringUtils;

/**
 * The type Cosmos async stored procedure response.
 */
public class CosmosAsyncStoredProcedureResponse extends CosmosResponse<CosmosStoredProcedureProperties> {

    private final CosmosAsyncStoredProcedure storedProcedure;
    private final StoredProcedureResponse storedProcedureResponse;

    CosmosAsyncStoredProcedureResponse(ResourceResponse<StoredProcedure> response,
                                       CosmosAsyncContainer cosmosContainer) {
        super(response);
        String bodyAsString = response.getBodyAsString();
        if (StringUtils.isEmpty(bodyAsString)) {
            storedProcedure = null;

        } else {
            super.setProperties(new CosmosStoredProcedureProperties(bodyAsString));
            storedProcedure = BridgeInternal.createCosmosAsyncStoredProcedure(this.getProperties().getId(), cosmosContainer);
        }
        storedProcedureResponse = null;
    }

    CosmosAsyncStoredProcedureResponse(
        StoredProcedureResponse response, CosmosAsyncContainer cosmosContainer, String storedProcedureId) {
        super(response);
        this.storedProcedureResponse = response;
        this.storedProcedure = BridgeInternal.createCosmosAsyncStoredProcedure(storedProcedureId, cosmosContainer);

    }

    /**
     * Gets the stored procedure properties
     *
     * @return the stored procedure properties or null
     */
    public CosmosStoredProcedureProperties getProperties() {
        return super.getProperties();
    }

    /**
     * Gets the stored procedure object
     *
     * @return the stored procedure object or null in case of delete request
     */
    public CosmosAsyncStoredProcedure getStoredProcedure() {
        return this.storedProcedure;
    }

    /**
     * Gets the Activity ID for the request.
     *
     * @return the activity id.
     */
    @Override
    public String getActivityId() {
        if (storedProcedureResponse != null) {
            return this.storedProcedureResponse.getActivityId();
        }
        return super.getActivityId();
    }

    /**
     * Gets the token used for managing client's consistency requirements.
     *
     * @return the session token.
     */
    @Override
    public String getSessionToken() {
        if (storedProcedureResponse != null) {
            return this.storedProcedureResponse.getSessionToken();
        }
        return super.getSessionToken();
    }

    /**
     * Gets the HTTP status code associated with the response.
     *
     * @return the status code.
     */
    @Override
    public int getStatusCode() {
        if (storedProcedureResponse != null) {
            return this.storedProcedureResponse.getStatusCode();
        }
        return super.getStatusCode();
    }

    /**
     * Gets the number of normalized requests charged.
     *
     * @return the request charge.
     */
    @Override
    public double getRequestCharge() {
        if (storedProcedureResponse != null) {
            return storedProcedureResponse.getRequestCharge();
        }
        return super.getRequestCharge();
    }

    /**
     * Gets the response of the stored procedure as a string.
     *
     * @return the response as a string.
     */
    public String getResponseAsString() {
        return this.storedProcedureResponse.getResponseAsString();
    }

    /**
     * Gets the output from stored procedure console.log() statements.
     *
     * @return the output string from the stored procedure console.log() statements.
     */
    public String getScriptLog() {
        return this.storedProcedureResponse.getScriptLog();
    }
}