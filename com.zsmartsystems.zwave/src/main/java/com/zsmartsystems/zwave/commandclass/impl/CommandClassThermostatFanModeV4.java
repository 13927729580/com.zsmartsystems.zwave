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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_THERMOSTAT_FAN_MODE</b> version <b>4</b>.<br>
 *
 * Command Class Thermostat Fan Mode<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassThermostatFanModeV4 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassThermostatFanModeV4.class);

    /**
     * Integer command class key for COMMAND_CLASS_THERMOSTAT_FAN_MODE
     */
    public final static int COMMAND_CLASS_KEY = 0x44;

    /**
     * Thermostat Fan Mode Set Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SET = 0x01;
    /**
     * Thermostat Fan Mode Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_GET = 0x02;
    /**
     * Thermostat Fan Mode Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_REPORT = 0x03;
    /**
     * Thermostat Fan Mode Supported Get Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_GET = 0x04;
    /**
     * Thermostat Fan Mode Supported Report Command Constant
     */
    public final static int THERMOSTAT_FAN_MODE_SUPPORTED_REPORT = 0x05;

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SET command.<br>
     *
     * Thermostat Fan Mode Set<br>
     *
     *
     * @param fanMode {@link String}
     * @param off {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSet(String fanMode, Boolean off) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SET);

        // Process 'Properties1'
        int valProperties1 = 0;
        int valfanMode;
        switch (fanMode) {
            case "AUTO_LOW":
                valfanMode = 0;
                break;
            case "LOW":
                valfanMode = 1;
                break;
            case "AUTO_HIGH":
                valfanMode = 2;
                break;
            case "HIGH":
                valfanMode = 3;
                break;
            case "AUTO_MEDIUM":
                valfanMode = 4;
                break;
            case "MEDIUM":
                valfanMode = 5;
                break;
            case "CIRCULATION":
                valfanMode = 6;
                break;
            case "HUMIDITY":
                valfanMode = 7;
                break;
            case "LEFT_RIGHT":
                valfanMode = 8;
                break;
            case "UP_DOWN":
                valfanMode = 9;
                break;
            case "QUIET":
                valfanMode = 10;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for fanMode: " + fanMode);
        }
        valProperties1 |= valfanMode & 0x0F;
        valProperties1 |= off ? 0x80 : 0;
        outputData.write(valProperties1);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SET command<br>
     *
     * Thermostat Fan Mode Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * <li>OFF {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch ((int) payload[2] & 0x0F) {
            case 0x00:
                response.put("FAN_MODE", "AUTO_LOW");
                break;
            case 0x01:
                response.put("FAN_MODE", "LOW");
                break;
            case 0x02:
                response.put("FAN_MODE", "AUTO_HIGH");
                break;
            case 0x03:
                response.put("FAN_MODE", "HIGH");
                break;
            case 0x04:
                response.put("FAN_MODE", "AUTO_MEDIUM");
                break;
            case 0x05:
                response.put("FAN_MODE", "MEDIUM");
                break;
            case 0x06:
                response.put("FAN_MODE", "CIRCULATION");
                break;
            case 0x07:
                response.put("FAN_MODE", "HUMIDITY");
                break;
            case 0x08:
                response.put("FAN_MODE", "LEFT_RIGHT");
                break;
            case 0x09:
                response.put("FAN_MODE", "UP_DOWN");
                break;
            case 0x0A:
                response.put("FAN_MODE", "QUIET");
                break;
            default:
                logger.debug("Unknown enum value {} for FAN_MODE", String.format("0x%02X", 2));
        }
        response.put("OFF", new Boolean((payload[2] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_GET command.<br>
     *
     * Thermostat Fan Mode Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_GET command<br>
     *
     * Thermostat Fan Mode Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_REPORT command.<br>
     *
     * Thermostat Fan Mode Report<br>
     *
     *
     * @param fanMode {@link String}
     * @param off {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeReport(String fanMode, Boolean off) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        int valfanMode;
        switch (fanMode) {
            case "AUTO_LOW":
                valfanMode = 0;
                break;
            case "LOW":
                valfanMode = 1;
                break;
            case "AUTO_HIGH":
                valfanMode = 2;
                break;
            case "HIGH":
                valfanMode = 3;
                break;
            case "AUTO_MEDIUM":
                valfanMode = 4;
                break;
            case "MEDIUM":
                valfanMode = 5;
                break;
            case "CIRCULATION":
                valfanMode = 6;
                break;
            case "HUMIDITY":
                valfanMode = 7;
                break;
            case "LEFT_RIGHT":
                valfanMode = 8;
                break;
            case "UP_DOWN":
                valfanMode = 9;
                break;
            case "QUIET":
                valfanMode = 10;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for fanMode: " + fanMode);
        }
        valProperties1 |= valfanMode & 0x0F;
        valProperties1 |= off ? 0x80 : 0;
        outputData.write(valProperties1);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_REPORT command<br>
     *
     * Thermostat Fan Mode Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>FAN_MODE {@link String}
     * <li>OFF {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch ((int) payload[2] & 0x0F) {
            case 0x00:
                response.put("FAN_MODE", "AUTO_LOW");
                break;
            case 0x01:
                response.put("FAN_MODE", "LOW");
                break;
            case 0x02:
                response.put("FAN_MODE", "AUTO_HIGH");
                break;
            case 0x03:
                response.put("FAN_MODE", "HIGH");
                break;
            case 0x04:
                response.put("FAN_MODE", "AUTO_MEDIUM");
                break;
            case 0x05:
                response.put("FAN_MODE", "MEDIUM");
                break;
            case 0x06:
                response.put("FAN_MODE", "CIRCULATION");
                break;
            case 0x07:
                response.put("FAN_MODE", "HUMIDITY");
                break;
            case 0x08:
                response.put("FAN_MODE", "LEFT_RIGHT");
                break;
            case 0x09:
                response.put("FAN_MODE", "UP_DOWN");
                break;
            case 0x0A:
                response.put("FAN_MODE", "QUIET");
                break;
            default:
                logger.debug("Unknown enum value {} for FAN_MODE", String.format("0x%02X", 2));
        }
        response.put("OFF", new Boolean((payload[2] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command.<br>
     *
     * Thermostat Fan Mode Supported Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedGet() {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_GET command<br>
     *
     * Thermostat Fan Mode Supported Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command.<br>
     *
     * Thermostat Fan Mode Supported Report<br>
     *
     *
     * @param bitMask {@link List<String>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getThermostatFanModeSupportedReport(List<String> bitMask) {
        logger.debug("Creating command message THERMOSTAT_FAN_MODE_SUPPORTED_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(THERMOSTAT_FAN_MODE_SUPPORTED_REPORT);

        // Process 'Bit Mask'
        int valBitMask = 0;
        valBitMask |= (bitMask.contains("AUTO") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("LOW") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("AUTO_HIGH") ? 0x04 : 0);
        valBitMask |= (bitMask.contains("HIGH") ? 0x08 : 0);
        valBitMask |= (bitMask.contains("AUTO_MEDIUM") ? 0x10 : 0);
        valBitMask |= (bitMask.contains("MEDIUM") ? 0x20 : 0);
        valBitMask |= (bitMask.contains("CIRCULATION") ? 0x40 : 0);
        valBitMask |= (bitMask.contains("HUMIDITY_CIRCULATION") ? 0x80 : 0);
        outputData.write(valBitMask);
        valBitMask = 0;
        valBitMask |= (bitMask.contains("LEFT_RIGHT") ? 0x01 : 0);
        valBitMask |= (bitMask.contains("UP_DOWN") ? 0x02 : 0);
        valBitMask |= (bitMask.contains("QUIET") ? 0x04 : 0);
        outputData.write(valBitMask);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the THERMOSTAT_FAN_MODE_SUPPORTED_REPORT command<br>
     *
     * Thermostat Fan Mode Supported Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>BIT_MASK {@link List}<{@link String}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleThermostatFanModeSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Bit Mask'
        List<String> responseBitMask = new ArrayList<String>();
        int cntBitMask = 0;
        while (cntBitMask < payload.length - 2) {
            if ((payload[2 + (cntBitMask / 8)] & cntBitMask % 8) == 0) {
                continue;
            }
            switch (cntBitMask) {
                case 0x00:
                    responseBitMask.add("AUTO");
                    break;
                case 0x01:
                    responseBitMask.add("LOW");
                    break;
                case 0x02:
                    responseBitMask.add("AUTO_HIGH");
                    break;
                case 0x03:
                    responseBitMask.add("HIGH");
                    break;
                case 0x04:
                    responseBitMask.add("AUTO_MEDIUM");
                    break;
                case 0x05:
                    responseBitMask.add("MEDIUM");
                    break;
                case 0x06:
                    responseBitMask.add("CIRCULATION");
                    break;
                case 0x07:
                    responseBitMask.add("HUMIDITY_CIRCULATION");
                    break;
                case 0x08:
                    responseBitMask.add("LEFT_RIGHT");
                    break;
                case 0x09:
                    responseBitMask.add("UP_DOWN");
                    break;
                case 0x0A:
                    responseBitMask.add("QUIET");
                    break;
                default:
                    responseBitMask.add("BITMASK_" + cntBitMask);
                    break;
            }
        }
        response.put("BIT_MASK", responseBitMask);

        // Return the map of processed response data;
        return response;
    }

}
