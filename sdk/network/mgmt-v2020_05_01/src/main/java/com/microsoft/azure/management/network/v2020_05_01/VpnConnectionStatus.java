/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for VpnConnectionStatus.
 */
public final class VpnConnectionStatus extends ExpandableStringEnum<VpnConnectionStatus> {
    /** Static value Unknown for VpnConnectionStatus. */
    public static final VpnConnectionStatus UNKNOWN = fromString("Unknown");

    /** Static value Connecting for VpnConnectionStatus. */
    public static final VpnConnectionStatus CONNECTING = fromString("Connecting");

    /** Static value Connected for VpnConnectionStatus. */
    public static final VpnConnectionStatus CONNECTED = fromString("Connected");

    /** Static value NotConnected for VpnConnectionStatus. */
    public static final VpnConnectionStatus NOT_CONNECTED = fromString("NotConnected");

    /**
     * Creates or finds a VpnConnectionStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding VpnConnectionStatus
     */
    @JsonCreator
    public static VpnConnectionStatus fromString(String name) {
        return fromString(name, VpnConnectionStatus.class);
    }

    /**
     * @return known VpnConnectionStatus values
     */
    public static Collection<VpnConnectionStatus> values() {
        return values(VpnConnectionStatus.class);
    }
}