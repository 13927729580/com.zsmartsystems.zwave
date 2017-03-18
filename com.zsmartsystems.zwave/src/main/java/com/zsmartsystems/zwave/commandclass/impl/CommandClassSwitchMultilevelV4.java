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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SWITCH_MULTILEVEL</b> version <b>4</b>.<br>
 * <p>
 * Command Class Switch Multilevel<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSwitchMultilevelV4 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSwitchMultilevelV4.class);

    /**
     * Integer command class key for COMMAND_CLASS_SWITCH_MULTILEVEL
     */
    public final static int COMMAND_CLASS_KEY = 0x26;

    /**
     * Switch Multilevel Set Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SET = 0x01;
    /**
     * Switch Multilevel Get Command Constant
     */
    public final static int SWITCH_MULTILEVEL_GET = 0x02;
    /**
     * Switch Multilevel Report Command Constant
     */
    public final static int SWITCH_MULTILEVEL_REPORT = 0x03;
    /**
     * Switch Multilevel Start Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_START_LEVEL_CHANGE = 0x04;
    /**
     * Switch Multilevel Stop Level Change Command Constant
     */
    public final static int SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE = 0x05;
    /**
     * Switch Multilevel Supported Get Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SUPPORTED_GET = 0x06;
    /**
     * Switch Multilevel Supported Report Command Constant
     */
    public final static int SWITCH_MULTILEVEL_SUPPORTED_REPORT = 0x07;

    // Constants for Duration
    private static Map<Integer, String> constantDuration = new HashMap<Integer, String>();
    // Constants for Dimming Duration
    private static Map<Integer, String> constantDimmingDuration = new HashMap<Integer, String>();

    static {
        // Constants for Duration
        constantDuration.put(0xFE, "UNKNOWN_DURATION");
        constantDuration.put(0x00, "ALREADY_AT_THE_TARGET_VALUE");
        // Constants for Dimming Duration
        constantDimmingDuration.put(0x00, "INSTANTLY");
        constantDimmingDuration.put(0xFF, "DEFAULT");
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SET command.<br>
     * <p>
     * Switch Multilevel Set<br>
     *
     * @param value {@link Integer}
     * @param dimmingDuration {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSet(Integer value, String dimmingDuration) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SET);

        // Process 'Value'
        outputData.write(value);

        // Process 'Dimming Duration'
        for (Integer entry : constantDimmingDuration.keySet()) {
            if (constantDimmingDuration.get(entry).equals(dimmingDuration)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SET command<br>
     * <p>
     * Switch Multilevel Set<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>VALUE {@link Integer}
     * <li>DIMMING_DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Value'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("VALUE", "OFF_DISABLE");
                break;
            case 0xFF:
                response.put("VALUE", "ON_ENABLE");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", constantDimmingDuration.get(payload[3] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_GET command.<br>
     * <p>
     * Switch Multilevel Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelGet() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_GET command<br>
     * <p>
     * Switch Multilevel Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_REPORT command.<br>
     * <p>
     * Switch Multilevel Report<br>
     *
     * @param currentValue {@link Integer}
     * @param targetValue {@link Integer}
     * @param duration {@link String}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelReport(Integer currentValue, Integer targetValue, String duration) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_REPORT);

        // Process 'Current Value'
        outputData.write(currentValue);

        // Process 'Target Value'
        outputData.write(targetValue);

        // Process 'Duration'
        for (Integer entry : constantDuration.keySet()) {
            if (constantDuration.get(entry).equals(duration)) {
                outputData.write(entry);
                break;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_REPORT command<br>
     * <p>
     * Switch Multilevel Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>CURRENT_VALUE {@link Integer}
     * <li>TARGET_VALUE {@link Integer}
     * <li>DURATION {@link String}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Current Value'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("CURRENT_VALUE", "OFF_DISABLE");
                break;
            case 0xFF:
                response.put("CURRENT_VALUE", "ON_ENABLE");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Target Value'
        response.put("TARGET_VALUE", Integer.valueOf(payload[3]));

        // Process 'Duration'
        response.put("DURATION", constantDuration.get(payload[4] & 0xff));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command.<br>
     * <p>
     * Switch Multilevel Start Level Change<br>
     *
     * @param incDec {@link String}
     * @param ignoreStartLevel {@link Boolean}
     * @param upDown {@link String}
     * @param startLevel {@link Integer}
     * @param dimmingDuration {@link Integer}
     * @param stepSize {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStartLevelChange(String incDec, Boolean ignoreStartLevel, String upDown,
            Integer startLevel, Integer dimmingDuration, Integer stepSize) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_START_LEVEL_CHANGE version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_START_LEVEL_CHANGE);

        // Process 'Properties1'
        int valProperties1 = 0;
        int valincDec;
        switch (incDec) {
            case "INCREMENT":
                valincDec = 0;
                break;
            case "DECREMENT":
                valincDec = 1;
                break;
            case "NONE":
                valincDec = 3;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for incDec: " + incDec);
        }
        valProperties1 |= valincDec >> 3 & 0x18;
        valProperties1 |= ignoreStartLevel ? 0x20 : 0;
        int valupDown;
        switch (upDown) {
            case "UP":
                valupDown = 0;
                break;
            case "DOWN":
                valupDown = 1;
                break;
            case "NONE":
                valupDown = 3;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for upDown: " + upDown);
        }
        valProperties1 |= valupDown >> 6 & 0xC0;
        outputData.write(valProperties1);

        // Process 'Start Level'
        outputData.write(startLevel);

        // Process 'Dimming Duration'
        outputData.write(dimmingDuration);

        // Process 'Step Size'
        outputData.write(stepSize);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_START_LEVEL_CHANGE command<br>
     * <p>
     * Switch Multilevel Start Level Change<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>INC_DEC {@link String}
     * <li>IGNORE_START_LEVEL {@link Boolean}
     * <li>UP_DOWN {@link String}
     * <li>START_LEVEL {@link Integer}
     * <li>DIMMING_DURATION {@link Integer}
     * <li>STEP_SIZE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStartLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        switch ((payload[2] & 0x18) >> 3) {
            case 0x00:
                response.put("INC_DEC", "INCREMENT");
                break;
            case 0x01:
                response.put("INC_DEC", "DECREMENT");
                break;
            case 0x03:
                response.put("INC_DEC", "NONE");
                break;
            default:
                logger.debug("Unknown enum value {} for INC_DEC", String.format("0x%02X", 2));
        }
        response.put("IGNORE_START_LEVEL", Boolean.valueOf((payload[2] & 0x20) != 0));
        switch ((payload[2] & 0xC0) >> 6) {
            case 0x00:
                response.put("UP_DOWN", "UP");
                break;
            case 0x01:
                response.put("UP_DOWN", "DOWN");
                break;
            case 0x03:
                response.put("UP_DOWN", "NONE");
                break;
            default:
                logger.debug("Unknown enum value {} for UP_DOWN", String.format("0x%02X", 2));
        }

        // Process 'Start Level'
        response.put("START_LEVEL", Integer.valueOf(payload[3]));

        // Process 'Dimming Duration'
        response.put("DIMMING_DURATION", Integer.valueOf(payload[4]));

        // Process 'Step Size'
        response.put("STEP_SIZE", Integer.valueOf(payload[5]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command.<br>
     * <p>
     * Switch Multilevel Stop Level Change<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelStopLevelChange() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_STOP_LEVEL_CHANGE command<br>
     * <p>
     * Switch Multilevel Stop Level Change<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelStopLevelChange(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SUPPORTED_GET command.<br>
     * <p>
     * Switch Multilevel Supported Get<br>
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSupportedGet() {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SUPPORTED_GET version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SUPPORTED_GET command<br>
     * <p>
     * Switch Multilevel Supported Get<br>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SWITCH_MULTILEVEL_SUPPORTED_REPORT command.<br>
     * <p>
     * Switch Multilevel Supported Report<br>
     *
     * @param primarySwitchType {@link Integer}
     * @param secondarySwitchType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSwitchMultilevelSupportedReport(Integer primarySwitchType, Integer secondarySwitchType) {
        logger.debug("Creating command message SWITCH_MULTILEVEL_SUPPORTED_REPORT version 4");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SWITCH_MULTILEVEL_SUPPORTED_REPORT);

        // Process 'Properties1'
        outputData.write(primarySwitchType & 0x1F);

        // Process 'Properties2'
        outputData.write(secondarySwitchType & 0x1F);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SWITCH_MULTILEVEL_SUPPORTED_REPORT command<br>
     * <p>
     * Switch Multilevel Supported Report<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>PRIMARY_SWITCH_TYPE {@link Integer}
     * <li>SECONDARY_SWITCH_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSwitchMultilevelSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("PRIMARY_SWITCH_TYPE", Integer.valueOf(payload[2] & 0x1F));

        // Process 'Properties2'
        response.put("SECONDARY_SWITCH_TYPE", Integer.valueOf(payload[3] & 0x1F));

        // Return the map of processed response data;
        return response;
    }

}
