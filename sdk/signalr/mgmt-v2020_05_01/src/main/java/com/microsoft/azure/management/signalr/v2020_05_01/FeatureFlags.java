/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.signalr.v2020_05_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for FeatureFlags.
 */
public final class FeatureFlags extends ExpandableStringEnum<FeatureFlags> {
    /** Static value ServiceMode for FeatureFlags. */
    public static final FeatureFlags SERVICE_MODE = fromString("ServiceMode");

    /** Static value EnableConnectivityLogs for FeatureFlags. */
    public static final FeatureFlags ENABLE_CONNECTIVITY_LOGS = fromString("EnableConnectivityLogs");

    /** Static value EnableMessagingLogs for FeatureFlags. */
    public static final FeatureFlags ENABLE_MESSAGING_LOGS = fromString("EnableMessagingLogs");

    /**
     * Creates or finds a FeatureFlags from its string representation.
     * @param name a name to look for
     * @return the corresponding FeatureFlags
     */
    @JsonCreator
    public static FeatureFlags fromString(String name) {
        return fromString(name, FeatureFlags.class);
    }

    /**
     * @return known FeatureFlags values
     */
    public static Collection<FeatureFlags> values() {
        return values(FeatureFlags.class);
    }
}