/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_HUMIDITY_CONTROL_OPERATING_STATE</b> version <b>1</b>.
 * <p>
 * Command Class Humidity Control Operating State
 * <p>
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.
 * <p>
 * Command class key is 0x6E.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassHumidityControlOperatingStateV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassHumidityControlOperatingStateV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_HUMIDITY_CONTROL_OPERATING_STATE
     */
    public final static int COMMAND_CLASS_KEY = 0x6E;

    /**
     * Humidity Control Operating State Get Command Constant
     */
    public final static int HUMIDITY_CONTROL_OPERATING_STATE_GET = 0x01;
    /**
     * Humidity Control Operating State Report Command Constant
     */
    public final static int HUMIDITY_CONTROL_OPERATING_STATE_REPORT = 0x02;

    /**
     * Map holding constants for HumidityControlOperatingStateReportOperatingState
     */
    private static Map<Integer, String> constantHumidityControlOperatingStateReportOperatingState = new HashMap<Integer, String>();

    static {
        // Constants for HumidityControlOperatingStateReportOperatingState
        constantHumidityControlOperatingStateReportOperatingState.put(0x00, "IDLE");
        constantHumidityControlOperatingStateReportOperatingState.put(0x01, "HUMIDIFYING");
        constantHumidityControlOperatingStateReportOperatingState.put(0x02, "DEHUMIDIFYING");
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_OPERATING_STATE_GET command.
     * <p>
     * Humidity Control Operating State Get
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlOperatingStateGet() {
        logger.debug("Creating command message HUMIDITY_CONTROL_OPERATING_STATE_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_OPERATING_STATE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_OPERATING_STATE_GET command.
     * <p>
     * Humidity Control Operating State Get
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleHumidityControlOperatingStateGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the HUMIDITY_CONTROL_OPERATING_STATE_REPORT command.
     * <p>
     * Humidity Control Operating State Report
     *
     * @param operatingState {@link String}
     *            Can be one of the following -:
     *            <p>
     *            <ul>
     *            <li>IDLE
     *            <li>HUMIDIFYING
     *            <li>DEHUMIDIFYING
     *            </ul>
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getHumidityControlOperatingStateReport(String operatingState) {
        logger.debug("Creating command message HUMIDITY_CONTROL_OPERATING_STATE_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(HUMIDITY_CONTROL_OPERATING_STATE_REPORT);

        // Process 'Properties1'
        int varOperatingState = Integer.MAX_VALUE;
        for (Integer entry : constantHumidityControlOperatingStateReportOperatingState.keySet()) {
            if (constantHumidityControlOperatingStateReportOperatingState.get(entry).equals(operatingState)) {
                varOperatingState = entry;
                break;
            }
        }
        if (varOperatingState == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unknown constant value '" + operatingState + "' for operatingState");
        }
        outputData.write(varOperatingState & 0x0F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the HUMIDITY_CONTROL_OPERATING_STATE_REPORT command.
     * <p>
     * Humidity Control Operating State Report
     * <p>
     * The output data {@link Map} has the following properties -:
     *
     * <ul>
     * <li>OPERATING_STATE {@link String}
     * Can be one of the following -:
     * <p>
     * <ul>
     * <li>IDLE
     * <li>HUMIDIFYING
     * <li>DEHUMIDIFYING
     * </ul>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleHumidityControlOperatingStateReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("OPERATING_STATE", constantHumidityControlOperatingStateReportOperatingState.get(payload[2] & 0x0F));

        // Return the map of processed response data;
        return response;
    }
}
