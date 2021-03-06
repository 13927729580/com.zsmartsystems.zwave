/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl.loopback;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.List;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassMultiInstanceAssociationV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_MULTI_INSTANCE_ASSOCIATION</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMultiInstanceAssociationV1LoopbackTest {
    /**
     * Performs an in/out test of the MULTI_INSTANCE_ASSOCIATION_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     * @param nodeId {@link byte[]}
     */
    public static void testMultiInstanceAssociationSetLoopback(Integer groupingIdentifier, byte[] nodeId) {
        byte[] testPayload = CommandClassMultiInstanceAssociationV1.getMultiInstanceAssociationSet(groupingIdentifier,
                nodeId);

        Map<String, Object> response = CommandClassMultiInstanceAssociationV1.handleMultiInstanceAssociationSet(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
        assertEquals(nodeId, (byte[]) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the MULTI_INSTANCE_ASSOCIATION_GET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     */
    public static void testMultiInstanceAssociationGetLoopback(Integer groupingIdentifier) {
        byte[] testPayload = CommandClassMultiInstanceAssociationV1.getMultiInstanceAssociationGet(groupingIdentifier);

        Map<String, Object> response = CommandClassMultiInstanceAssociationV1.handleMultiInstanceAssociationGet(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
    }

    /**
     * Performs an in/out test of the MULTI_INSTANCE_ASSOCIATION_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     * @param maxNodesSupported {@link Integer}
     * @param reportsToFollow {@link Integer}
     * @param nodeId {@link byte[]}
     */
    public static void testMultiInstanceAssociationReportLoopback(Integer groupingIdentifier, Integer maxNodesSupported,
            Integer reportsToFollow, byte[] nodeId) {
        byte[] testPayload = CommandClassMultiInstanceAssociationV1.getMultiInstanceAssociationReport(groupingIdentifier,
                maxNodesSupported, reportsToFollow, nodeId);

        Map<String, Object> response = CommandClassMultiInstanceAssociationV1.handleMultiInstanceAssociationReport(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
        assertEquals(maxNodesSupported, (Integer) response.get("MAX_NODES_SUPPORTED"));
        assertEquals(reportsToFollow, (Integer) response.get("REPORTS_TO_FOLLOW"));
        assertEquals(nodeId, (byte[]) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the MULTI_INSTANCE_ASSOCIATION_REMOVE command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param groupingIdentifier {@link Integer}
     * @param nodeId {@link byte[]}
     */
    public static void testMultiInstanceAssociationRemoveLoopback(Integer groupingIdentifier, byte[] nodeId) {
        byte[] testPayload = CommandClassMultiInstanceAssociationV1.getMultiInstanceAssociationRemove(groupingIdentifier,
                nodeId);

        Map<String, Object> response = CommandClassMultiInstanceAssociationV1.handleMultiInstanceAssociationRemove(testPayload);
        assertEquals(groupingIdentifier, (Integer) response.get("GROUPING_IDENTIFIER"));
        assertEquals(nodeId, (byte[]) response.get("NODE_ID"));
    }

    /**
     * Performs an in/out test of the MULTI_INSTANCE_ASSOCIATION_GROUPINGS_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param supportedGroupings {@link Integer}
     */
    public static void testMultiInstanceAssociationGroupingsReportLoopback(Integer supportedGroupings) {
        byte[] testPayload = CommandClassMultiInstanceAssociationV1.getMultiInstanceAssociationGroupingsReport(
                supportedGroupings);

        Map<String, Object> response = CommandClassMultiInstanceAssociationV1.handleMultiInstanceAssociationGroupingsReport(testPayload);
        assertEquals(supportedGroupings, (Integer) response.get("SUPPORTED_GROUPINGS"));
    }

}
