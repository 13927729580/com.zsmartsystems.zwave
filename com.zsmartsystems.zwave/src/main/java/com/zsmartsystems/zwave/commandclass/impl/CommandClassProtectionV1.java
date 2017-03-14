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
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_PROTECTION</b> version <b>1</b>.<br>
 *
 * Command Class Protection<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassProtectionV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassProtectionV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_PROTECTION
     */
    public final static int COMMAND_CLASS_KEY = 0x75;

    /**
     * Protection Set Command Constant
     */
    public final static int PROTECTION_SET = 0x01;
    /**
     * Protection Get Command Constant
     */
    public final static int PROTECTION_GET = 0x02;
    /**
     * Protection Report Command Constant
     */
    public final static int PROTECTION_REPORT = 0x03;

    /**
     * Creates a new message with the PROTECTION_SET command.<br>
     *
     * Protection Set<br>
     *
     *
     * @param protectionState {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionSet(String protectionState) {
        logger.debug("Creating command message PROTECTION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_SET);

        // Process 'Protection State'
        switch (protectionState) {
            case "UNPROTECTED":
                outputData.write(0x00);
                break;
            case "PROTECTION_BY_SEQUENCE":
                outputData.write(0x01);
                break;
            case "NO_OPERATION_POSSIBLE":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for protectionState: " + protectionState);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_SET command<br>
     *
     * Protection Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>PROTECTION_STATE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Protection State'
        switch ((int) payload[2]) {
            case (byte) 0x00:
                response.put("PROTECTION_STATE", "UNPROTECTED");
                break;
            case (byte) 0x01:
                response.put("PROTECTION_STATE", "PROTECTION_BY_SEQUENCE");
                break;
            case (byte) 0x02:
                response.put("PROTECTION_STATE", "NO_OPERATION_POSSIBLE");
                break;
            default:
                logger.debug("Unknown value {} for constant 'PROTECTION_STATE'", String.format("%02X", payload[2]));
                response.put("PROTECTION_STATE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_GET command.<br>
     *
     * Protection Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionGet() {
        logger.debug("Creating command message PROTECTION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_GET command<br>
     *
     * Protection Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the PROTECTION_REPORT command.<br>
     *
     * Protection Report<br>
     *
     *
     * @param protectionState {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getProtectionReport(String protectionState) {
        logger.debug("Creating command message PROTECTION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(PROTECTION_REPORT);

        // Process 'Protection State'
        switch (protectionState) {
            case "UNPROTECTED":
                outputData.write(0x00);
                break;
            case "PROTECTION_BY_SEQUENCE":
                outputData.write(0x01);
                break;
            case "NO_OPERATION_POSSIBLE":
                outputData.write(0x02);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for protectionState: " + protectionState);
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the PROTECTION_REPORT command<br>
     *
     * Protection Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>PROTECTION_STATE {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleProtectionReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Protection State'
        switch ((int) payload[2]) {
            case (byte) 0x00:
                response.put("PROTECTION_STATE", "UNPROTECTED");
                break;
            case (byte) 0x01:
                response.put("PROTECTION_STATE", "PROTECTION_BY_SEQUENCE");
                break;
            case (byte) 0x02:
                response.put("PROTECTION_STATE", "NO_OPERATION_POSSIBLE");
                break;
            default:
                logger.debug("Unknown value {} for constant 'PROTECTION_STATE'", String.format("%02X", payload[2]));
                response.put("PROTECTION_STATE", "UNKNOWN_" + String.format("%02X", payload[2]));
                break;
        }

        // Return the map of processed response data;
        return response;
    }

}
