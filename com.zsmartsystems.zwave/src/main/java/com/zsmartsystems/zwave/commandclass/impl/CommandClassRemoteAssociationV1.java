/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_REMOTE_ASSOCIATION</b> version <b>1</b>.<br>
 *
 * Command Class Remote Association<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassRemoteAssociationV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassRemoteAssociationV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_REMOTE_ASSOCIATION
     */
    public final static int COMMAND_CLASS_KEY = 0x7D;

    /**
     * Remote Association Configuration Set Command Constant
     */
    public final static int REMOTE_ASSOCIATION_CONFIGURATION_SET = 0x01;
    /**
     * Remote Association Configuration Get Command Constant
     */
    public final static int REMOTE_ASSOCIATION_CONFIGURATION_GET = 0x02;
    /**
     * Remote Association Configuration Report Command Constant
     */
    public final static int REMOTE_ASSOCIATION_CONFIGURATION_REPORT = 0x03;

    /**
     * Creates a new message with the REMOTE_ASSOCIATION_CONFIGURATION_SET command.<br>
     *
     * Remote Association Configuration Set<br>
     *
     *
     * @param localGroupingIdentifier {@link Integer}
     * @param remoteNodeid {@link Integer}
     * @param remoteGroupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getRemoteAssociationConfigurationSet(Integer localGroupingIdentifier, Integer remoteNodeid,
            Integer remoteGroupingIdentifier) {
        logger.debug("Creating command message REMOTE_ASSOCIATION_CONFIGURATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(REMOTE_ASSOCIATION_CONFIGURATION_SET);

        // Process 'Local Grouping identifier'
        outputData.write(localGroupingIdentifier);

        // Process 'Remote NodeID'
        // Check the node number boundary
        if (remoteNodeid < 1 || remoteNodeid > 232) {
            logger.debug("Node number is out of bounds {}", remoteNodeid);
            return null;
        }
        outputData.write(remoteNodeid);

        // Process 'Remote Grouping identifier'
        outputData.write(remoteGroupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the REMOTE_ASSOCIATION_CONFIGURATION_SET command<br>
     *
     * Remote Association Configuration Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCAL_GROUPING_IDENTIFIER {@link Integer}
     * <li>REMOTE_NODEID {@link Integer}
     * <li>REMOTE_GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleRemoteAssociationConfigurationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Local Grouping identifier'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("LOCAL_GROUPING_IDENTIFIER", "ERASE_ALL_LIN");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Remote NodeID'
        switch ((int) payload[3]) {
            case 0x00:
                response.put("REMOTE_NODEID", "REMOVE_A_LINK");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Remote Grouping identifier'
        response.put("REMOTE_GROUPING_IDENTIFIER", new Integer(payload[4]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the REMOTE_ASSOCIATION_CONFIGURATION_GET command.<br>
     *
     * Remote Association Configuration Get<br>
     *
     *
     * @param localGroupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getRemoteAssociationConfigurationGet(Integer localGroupingIdentifier) {
        logger.debug("Creating command message REMOTE_ASSOCIATION_CONFIGURATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(REMOTE_ASSOCIATION_CONFIGURATION_GET);

        // Process 'Local Grouping identifier'
        outputData.write(localGroupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the REMOTE_ASSOCIATION_CONFIGURATION_GET command<br>
     *
     * Remote Association Configuration Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCAL_GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleRemoteAssociationConfigurationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Local Grouping identifier'
        response.put("LOCAL_GROUPING_IDENTIFIER", new Integer(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the REMOTE_ASSOCIATION_CONFIGURATION_REPORT command.<br>
     *
     * Remote Association Configuration Report<br>
     *
     *
     * @param localGroupingIdentifier {@link Integer}
     * @param remoteNodeid {@link Integer}
     * @param remoteGroupingIdentifier {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getRemoteAssociationConfigurationReport(Integer localGroupingIdentifier, Integer remoteNodeid,
            Integer remoteGroupingIdentifier) {
        logger.debug("Creating command message REMOTE_ASSOCIATION_CONFIGURATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(REMOTE_ASSOCIATION_CONFIGURATION_REPORT);

        // Process 'Local Grouping identifier'
        outputData.write(localGroupingIdentifier);

        // Process 'Remote NodeID'
        // Check the node number boundary
        if (remoteNodeid < 1 || remoteNodeid > 232) {
            logger.debug("Node number is out of bounds {}", remoteNodeid);
            return null;
        }
        outputData.write(remoteNodeid);

        // Process 'Remote Grouping identifier'
        outputData.write(remoteGroupingIdentifier);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the REMOTE_ASSOCIATION_CONFIGURATION_REPORT command<br>
     *
     * Remote Association Configuration Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>LOCAL_GROUPING_IDENTIFIER {@link Integer}
     * <li>REMOTE_NODEID {@link Integer}
     * <li>REMOTE_GROUPING_IDENTIFIER {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleRemoteAssociationConfigurationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Local Grouping identifier'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("LOCAL_GROUPING_IDENTIFIER", "ERASE_ALL_LIN");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Remote NodeID'
        switch ((int) payload[3]) {
            case 0x00:
                response.put("REMOTE_NODEID", "REMOVE_A_LINK");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Remote Grouping identifier'
        response.put("REMOTE_GROUPING_IDENTIFIER", new Integer(payload[4]));

        // Return the map of processed response data;
        return response;
    }

}
